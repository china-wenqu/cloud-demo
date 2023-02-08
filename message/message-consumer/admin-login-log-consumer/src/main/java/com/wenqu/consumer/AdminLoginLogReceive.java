package com.wenqu.consumer;

import com.alibaba.fastjson.JSON;
import com.wenqu.domain.AdminLoginLog;
import com.wenqu.service.AdminLoginLogService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginLogReceive {

    @DubboReference(version = "1.0.0")
    private AdminLoginLogService adminLoginLogService;
    @StreamListener("admin-login-log-topic")
    public void receiveAdminLoginLog(String adminLoginLogJson){
        AdminLoginLog adminLoginLog = JSON.parseObject(adminLoginLogJson,AdminLoginLog.class);
        adminLoginLogService.insertAdminLoginLog(adminLoginLog);
    }
}
