package org.john.general.auth.role.controller;

import lombok.RequiredArgsConstructor;
import org.john.general.auth.role.entity.RolePO;
import org.john.general.auth.role.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author llxx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth_service/role")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("save")
    public Boolean saveRole(RolePO role) {
        return roleService.save(role);
    }
}
