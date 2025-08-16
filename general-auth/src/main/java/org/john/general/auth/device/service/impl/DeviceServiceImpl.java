package org.john.general.auth.device.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.john.general.auth.device.entity.DeviceBO;
import org.john.general.auth.device.entity.DeviceDO;
import org.john.general.auth.device.entity.DeviceQuery;
import org.john.general.auth.device.entity.DeviceVO;
import org.john.general.auth.device.exception.DeviceException;
import org.john.general.auth.device.mapper.DeviceMapper;
import org.john.general.auth.device.service.DeviceService;
import org.john.general.base.utils.MapstructUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author llxx
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, DeviceDO> implements DeviceService {
    private final StringRedisTemplate redisTemplate;
    private final DeviceMapper deviceMapper;

    @Override
    @DS("slave")
    @Cacheable(cacheNames = "general:auth-service:cache:device", key = "#{deviceBO.deviceId}")
    public DeviceVO selectVoById(Long deviceId) {
        return deviceMapper.selectVoById(deviceId);
    }

    @Override
    @DS("master")
    @Transactional(rollbackFor = Exception.class)
    public DeviceVO insert(DeviceBO deviceBO) {
        if (deviceBO == null || deviceBO.getDeviceId() != null) {
            throw new RuntimeException("");
        }
        DeviceDO deviceDO = MapstructUtil.convert(deviceBO, DeviceDO.class);
        assert deviceDO != null;
        deviceMapper.insert(deviceDO);
        redisTemplate.opsForHash().put("general:auth-service:cache:device", deviceDO.getDeviceId(), deviceDO);
        return MapstructUtil.convert(deviceDO, DeviceVO.class);
    }

    @Override
    @DS("master")
    @Transactional(rollbackFor = Exception.class)
    @CachePut(cacheNames = "general:auth-service:cache:device", key = "#{deviceBO.deviceId}")
    public DeviceVO updateById(DeviceBO deviceBO) {
        if (deviceBO == null || deviceBO.getDeviceId() == null) {
            throw new RuntimeException("");
        }
        DeviceDO deviceOld = deviceMapper.selectById(deviceBO.getDeviceId());
        DeviceDO deviceNew = MapstructUtil.convert(deviceBO, DeviceDO.class);
        assert deviceNew != null;
        deviceOld.setDeviceName(deviceNew.getDeviceName());
        deviceOld.setDeviceKey(deviceNew.getDeviceKey());
        deviceOld.setDeviceSecret(deviceNew.getDeviceSecret());
        deviceOld.setGrantType(deviceNew.getGrantType());
        deviceOld.setDeviceStatus(deviceNew.getDeviceStatus());
        deviceOld.setDeviceType(deviceNew.getDeviceType());
        deviceOld.setIsLastingCookie(deviceNew.getIsLastingCookie());
        deviceOld.setTimeout(deviceNew.getTimeout());
        deviceOld.setActiveTimeout(deviceNew.getActiveTimeout());
        deviceOld.setIsWriteHeader(deviceNew.getIsWriteHeader());
        deviceMapper.updateById(deviceOld);
        return MapstructUtil.convert(deviceOld, DeviceVO.class);
    }

    @Override
    @DS("master")
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(cacheNames = "general:auth-service:cache:device", key = "#{deviceId}")
    public Integer deleteById(Long deviceId) {
        if (deviceId == null) {
            throw new RuntimeException("请传入设备id");
        }
        int count = deviceMapper.deleteById(deviceId);
        if (count != 0) {
            throw new DeviceException("数量不一致");
        }
        return count;
    }

    @Override
    @DS("master")
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteByIds(Collection<Long> deviceIds) {
        int count = 0;
        if (CollUtil.isEmpty(deviceIds)) {
            throw new DeviceException("请传入设备id");
        }
        count = deviceMapper.deleteByIds(deviceIds);
        if (CollUtil.size(deviceIds) != count) {
            throw new DeviceException("数量不一致");
        }
        redisTemplate.opsForHash().delete("general:auth-service:cache:device", ArrayUtil.toArray(deviceIds, Long.class));
        return count;
    }

    @Override
    @DS("slave")
    public Page<DeviceVO> selectVoPage(DeviceQuery query) {
        Page<DeviceDO> page = Page.of(query.getCurrent(), query.getSize());
        QueryWrapper<DeviceDO> queryWrapper = new QueryWrapper<>();
        return deviceMapper.selectVoPage(page, queryWrapper);
    }

}
