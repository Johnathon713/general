package org.john.general.auth.login.entity;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@AutoMapper(target = LoginDO.class)
public class LoginBO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
