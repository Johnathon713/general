package org.john.general.auth.client.service.impl;

import cn.hutool.core.lang.id.NanoId;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.linpeilie.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.john.general.auth.client.entity.ClientBO;
import org.john.general.auth.client.entity.ClientDO;
import org.john.general.auth.client.mapper.ClientMapper;
import org.john.general.auth.client.service.ClientService;
import org.john.general.base.exception.GeneralDbException;
import org.john.general.base.utils.MapstructUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author llxx
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends ServiceImpl<ClientMapper, ClientDO> implements ClientService {
    private final ClientMapper clientMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String init(ClientBO clientBO) {
        if (StrUtil.isBlank(clientBO.getClientId())) {
            clientBO.setClientId(NanoId.randomNanoId(64));
            if (!save(MapstructUtil.convert(clientBO, ClientDO.class))) {
                throw new GeneralDbException("保存客户端失败");
            }
        } else {
            QueryWrapper<ClientDO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("client_id", clientBO.getClientId());
            ClientDO one = getOne(queryWrapper);
            if (one == null) {
                clientBO.setClientId(NanoId.randomNanoId(64));
                if (!save(MapstructUtil.convert(clientBO, ClientDO.class))) {
                    throw new GeneralDbException("保存客户端失败");
                }
            } else {
                boolean change = false;
                if (!StrUtil.equalsIgnoreCase(one.getCpuModel(), clientBO.getCpuModel())) {
                    change = true;
                    log.warn("CPU型号已变更");
                }
                if (!StrUtil.equalsIgnoreCase(one.getCpuSerial(), clientBO.getCpuSerial())) {
                    change = true;
                    log.warn("CPU序列号已变更");
                }
                if (ObjectUtil.notEqual(one.getCpuCount(), clientBO.getCpuCount())) {
                    change = true;
                    log.warn("CPU核心数已变更");
                }
                if (ObjectUtil.notEqual(one.getCpuThreadCount(), clientBO.getCpuThreadCount())) {
                    change = true;
                    log.warn("CPU线程数已变更");
                }
                if (ObjectUtil.notEqual(one.getMemory(), clientBO.getMemory())) {
                    change = true;
                    log.warn("内存容量已变更");
                }
                if (!StrUtil.equalsIgnoreCase(one.getMotherboardModel(), clientBO.getMotherboardModel())) {
                    change = true;
                    log.warn("主板型号已变更");
                }
                if (!StrUtil.equalsIgnoreCase(one.getMotherboardSerial(), clientBO.getMotherboardSerial())) {
                    change = true;
                    log.warn("主板序列号已变更");
                }
                if (!StrUtil.equalsIgnoreCase(one.getGpuModel(), clientBO.getGpuModel())) {
                    change = true;
                    log.warn("GPU型号已变更");
                }
                if (!StrUtil.equalsIgnoreCase(one.getGpuSerial(), clientBO.getGpuSerial())) {
                    change = true;
                    log.warn("CPU序列号已变更");
                }
                if (!StrUtil.equalsIgnoreCase(one.getDeviceKey(), clientBO.getDeviceKey())) {
                    change = true;
                    log.warn("设备类型已变更");
                }
                if (change) {
                    clientBO.setClientId(NanoId.randomNanoId(64));
                    if (!save(MapstructUtil.convert(clientBO, ClientDO.class))) {
                        throw new GeneralDbException("保存客户端失败");
                    }
                }
            }
        }
        return clientBO.getClientId();
    }
}
