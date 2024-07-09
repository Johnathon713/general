package org.john.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.john.user.domain.User;

/**
 * @author Johnathon
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
