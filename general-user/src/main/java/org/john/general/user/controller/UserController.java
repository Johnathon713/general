package org.john.general.user.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.john.general.user.domain.User;
import org.john.general.user.domain.bo.UserBo;
import org.john.general.user.service.UserService;
import org.john.general.web.domain.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Johnathon
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/user_service/user")
@XSlf4j
public class UserController {
    private final UserService userService;

    @GetMapping("get/{userId}")
    public Result<User> get(@PathVariable Long userId) {
        return Result.success(userService.getById(userId));
    }

    @GetMapping("page")
    @DS("master")
    public Result<Page<User>> page(String name, Page<User> page) {
        log.info("page: {}", page);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("user_id, user_name, nick_name, gender, email, phone, reg_channel, avatar, create_time");
        if (StrUtil.isNotBlank(name)) {
            wrapper.likeRight("user_id", name).or().likeRight("user_name", name).or().likeRight("nick_name", name).or().likeRight("email", name).or().likeRight("phone", name);
        }
        return Result.success(userService.page(page, wrapper));
    }

    @PostMapping("save")
    @SentinelResource(value = "saveUser")
    public Result<Integer> save(@RequestBody UserBo userBo) {
        return Result.success(userService.save(userBo));
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
