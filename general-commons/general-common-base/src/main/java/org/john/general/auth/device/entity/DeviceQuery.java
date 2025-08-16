package org.john.general.auth.device.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.john.general.base.entity.BaseQuery;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeviceQuery extends BaseQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
