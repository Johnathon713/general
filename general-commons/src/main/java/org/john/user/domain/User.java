package org.john.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Johnathon
 */
@Data
@TableName("general_user")
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private Long userId;
}
