package org.john.general.auth.role.entity;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@AutoMapper(target = RoleDO.class)
public class RoleBO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
