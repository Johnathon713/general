package org.john.general.auth.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.john.general.auth.user.entity.UserRecordDO;
import org.john.general.auth.user.entity.UserRecordQuery;
import org.john.general.auth.user.mapper.UserRecordMapper;
import org.john.general.auth.user.service.UserRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author llxx
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserRecordServiceImpl extends ServiceImpl<UserRecordMapper, UserRecordDO> implements UserRecordService {
    private final UserRecordMapper userRecordMapper;

    @Override
    @DS("master")
    @Transactional(rollbackFor = Exception.class)
    public void insert(UserRecordDO userRecordDO) {
        userRecordMapper.insert(userRecordDO);
    }

    @Override
    @DS("master")
    @Transactional(rollbackFor = Exception.class)
    public void insert(Collection<UserRecordDO> userRecordCollection) {
        userRecordMapper.insertBatch(userRecordCollection);
    }

    @Override
    @DS("slave")
    public void selectVoPage(UserRecordQuery userRecordQuery) {
        Page<UserRecordDO> page = Page.of(userRecordQuery.getCurrent(), userRecordQuery.getSize());
        QueryWrapper<UserRecordDO> queryWrapper = new QueryWrapper<>();
        if (userRecordQuery.getUserId() != null) {
            queryWrapper.eq("user_id", userRecordQuery.getUserId());
        }
        if (userRecordQuery.getUserSerialNumber() != null) {
            queryWrapper.eq("user_serial_number", userRecordQuery.getUserSerialNumber());
        }
        if (StrUtil.isNotBlank(userRecordQuery.getUserName())) {
            queryWrapper.likeRight("user_name", userRecordQuery.getUserName());
        }
        if (StrUtil.isNotBlank(userRecordQuery.getGender())) {
            queryWrapper.likeRight("gender", userRecordQuery.getGender());
        }
        if (StrUtil.isNotBlank(userRecordQuery.getEmail())) {
            queryWrapper.likeRight("email", userRecordQuery.getEmail());
        }
        if (StrUtil.isNotBlank(userRecordQuery.getPhone())) {
            queryWrapper.likeRight("phone", userRecordQuery.getPhone());
        }
        userRecordMapper.selectVoPage(page, queryWrapper);
    }
}
