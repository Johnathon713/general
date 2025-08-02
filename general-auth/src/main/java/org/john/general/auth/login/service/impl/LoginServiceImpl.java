package org.john.general.auth.login.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.john.general.auth.login.entity.LoginDO;
import org.john.general.auth.login.mapper.LoginMapper;
import org.john.general.auth.login.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * @author llxx
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl extends ServiceImpl<LoginMapper, LoginDO> implements LoginService {
    private final LoginMapper loginMapper;
}
