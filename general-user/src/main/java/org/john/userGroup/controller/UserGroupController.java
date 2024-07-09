package org.john.userGroup.controller;

import lombok.RequiredArgsConstructor;
import org.john.userGroup.domain.UserGroup;
import org.john.userGroup.service.UserGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Johnathon
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("user_group")
public class UserGroupController {
    private final UserGroupService userGroupService;

    @GetMapping("save")
    public Boolean saveUserGroup(@RequestBody UserGroup userGroup) {
        return userGroupService.save(userGroup);
    }
}
