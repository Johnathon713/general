package org.john.general.auth.client.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.john.general.base.MybatisPlusBaseEntity;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@TableName("sys_client")
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ClientVO.class)
public class ClientDO extends MybatisPlusBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    // 自增id
    @TableId
    private Long cliId;
    // id
    private String clientId;
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
    // 设备生成的 nanoid
    private String serialNumber;
}
