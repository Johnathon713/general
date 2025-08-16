package org.john.general.auth.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.john.general.auth.user.entity.UserRecordDO;
import org.john.general.auth.user.entity.UserRecordVO;
import org.john.general.mybatisPlus.mapper.BaseMapperPlus;

/**
 * @author llxx
 */
@Mapper
public interface UserRecordMapper extends BaseMapperPlus<UserRecordDO, UserRecordVO> {
}
