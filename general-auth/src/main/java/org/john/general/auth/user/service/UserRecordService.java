package org.john.general.auth.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.john.general.auth.user.entity.UserRecordDO;
import org.john.general.auth.user.entity.UserRecordQuery;
import org.springframework.scheduling.annotation.Async;

import java.util.Collection;

/**
 * @author llxx
 */
public interface UserRecordService extends IService<UserRecordDO> {
    @Async
    void insert(UserRecordDO userRecordDO);

    @Async
    void insert(Collection<UserRecordDO> userRecordCollection);

    void selectVoPage(UserRecordQuery userRecordQuery);
}
