package org.john.userGroup.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.john.userGroup.domain.UserGroup;
import org.john.userGroup.mapper.UserGroupMapper;
import org.john.userGroup.service.UserGroupService;
import org.springframework.stereotype.Service;

/**
 * @author Johnathon
 */
@Service
@RequiredArgsConstructor
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup> implements UserGroupService {
    private final UserGroupMapper userGroupMapper;
}
