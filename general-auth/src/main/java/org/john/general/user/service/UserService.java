package org.john.general.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.john.general.user.domain.User;
import org.john.general.user.domain.bo.UserBo;

/**
 * @author llxx
 */
public interface UserService extends IService<User> {
    Integer save(UserBo userBo);
}
