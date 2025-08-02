package org.john.general.auth.device.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.john.general.auth.device.service.DeviceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author llxx
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth_service/device")
public class DeviceController {
    private final DeviceService deviceService;
}
