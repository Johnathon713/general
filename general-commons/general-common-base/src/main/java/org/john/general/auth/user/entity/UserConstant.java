package org.john.general.auth.user.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
public class UserConstant implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    // 用户名正则, 以字母开头，包含字母、数字、下划线的4~20位字符串
    public static final String USERNAME_REG = "^[a-zA-Z][a-zA-Z0-9_]{3,19}$";
}
