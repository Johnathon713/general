package org.john.general.auth.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author llxx
 */
@Data
@TableName("sys_user_record")
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = UserDO.class)
public class UserRecordDO extends UserDO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId
    private Long userRecordId;

    private Long userId;
}
