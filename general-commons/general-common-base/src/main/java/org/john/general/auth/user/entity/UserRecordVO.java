package org.john.general.auth.user.entity;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = UserRecordDO.class)
public class UserRecordVO extends UserVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long userRecordId;
}
