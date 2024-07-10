package org.john.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.john.user.domain.User;
import org.john.user.service.UserService;
import org.john.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Johnathon
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @GetMapping("get/{userId}")
    public Result<User> get(@PathVariable Long userId) {
        return Result.success(userService.getById(userId));
    }

    @GetMapping("page")
    public Result<Page<User>> page(Page<User> page) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return Result.success(userService.page(page, wrapper));
    }

    @PostMapping("save")
    @SentinelResource(value = "saveUser")
    public Result<Boolean> save(@RequestBody User user) {
        return Result.success(userService.save(user));
    }

    @PutMapping("update")
    public Result<Boolean> updateById(@RequestBody User user) {
        return Result.success(userService.updateById(user));
    }

    @DeleteMapping("delete")
    public Result<Boolean> deleteById(Collection<Long> userIds) {
        return Result.success(userService.removeBatchByIds(userIds));
    }
}
