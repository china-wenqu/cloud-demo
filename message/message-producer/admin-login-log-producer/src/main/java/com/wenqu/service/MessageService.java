package com.wenqu.service;

import com.wenqu.domain.AdminLoginLog;

public interface MessageService {
    boolean sendAdminLoginLog(AdminLoginLog adminLoginLog);

}
