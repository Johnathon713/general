package org.john.general.auth.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.john.general.base.MybatisPlusBaseEntity;

import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = UserVO.class)
public class UserDO extends MybatisPlusBaseEntity implements Serializable {
    @TableId
    private Long userId;
    private Long userSerialNumber;
    private String userName;
    private String nickName;
    private String password;
    private String salt;
    private String passwordKey;
    private String encryption;
    private String gender;
    private String email;
    private String phone;
    private String regChannel;
    private String avatar;
}
