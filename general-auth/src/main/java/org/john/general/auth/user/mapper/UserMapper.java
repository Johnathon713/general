package org.john.general.auth.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.john.general.auth.user.entity.UserDO;
import org.john.general.auth.user.entity.UserVO;
import org.john.general.mybatisPlus.mapper.BaseMapperPlus;

/**
 * @author llxx
 */
@Mapper
public interface UserMapper extends BaseMapperPlus<UserDO, UserVO> {
}
