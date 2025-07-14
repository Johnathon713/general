package org.john.general.organization.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.john.general.organization.domain.Organization;
import org.john.general.organization.mapper.OrganizationMapper;
import org.john.general.organization.service.OrganizationService;
import org.springframework.stereotype.Service;

/**
 * @author llxx
 */
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements OrganizationService {
    private final OrganizationMapper organizationMapper;
}
