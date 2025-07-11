package org.john.general.user.domain.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Johnathon
 */
@Data
public class UserBo implements Serializable {
    private Long userId;
    private String userName;
    private String nickName;
    private String password;
    private String gender;
    private String email;
    private String phone;
    private String regChannel;
    private String avatar;
}
