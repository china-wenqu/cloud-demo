package com.wenqu.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.nacos.shaded.com.google.common.collect.Maps;
import com.wenqu.domain.AdminLoginLog;
import com.wenqu.domain.User;
import com.wenqu.dto.Result;
import com.wenqu.exception.CustomException;
import com.wenqu.exception.CustomStatus;
import com.wenqu.service.MessageService;
import com.wenqu.service.UserService;
import com.wenqu.utils.AESUtil;
import com.wenqu.utils.OkHttpClientUtil;
import okhttp3.Response;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/user")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private static final String URL_OAUTH_TOKEN = "http://localhost:9001/oauth/token";

    @Resource(name = "userDetailsService")
    public UserDetailsService userDetailsService;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Resource
    private UserService userService;

    @DubboReference(version = "1.0.0")
    private MessageService messageService;

    @PostMapping(value = "login")
    @Transactional(rollbackFor = RuntimeException.class)
    public Result login(@RequestBody User user, HttpServletRequest request) {
        if(user!=null){
            User u = userService.getUserByUsername(user.getUsername());
            if(u!=null){
                UserDetails userDetails = userDetailsService.loadUserByUsername(u.getUsername());
                String src = user.getPassword();
                String decrypt = null;
                try {
                    decrypt = AESUtil.decrypt(src);
                } catch (Exception e) {
                    throw new CustomException(CustomStatus.ADMIN_PASSWORD);
                }
                boolean flag = bCryptPasswordEncoder.matches(decrypt, u.getPassword());
                if (userDetails == null || !flag) {
                    //return Result.error().data("账号密码错误");
                    throw new CustomException(CustomStatus.ADMIN_PASSWORD);
                }else{
                    // 封装返回的结果集
                    Map<String, Object> result = Maps.newHashMap();
                    // 通过 HTTP 客户端请求登录接口
                    Map<String, String> params = Maps.newHashMap();
                    params.put("username", u.getUsername());
                    params.put("password", decrypt);
                    params.put("grant_type", "password");
                    params.put("client_id", "client");
                    params.put("client_secret", "secret");

                    Map<String, Object> map = new HashMap<>();
                    try {
                        // 解析响应结果封装并返回
                        Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH_TOKEN, params);
                        String jsonString = Objects.requireNonNull(response.body()).string();
                        JSONObject jsonObject = JSON.parseObject(jsonString);
                        String token = String.valueOf(jsonObject.get("access_token"));
                        result.put("token", token);
                        //返回Map数据
                        Map<String, String> payload = new HashMap<>();
                        payload.put("name", u.getUsername());
                        map.put("status", true);
                        map.put("msg", "认证成功");
                        map.put("token", token);
                        map.put("admin", u);
                        sendAdminLoginLog(u,request);
                        return Result.success().data(map);
                    } catch (Exception e) {
                        throw new CustomException(CustomStatus.ADMIN_PASSWORD);
                        //return Result.error().data("认证失败");
                        //e.printStackTrace();
                    }

                }
            }else{
                throw new CustomException(CustomStatus.ADMIN_PASSWORD);
            }
        }else{
            throw new CustomException(CustomStatus.ADMIN_PASSWORD);
        }
    }


    private Boolean sendAdminLoginLog(User user, HttpServletRequest request){
        //User user = userService.getUserByUsername(username);
        AdminLoginLog adminLoginLog = new AdminLoginLog();
        adminLoginLog.setAdminId(user.getId());
        adminLoginLog.setCreateTime(new Date().getTime());
        return messageService.sendAdminLoginLog(adminLoginLog);
    }

}
