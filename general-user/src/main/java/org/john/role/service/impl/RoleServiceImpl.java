package org.john.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.john.role.domain.Role;
import org.john.role.mapper.RoleMapper;
import org.john.role.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author Johnathon
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    private final RoleMapper roleMapper;
}
