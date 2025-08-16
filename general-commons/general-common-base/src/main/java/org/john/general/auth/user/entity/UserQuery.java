package org.john.general.auth.user.entity;

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
public class UserQuery extends BaseQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long userSerialNumber;
    private String userName;
    private String nickName;
    private String gender;
    private String email;
    private String phone;
}
