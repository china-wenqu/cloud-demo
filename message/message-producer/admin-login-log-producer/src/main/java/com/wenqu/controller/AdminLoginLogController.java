package com.wenqu.controller;

import com.wenqu.domain.AdminLoginLog;
import com.wenqu.dto.Result;
import com.wenqu.service.MessageService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/")
public class AdminLoginLogController {
    @Resource
    private MessageService messageService;

    @GetMapping(value = "test")
    public String test(){
        return "test";
    }

    @PostMapping(value = "admin/login/log")
    public Result sendAdminLoginLog(@RequestBody AdminLoginLog adminLoginLog) {
        boolean flag = messageService.sendAdminLoginLog(adminLoginLog);
        // 发送成功
        if (flag) {
            return Result.success().data("管理员登录日志发送成功");
        }
        // 发送失败
        else {
            return Result.error().data("管理员登录日志发送失败");
        }
    }
}
