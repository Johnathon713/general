package org.john.general.log.requestLog.entity;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@AutoMapper(target = RequestLogDO.class)
public class RequestLogBO implements Serializable {
    @Serial
    public static final long serialVersionUID = 1L;
}
