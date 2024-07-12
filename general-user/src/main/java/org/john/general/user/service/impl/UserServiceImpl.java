package org.john.general.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.john.general.user.domain.User;
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
}
