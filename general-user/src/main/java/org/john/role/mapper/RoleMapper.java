package org.john.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.john.role.domain.Role;

/**
 * @author Johnathon
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
