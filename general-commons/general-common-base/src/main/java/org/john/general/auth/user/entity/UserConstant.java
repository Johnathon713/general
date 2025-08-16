package org.john.general.auth.user.entity;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
public class UserConstant implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    // 用户最小编号
    public static final Long MIN_USER_SERIAL_NUMBER = 100000001L;
    // 用户名正则, 以字母开头，包含字母、数字、下划线的4~20位字符串
    public static final String USERNAME_REG = "^[a-zA-Z][a-zA-Z0-9_]{3,19}$";
    // 密码正则，8~20位
    public static final String PASSWORD_REG = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d!@#$%^&*()]{8,20}$";
    // 手机号正则
    public static final String PHONE_REG = "^1[3-9]\\d{9}$";
    // 邮箱正则
    public static final String EMAIL_REG = "^(?i)([a-z0-9._%+-]+)@([a-z0-9.-]+\\.[a-z]{2,})$";
    // 性别正则
    public static final String GENDER_REG = "/^(male|female|unknown)$/";
    // 加密方式
    public static final String ENCRYPTION_REG = "/^(AES|MD5|SHA1|SHA256|SM4)$/";
    // 用户密码盐
    public static final String PASSWORD_SALT = "*@3!8^general!#^6#@";
}
