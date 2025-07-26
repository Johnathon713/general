package org.john.general.auth.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.john.general.auth.user.entity.UserBo;
import org.john.general.auth.user.entity.UserPO;

/**
 * @author llxx
 */
public interface UserService extends IService<UserPO> {
    Integer save(UserBo userBo);
}
