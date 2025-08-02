package org.john.general.auth.user.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.john.general.auth.user.entity.UserBO;
import org.john.general.auth.user.entity.UserDO;
import org.john.general.auth.user.mapper.UserMapper;
import org.john.general.auth.user.service.UserService;
import org.john.general.base.utils.MapstructUtil;
import org.springframework.stereotype.Service;

/**
 * @author llxx
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
    private final UserMapper userMapper;

    @Override
    @DS("master_1")
    public Integer save(UserBO userBo) {
        UserDO convert = MapstructUtil.convert(userBo, UserDO.class);
        UserDO user = new UserDO();
        // todo 此处使用登录框架之后需要改成实际的用户
        user.setUserName(userBo.getUserName());
        user.setNickName(userBo.getNickName());
        byte[] salt = KeyUtil.generateKey(SM4.ALGORITHM_NAME, 128).getEncoded();
        user.setPassword(SmUtil.sm4(salt).encryptHex(userBo.getPassword()));
        user.setSalt(Base64.encode(salt));
        user.setGender(userBo.getGender());
        user.setEmail(userBo.getEmail());
        user.setRegChannel(userBo.getRegChannel());
        user.setAvatar(userBo.getAvatar());
        return userMapper.insert(user);
    }
}
