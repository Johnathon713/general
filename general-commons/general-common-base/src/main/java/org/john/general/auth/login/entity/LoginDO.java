package org.john.general.auth.login.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@TableName("sys_login")
@AutoMapper(target = LoginVO.class)
public class LoginDO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
