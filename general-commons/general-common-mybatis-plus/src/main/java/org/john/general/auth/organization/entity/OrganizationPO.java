package org.john.general.auth.organization.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
public class OrganizationPO extends MybatisPlusBaseEntity implements Serializable {
}
