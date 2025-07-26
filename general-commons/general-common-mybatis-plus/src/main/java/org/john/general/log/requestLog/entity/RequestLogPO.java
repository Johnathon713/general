package org.john.general.log.requestLog.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.john.general.base.MybatisPlusBaseEntity;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@TableName("request_log")
public class RequestLogPO extends MybatisPlusBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId
    private Long requestLogId;
    private String requestId;
    private String requestUri;
    private String requestMethod;
    private String requestHeaders;
    private String requestBody;
    private String responseStatus;
    private String responseHeaders;
    private String responseBody;
}
