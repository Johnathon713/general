package org.john.general.auth.device.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.john.general.auth.device.entity.DeviceDO;
import org.john.general.auth.device.entity.DeviceVO;
import org.john.general.mybatisPlus.mapper.BaseMapperPlus;

/**
 * @author llxx
 */
@Mapper
public interface DeviceMapper extends BaseMapperPlus<DeviceDO, DeviceVO> {
}
