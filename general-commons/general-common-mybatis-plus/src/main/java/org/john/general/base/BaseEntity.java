package org.john.general.base;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.john.general.user.domain.User;

import java.io.Serializable;
import java.util.Date;

/**
 * @author llxx
 */
@Data
@NoArgsConstructor
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
    @TableLogic
    private Integer deleted = 0;
    private Long deleteUserId;
    private String deleteUserName;
    private String deleteNickName;
    private Date deleteTime;

    public BaseEntity(User createUser, User modifyUser) {
        markCreateUser(createUser);
        markModifyUser(modifyUser);
    }

    public BaseEntity(User user) {
        this(user, user);
    }

    public void markCreateUser(User user) {
        if (user != null) {
            this.createUserId = user.getUserId();
            this.createUserName = user.getUserName();
            this.createNickName = user.getNickName();
        }
        this.createTime = new Date();
    }

    public void markModifyUser(User user) {
        if (user != null) {
            this.modifyUserId = user.getUserId();
            this.modifyUserName = user.getUserName();
            this.modifyNickName = user.getNickName();
        }
        this.modifyTime = new Date();
    }

    public void markDeleteUser(User user) {
        if (user != null) {
            this.deleteUserId = user.getUserId();
            this.deleteUserName = user.getUserName();
            this.deleteNickName = user.getNickName();
        }
        this.deleteTime = new Date();
    }
}
