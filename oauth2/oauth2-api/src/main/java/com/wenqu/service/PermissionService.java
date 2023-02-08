package com.wenqu.service;

import com.wenqu.domain.Permission;

import java.util.List;

public interface PermissionService{
    List<Permission> getPermissionListByUserId(Long userId);
    List<Permission> getPermissionList();

}
