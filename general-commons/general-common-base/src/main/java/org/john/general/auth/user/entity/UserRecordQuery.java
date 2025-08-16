package org.john.general.auth.user.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserRecordQuery extends UserQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long userId;
}
