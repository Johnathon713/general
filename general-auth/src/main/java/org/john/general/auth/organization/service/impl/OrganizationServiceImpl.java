package org.john.general.auth.organization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.john.general.auth.organization.entity.OrganizationPO;
import org.john.general.auth.organization.mapper.OrganizationMapper;
import org.john.general.auth.organization.service.OrganizationService;
import org.springframework.stereotype.Service;

/**
 * @author llxx
 */
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, OrganizationPO> implements OrganizationService {
    private final OrganizationMapper organizationMapper;
}
