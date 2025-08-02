package org.john.general.auth.user.entity;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@AutoMapper(target = UserDO.class)
public class UserBO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String userName;
    private String nickName;
    private String password;
    private String gender;
    private String email;
    private String regChannel;
    private String avatar;
}
