package org.john.role.controller;

import lombok.RequiredArgsConstructor;
import org.john.role.domain.Role;
import org.john.role.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Johnathon
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("role")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("save")
    public Boolean saveRole(@RequestBody Role role) {
        return roleService.save(role);
    }
}
