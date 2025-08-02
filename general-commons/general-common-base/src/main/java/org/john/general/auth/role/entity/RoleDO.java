package org.john.general.auth.role.entity;

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
@TableName("general_role")
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = RoleVO.class)
public class RoleDO extends MybatisPlusBaseEntity implements Serializable {
    @TableId
    private Long roleId;
    private String roleName;
}
