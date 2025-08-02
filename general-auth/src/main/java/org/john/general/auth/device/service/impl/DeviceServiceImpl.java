package org.john.general.auth.device.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.john.general.auth.device.entity.DeviceDO;
import org.john.general.auth.device.mapper.DeviceMapper;
import org.john.general.auth.device.service.DeviceService;
import org.springframework.stereotype.Service;

/**
 * @author llxx
 */
@Service
@RequiredArgsConstructor
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, DeviceDO> implements DeviceService {
    private final DeviceMapper deviceMapper;

}
