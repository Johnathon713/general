package org.john.general.auth.client.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.john.general.auth.client.entity.ClientBO;
import org.john.general.auth.client.entity.ClientDO;

/**
 * @author llxx
 */
public interface ClientService extends IService<ClientDO> {
    String init(ClientBO clientBO);
}
