package org.john.general.auth.device.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.john.general.auth.device.entity.DeviceBO;
import org.john.general.auth.device.entity.DeviceQuery;
import org.john.general.auth.device.entity.DeviceVO;
import org.john.general.auth.device.service.DeviceService;
import org.john.general.base.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author llxx
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth-service/device")
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping("select-by-id")
    public Result<DeviceVO> selectVoById(Long deviceId) {
        return Result.success(deviceService.selectVoById(deviceId));
    }

    @PostMapping("insert")
    public Result<DeviceVO> insert(@RequestBody DeviceBO deviceBO) {
        return Result.success(deviceService.insert(deviceBO));
    }

    @PostMapping("update-by-id")
    public Result<DeviceVO> updateById(@RequestBody DeviceBO deviceBO) {
        return Result.success(deviceService.updateById(deviceBO));
    }

    @DeleteMapping("delete-by-id")
    public Result<Integer> deleteById(@RequestParam Long deviceId) {
        return Result.success(deviceService.deleteById(deviceId));
    }

    @DeleteMapping("delete-by-ids")
    public Result<Integer> deleteByIds(@RequestParam Collection<Long> deviceIds) {
        return Result.success(deviceService.deleteByIds(deviceIds));
    }

    @GetMapping("select-page")
    public Result<Page<DeviceVO>> selectVoPage(DeviceQuery query) {
        return Result.success(deviceService.selectVoPage(query));
    }
}
