package org.john.user.controller;

import lombok.RequiredArgsConstructor;
import org.john.user.domain.User;
import org.john.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Johnathon
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @GetMapping("save")
    public Boolean saveUser( User user) {
        return userService.save(user);
    }
}
