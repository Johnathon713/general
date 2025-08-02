package org.john.general.auth.organization.entity;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@AutoMapper(target = OrganizationDO.class)
public class OrganizationBO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
