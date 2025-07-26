package org.john.general.auth.user.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author llxx
 */
@Data
public class UserVO implements Serializable {
    private Long userId;
    private String userName;
    private String nickName;
    private String password;
    private String salt;
    private String gender;
    private String email;
    private String phone;
    private String regChannel;
    private String avatar;
}
