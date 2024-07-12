package org.john.general.base;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Johnathon
 */
@Data
public class BaseEntity implements Serializable {
    private Long createUserId;
    private String createUserName;
    private String createNickName;
    private Date createTime;
    private Long modifyUserId;
    private String modifyUserName;
    private String modifyNickName;
    private Date modifyTime;
    @Version
    private Integer version;
    // 0为正常, 1为逻辑删除
    private Integer deleted;
    private Long deleteUserId;
    private String deleteUserName;
    private String deleteNickName;
    private Date deleteTime;
}
