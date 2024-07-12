package org.john.general.role.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.john.general.base.BaseEntity;

import java.io.Serializable;

/**
 * @author Johnathon
 */
@Data
@TableName("general_role")
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity implements Serializable {
    @TableId
    private Long roleId;
    private String roleName;
}
