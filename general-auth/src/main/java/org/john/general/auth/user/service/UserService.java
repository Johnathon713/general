package org.john.general.auth.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.john.general.auth.user.entity.UserBO;
import org.john.general.auth.user.entity.UserDO;
import org.john.general.auth.user.entity.UserDO;

/**
 * @author llxx
 */
public interface UserService extends IService<UserDO> {
    Integer save(UserBO userBo);
}
