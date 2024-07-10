package org.john.role.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Johnathon
 */
@Data
@TableName("general_role")
public class Role {
    @TableId(type = IdType.ASSIGN_ID)
    private Long roleId;
    private String roleName;
}
