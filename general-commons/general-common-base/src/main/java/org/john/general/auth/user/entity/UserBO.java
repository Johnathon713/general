package org.john.general.auth.user.entity;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.john.general.base.validation.groups.Create;
import org.john.general.base.validation.groups.Update;

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

    @NotNull(groups = Update.class, message = "userId不能为空")
    private Long userId;

    @NotBlank
    @Pattern(regexp = UserConstant.USERNAME_REG)
    private String userName;

    @NotBlank
    @Size(min = 2, max = 100)
    private String nickName;

    @NotBlank(groups = Create.class)
    @Pattern(regexp = UserConstant.PASSWORD_REG)
    @Null(groups = Update.class)
    private String password;

    @NotBlank(groups = Create.class)
    @Pattern(regexp = UserConstant.PASSWORD_REG)
    @Null(groups = Update.class)
    private String confirmPassword;

    @NotBlank(groups = Create.class)
    @Pattern(regexp = UserConstant.ENCRYPTION_REG)
    @Null(groups = Update.class)
    private String encryption;

    @NotBlank
    @Pattern(regexp = UserConstant.GENDER_REG)
    private String gender;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = UserConstant.PHONE_REG)
    private String phone;

    @NotBlank
    @Size(min = 2, max = 100, groups = Create.class)
    private String regChannel;

    private String avatar;
}
