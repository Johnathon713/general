package org.john.general.auth.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.john.general.base.MybatisPlusBaseEntity;

import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@NoArgsConstructor
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
public class UserPO extends MybatisPlusBaseEntity implements Serializable {
    @TableId
    private Long userId;
    private String userName;
    private String nickName;
    private String password;
    private String salt;
    private String gender;
    private String email;
    private String regChannel;
    private String avatar;
}
