package org.john.general.auth.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.john.general.auth.role.entity.RolePO;
import org.john.general.auth.role.mapper.RoleMapper;
import org.john.general.auth.role.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author llxx
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RolePO> implements RoleService {
    private final RoleMapper roleMapper;
}
