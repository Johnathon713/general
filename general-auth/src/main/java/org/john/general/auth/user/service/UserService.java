package org.john.general.auth.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.john.general.auth.user.entity.UserBO;
import org.john.general.auth.user.entity.UserDO;
import org.john.general.auth.user.entity.UserQuery;
import org.john.general.auth.user.entity.UserVO;

import java.util.Collection;

/**
 * @author llxx
 */
public interface UserService extends IService<UserDO> {
    UserVO selectVoById(Long userId);

    UserVO insert(UserBO userBO);

    UserVO updateById(UserBO userBO);

    Integer deleteById(Long userId);

    Integer deleteByIds(Collection<Long> deviceIds);

    Page<UserVO> selectVoPage(UserQuery userQuery);
}
