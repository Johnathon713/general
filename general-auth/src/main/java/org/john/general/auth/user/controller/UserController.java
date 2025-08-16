package org.john.general.auth.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.john.general.auth.user.entity.UserBO;
import org.john.general.auth.user.entity.UserQuery;
import org.john.general.auth.user.entity.UserVO;
import org.john.general.auth.user.service.UserService;
import org.john.general.base.Result;
import org.john.general.base.validation.groups.Create;
import org.john.general.base.validation.groups.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author llxx
 */
@XSlf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth-service/user")
public class UserController {
    private final UserService userService;

    @GetMapping("select-by-id")
    public Result<UserVO> selectVoById(@NotNull @RequestParam Long userId) {
        return Result.success(userService.selectVoById(userId));
    }

    @PostMapping("insert")
    public Result<UserVO> insert(@Validated(Create.class) @RequestBody UserBO userBo) {
        return Result.success(userService.insert(userBo));
    }

    @PutMapping("update")
    public Result<UserVO> updateById(@Validated(Update.class) @RequestBody UserBO user) {
        return Result.success(userService.updateById(user));
    }

    @DeleteMapping("delete-by-id")
    public Result<Integer> deleteById(@NotNull Long userId) {
        return Result.success(userService.deleteById(userId));
    }

    @DeleteMapping("delete-by-ids")
    public Result<Integer> deleteByIds(@NotEmpty Collection<Long> userIds) {
        return Result.success(userService.deleteByIds(userIds));
    }

    @GetMapping("page")
    public Result<Page<UserVO>> page(@Validated UserQuery userQuery) {
        return Result.success(userService.selectVoPage(userQuery));
    }
}
