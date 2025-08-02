package org.john.general.auth.organization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.john.general.auth.organization.entity.OrganizationDO;
import org.john.general.auth.organization.mapper.OrganizationMapper;
import org.john.general.auth.organization.service.OrganizationService;
import org.springframework.stereotype.Service;

/**
 * @author llxx
 */
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, OrganizationDO> implements OrganizationService {
    private final OrganizationMapper organizationMapper;
}
