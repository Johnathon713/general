package org.john.general.auth.client.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.john.general.auth.client.entity.ClientDO;
import org.john.general.auth.client.entity.ClientVO;
import org.john.general.mybatisPlus.mapper.BaseMapperPlus;

/**
 * @author llxx
 */
@Mapper
public interface ClientMapper extends BaseMapperPlus<ClientDO, ClientVO> {
}
