package org.john.general.organization.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.john.general.base.BaseEntity;

import java.io.Serializable;

/**
 * @author Johnathon
 */
@Data
@TableName("general_organization")
@EqualsAndHashCode(callSuper = true)
public class Organization extends BaseEntity implements Serializable {
}
