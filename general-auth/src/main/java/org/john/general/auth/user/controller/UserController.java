package org.john.general.auth.user.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.john.general.auth.user.entity.UserBo;
import org.john.general.auth.user.entity.UserPO;
import org.john.general.auth.user.service.UserService;
import org.john.general.base.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author llxx
 */
@XSlf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth_service/user")
public class UserController {
    private final UserService userService;

    @GetMapping("get/{userId}")
    public Result<UserPO> get(@PathVariable Long userId) {
        return Result.success(userService.getById(userId));
    }

    @GetMapping("page")
    @DS("master")
    public Result<Page<UserPO>> page(String name, Page<UserPO> page, HttpServletResponse request) {
        log.info("page: {}", page);
        QueryWrapper<UserPO> wrapper = new QueryWrapper<>();
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
    public Result<Boolean> updateById(@RequestBody UserPO user) {
        return Result.success(userService.updateById(user));
    }

    @DeleteMapping("delete")
    public Result<Boolean> deleteById(Collection<Long> userIds) {
        return Result.success(userService.removeBatchByIds(userIds));
    }
}
