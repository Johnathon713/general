package org.john.general.auth.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.john.general.auth.user.entity.UserDO;

/**
 * @author llxx
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
