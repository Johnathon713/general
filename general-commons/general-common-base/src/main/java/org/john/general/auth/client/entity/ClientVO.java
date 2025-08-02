package org.john.general.auth.client.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
public class ClientVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    // 自增id
    private Long clientId;
    // cpu 型号
    private String cpuModel;
    // CPU 序列号
    private String cpuSerial;
    // CPU 核心数
    private Long cpuCount;
    // CPU 线程数
    private Long cpuThreadCount;
    // 内存容量
    private Long memory;
    // 主板型号
    private String motherboardModel;
    // 主板序列号
    private String motherboardSerial;
    // GPU 型号
    private String gpuModel;
    // GPU序列号
    private String gpuSerial;
    // 设备key
    private String deviceKey;
}
