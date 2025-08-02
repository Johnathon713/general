package org.john.general.auth.role.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
public class RoleVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long roleId;
    private String roleName;
}
