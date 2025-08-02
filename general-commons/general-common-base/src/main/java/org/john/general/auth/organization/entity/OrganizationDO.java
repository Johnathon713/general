package org.john.general.auth.organization.entity;

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
@TableName("general_organization")
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = OrganizationVO.class)
public class OrganizationDO extends MybatisPlusBaseEntity implements Serializable {
}
