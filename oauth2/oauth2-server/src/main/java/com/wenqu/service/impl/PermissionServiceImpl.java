package com.wenqu.service.impl;

import com.wenqu.domain.Permission;
import com.wenqu.mapper.PermissionMapper;
import com.wenqu.service.PermissionService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
@DubboService(version = "1.0.0")
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissionListByUserId(Long userId) {
        return permissionMapper.getPermissionListByUserId(userId);
    }

    @Override
    public List<Permission> getPermissionList() {
        return permissionMapper.selectAll();
    }
}
