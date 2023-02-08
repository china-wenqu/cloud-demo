package com.wenqu.controller;

import com.wenqu.domain.AdminLoginLog;
import com.wenqu.dto.Result;
import com.wenqu.service.AdminLoginLogService;
import com.wenqu.service.AdminService;
import com.wenqu.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
@RequestMapping("/")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminController {

    private static final String URL_OAUTH_TOKEN = "http://192.168.253.199:9001/oauth/token";


    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @DubboReference(version = "1.0.0",check = false)
    private UserService userService;

    @DubboReference(version = "1.0.0",check = false)
    private AdminService adminService;

    @DubboReference(version = "1.0.0",check = false)
    private AdminLoginLogService adminLoginLogService;


    @GetMapping(value = "test")
    public Result test(){
        return Result.success().data(adminService.sentinelTest("admin"));
    }

    @PostMapping(value = "message")
    public Result message(){
        return Result.success();
    }

}
