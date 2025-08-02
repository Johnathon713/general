package org.john.general.log.feign;

import org.john.general.log.requestLog.entity.RequestLogDTO;
import org.john.general.log.requestLog.entity.RequestLogVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author llxx
 */
@FeignClient(name = "general-log")
public interface LogFeignClient {
    @PostMapping("/api/log_service/request_log/record")
    RequestLogVO recordRequestLog(@RequestBody RequestLogDTO requestLogDTO);
}
