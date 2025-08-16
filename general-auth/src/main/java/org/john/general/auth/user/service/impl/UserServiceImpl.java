package org.john.general.auth.user.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SM4;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.john.general.auth.device.exception.DeviceException;
import org.john.general.auth.user.entity.*;
import org.john.general.auth.user.exception.UserException;
import org.john.general.auth.user.mapper.UserMapper;
import org.john.general.auth.user.service.UserRecordService;
import org.john.general.auth.user.service.UserService;
import org.john.general.base.utils.MapstructUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author llxx
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
    private final UserMapper userMapper;
    private final StringRedisTemplate redisTemplate;
    private final UserRecordService userRecordService;

    @Override
    @DS("slave")
    @Cacheable(cacheNames = "general:auth-service:cache:user", key = "#{userId}")
    public UserVO selectVoById(Long userId) {
        return userMapper.selectVoById(userId);
    }

    @Override
    @DS("master")
    public UserVO insert(UserBO userBO) {
        if (!StrUtil.equals(userBO.getPassword(), userBO.getConfirmPassword())) {
            throw new UserException("两次密码不一致");
        }
        String userName = userBO.getUserName();
        String email = userBO.getEmail();
        String phone = userBO.getPhone();
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", email).or().eq("user_name", userName).or().eq("user_name", phone);
        queryWrapper.eq("email", email).or().eq("email", userName).or().eq("email", phone);
        queryWrapper.eq("phone", email).or().eq("phone", userName).or().eq("phone", phone);
        long count = count(queryWrapper);
        if (count > 0) {
            throw new UserException("用户已存在");
        }
        Long userSerialNumber = redisTemplate.opsForValue().increment("generator:id:userSerialNumber");
        assert userSerialNumber != null;
        if (userSerialNumber < UserConstant.MIN_USER_SERIAL_NUMBER) {
            userSerialNumber = UserConstant.MIN_USER_SERIAL_NUMBER;
            redisTemplate.opsForValue().set("generator:id:userSerialNumber", String.valueOf(userSerialNumber));
        }
        UserDO userDO = MapstructUtil.convert(userBO, UserDO.class);
        assert userDO != null;
        userDO.setUserSerialNumber(userSerialNumber);
        String encryption = userDO.getEncryption();
        String nanoId = IdUtil.nanoId();
        userDO.setSalt(nanoId);
        switch (encryption) {
            case "AES":
                byte[] aesKey = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
                userDO.setPasswordKey(HexUtil.encodeHexStr(aesKey));
                AES aes = SecureUtil.aes(aesKey);
                userDO.setPassword(aes.encryptBase64(userDO.getPassword() + UserConstant.PASSWORD_SALT + userDO.getSalt()));
                break;
            case "MD5":
                userDO.setPassword(SecureUtil.md5(userDO.getPassword() + UserConstant.PASSWORD_SALT + userDO.getSalt()));
                break;
            case "SHA1":
                userDO.setPassword(SecureUtil.sha1(userDO.getPassword() + UserConstant.PASSWORD_SALT + userDO.getSalt()));
                break;
            case "SHA256":
                userDO.setPassword(SecureUtil.sha256(userDO.getPassword() + UserConstant.PASSWORD_SALT + userDO.getSalt()));
                break;
            case "SM4":
                byte[] sm4Key = SecureUtil.generateKey(SM4.ALGORITHM_NAME).getEncoded();
                userDO.setPasswordKey(HexUtil.encodeHexStr(sm4Key));
                SM4 sm4 = SmUtil.sm4(sm4Key);
                userDO.setPassword(sm4.encryptBase64(userDO.getPassword() + UserConstant.PASSWORD_SALT + userDO.getSalt()));
                break;
            default:
                throw new UserException("不支持的加密类型");
        }
        userMapper.insert(userDO);
        UserRecordDO userRecordDO = MapstructUtil.convert(userDO, UserRecordDO.class);
        userRecordService.insert(userRecordDO);
        return MapstructUtil.convert(userDO, UserVO.class);
    }

    @Override
    @DS("master")
    @Transactional
    @CachePut(cacheNames = "general:auth-service:cache:user", key = "#{userBO.userId}")
    public UserVO updateById(UserBO userBO) {
        String userName = userBO.getUserName();
        String email = userBO.getEmail();
        String phone = userBO.getPhone();
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.notIn("user_id", userBO.getUserId());
        queryWrapper.eq("user_name", email).or().eq("user_name", userName).or().eq("user_name", phone);
        queryWrapper.eq("email", email).or().eq("email", userName).or().eq("email", phone);
        queryWrapper.eq("phone", email).or().eq("phone", userName).or().eq("phone", phone);
        long count = count(queryWrapper);
        if (count > 0) {
            throw new UserException("用户信息已被占用");
        }
        UserDO userDO = userMapper.selectById(userBO.getUserId());
        if (userDO == null) {
            throw new UserException("用户不存在");
        }
        userDO.setUserName(userBO.getUserName());
        userDO.setNickName(userBO.getNickName());
        userDO.setEmail(userBO.getEmail());
        userDO.setPhone(userBO.getPhone());
        userDO.setAvatar(userBO.getAvatar());
        userMapper.updateById(userDO);
        UserRecordDO userRecordDO = MapstructUtil.convert(userDO, UserRecordDO.class);
        userRecordService.insert(userRecordDO);
        return MapstructUtil.convert(userDO, UserVO.class);
    }

    @Override
    @DS("master")
    @Transactional
    @CacheEvict(cacheNames = "general:auth-service:cache:user", key = "#{userId}")
    public Integer deleteById(Long userId) {
        UserDO userDO = userMapper.selectById(userId);
        if (userDO == null) {
            throw new UserException("要删除的用户不存在");
        }
        UserRecordDO userRecordDO = MapstructUtil.convert(userDO, UserRecordDO.class);
        assert userRecordDO != null;
        userRecordDO.setDeleted(1L);
        userRecordDO.setDeleteTime(new Date());
        //todo 这里需要增加删除用户
        userRecordDO.setDeleteUserId(null);
        userRecordService.insert(userRecordDO);
        return userMapper.deleteById(userId);
    }

    @Override
    @DS("master")
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteByIds(Collection<Long> userIds) {
        List<UserDO> userDOList = userMapper.selectByIds(userIds);
        if (CollUtil.size(userIds) != CollUtil.size(userDOList)) {
            throw new UserException("要删除的部分用户不存在");
        }
        List<UserRecordDO> userRecordList = MapstructUtil.convert(userDOList, UserRecordDO.class);
        assert userRecordList != null;
        for (UserRecordDO userRecordDO : userRecordList) {
            userRecordDO.setDeleted(1L);
            userRecordDO.setDeleteTime(new Date());
            //todo 这里需要增加删除用户
            userRecordDO.setDeleteUserId(null);
        }
        userRecordService.insert(userRecordList);
        int count = userMapper.deleteByIds(userIds);
        if (CollUtil.size(userIds) != count) {
            throw new DeviceException("数量不一致");
        }
        redisTemplate.opsForHash().delete("general:auth-service:cache:user", ArrayUtil.toArray(userIds, Long.class));
        return count;
    }

    @DS("slave")
    @Override
    public Page<UserVO> selectVoPage(UserQuery userQuery) {
        Page<UserDO> page = Page.of(userQuery.getCurrent(), userQuery.getSize());
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        if (userQuery.getUserSerialNumber() != null) {
            queryWrapper.eq("user_serial_number", userQuery.getUserSerialNumber());
        }
        if (StrUtil.isNotBlank(userQuery.getUserName())) {
            queryWrapper.likeRight("user_name", userQuery.getUserName());
        }
        if (StrUtil.isNotBlank(userQuery.getGender())) {
            queryWrapper.likeRight("gender", userQuery.getGender());
        }
        if (StrUtil.isNotBlank(userQuery.getEmail())) {
            queryWrapper.likeRight("email", userQuery.getEmail());
        }
        if (StrUtil.isNotBlank(userQuery.getPhone())) {
            queryWrapper.likeRight("phone", userQuery.getPhone());
        }
        return userMapper.selectVoPage(page, queryWrapper);
    }
}
