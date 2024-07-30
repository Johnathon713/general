package org.john.general.user.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.john.general.user.domain.User;
import org.john.general.user.domain.bo.UserBo;
import org.john.general.user.mapper.UserMapper;
import org.john.general.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Johnathon
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserMapper userMapper;

    @Override
    @DS("master_1")
    public Integer save(UserBo userBo) {
        User user = new User(new User());
        // todo 此处使用登录框架之后需要改成实际的用户
        user.setUserName(userBo.getUserName());
        user.setNickName(userBo.getNickName());
        byte[] salt = KeyUtil.generateKey(SM4.ALGORITHM_NAME, 128).getEncoded();
        user.setPassword(SmUtil.sm4(salt).encryptHex(userBo.getPassword()));
        user.setSalt(Base64.encode(salt));
        user.setGender(userBo.getGender());
        user.setEmail(userBo.getEmail());
        user.setPhone(userBo.getPhone());
        user.setRegChannel(userBo.getRegChannel());
        user.setAvatar(userBo.getAvatar());
        return userMapper.insert(user);
    }
}
