package org.john.general.auth.device.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
public class DeviceVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // 自增id
    private Long deviceId;
    // 设备名称
    private String deviceName;
    // 设备key
    private String deviceKey;
    // 设备秘钥
    private String deviceSecret;
    // 授权类型
    private String grantType;
    // 状态(0正常, 1停用)
    private Boolean deviceStatus;

    // 设备类型
    private String deviceType;
    // 是否为持久Cookie（临时Cookie在浏览器关闭时会自动删除，持久Cookie在重新打开后依然存在）
    private Boolean isLastingCookie;
    // 指定此次登录 token 的有效期, 单位:秒，-1=永久有效
    private Long timeout;
    // 指定此次登录 token 的最低活跃频率, 单位:秒，-1=不进行活跃检查
    private Long activeTimeout;
    // 是否在登录后将 Token 写入到响应头
    private Boolean isWriteHeader;
}
