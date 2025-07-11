package org.john.general.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.john.general.base.BaseEntity;

import java.io.Serializable;

/**
 * @author Johnathon
 */
@Data
@NoArgsConstructor
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements Serializable {
    @TableId
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

    public User(User user) {
        super(user);
    }
}
