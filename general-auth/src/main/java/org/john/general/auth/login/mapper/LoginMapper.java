package org.john.general.auth.login.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.john.general.auth.login.entity.LoginDO;
import org.john.general.auth.login.entity.LoginVO;
import org.john.general.mybatisPlus.mapper.BaseMapperPlus;

/**
 * @author llxx
 */
@Mapper
public interface LoginMapper extends BaseMapperPlus<LoginDO, LoginVO> {
}
