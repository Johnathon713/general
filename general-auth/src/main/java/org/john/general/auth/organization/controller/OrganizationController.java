package org.john.general.auth.organization.controller;

import lombok.RequiredArgsConstructor;
import org.john.general.auth.organization.entity.OrganizationPO;
import org.john.general.auth.organization.service.OrganizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author llxx
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth_service/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    @GetMapping("save")
    public Boolean saveOrganization(OrganizationPO organization) {
        return organizationService.save(organization);
    }
}
