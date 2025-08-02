package org.john.general.log.requestLog.entity;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@AutoMapper(target = RequestLogDO.class)
public class RequestLogDTO implements Serializable {
}
