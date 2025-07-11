package org.john.general.role.controller;

import lombok.RequiredArgsConstructor;
import org.john.general.role.domain.Role;
import org.john.general.role.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Johnathon
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth_service/role")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("save")
    public Boolean saveRole(Role role) {
        return roleService.save(role);
    }
}
