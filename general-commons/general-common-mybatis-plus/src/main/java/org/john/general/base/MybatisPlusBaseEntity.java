package org.john.general.base;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author llxx
 */
@Data
@NoArgsConstructor
public class MybatisPlusBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long createUserId;
    private Date createTime;
    private Long updateUserId;
    private Date updateTime;
    private Long tenantId;
    @Version
    private Integer version;
    // 0为正常, 1为逻辑删除
    private Long deleted = 0L;
    private Long deleteUserId;
    private Date deleteTime;
}
