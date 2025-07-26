package org.john.general.auth.role.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author llxx
 */
@Data
public class RoleVO implements Serializable {
    private Long roleId;
    private String roleName;
}
