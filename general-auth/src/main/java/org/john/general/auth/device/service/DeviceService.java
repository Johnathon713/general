package org.john.general.auth.device.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.john.general.auth.device.entity.DeviceBO;
import org.john.general.auth.device.entity.DeviceDO;
import org.john.general.auth.device.entity.DeviceQuery;
import org.john.general.auth.device.entity.DeviceVO;

import java.util.Collection;

/**
 * @author llxx
 */
public interface DeviceService extends IService<DeviceDO> {
    DeviceVO selectVoById(Long deviceId);

    DeviceVO insert(DeviceBO deviceBO);

    DeviceVO updateById(DeviceBO deviceBO);

    Integer deleteById(Long deviceId);

    Integer deleteByIds(Collection<Long> deviceIds);

    Page<DeviceVO> selectVoPage(DeviceQuery query);
}
