package com.wenqu.service.impl;

import com.wenqu.domain.AdminLoginLog;
import com.wenqu.service.AdminLoginLogService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wenqu.mapper.AdminLoginLogMapper;

@Service
@DubboService(version = "1.0.0")
public class AdminLoginLogServiceImpl implements AdminLoginLogService {

    @Resource
    private AdminLoginLogMapper adminLoginLogMapper;

    @Override
    public int insertAdminLoginLog(AdminLoginLog adminLoginLog) {
        return adminLoginLogMapper.insert(adminLoginLog);
    }
}
