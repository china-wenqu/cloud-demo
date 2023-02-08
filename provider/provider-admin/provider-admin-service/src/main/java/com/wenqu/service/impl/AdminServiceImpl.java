package com.wenqu.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.wenqu.domain.Admin;
import com.wenqu.service.AdminService;
import com.wenqu.service.AdminServiceFallback;
import com.wenqu.service.SentinelTestFallback;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wenqu.mapper.AdminMapper;
import tk.mybatis.mapper.entity.Example;

@Service
@DubboService(version = "1.0.0")
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    @SentinelResource(value = "sentinelTest",fallback = "sentinelTestFallback",fallbackClass = SentinelTestFallback.class)
    public Admin sentinelTest(String username) {
//        if("admin".equals(username)){
//            throw new IllegalArgumentException("invoke args");
//        }
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo("username", username);
        return adminMapper.selectOneByExample(example);
    }

    @Override
    @SentinelResource(value = "getAdminByUername",fallback = "getAdminByUsernameFallback",fallbackClass = AdminServiceFallback.class)
    public Admin selectAdminByUsername(String username) {
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo("username", username);
        return adminMapper.selectOneByExample(example);
    }

    @Override
    public Integer saveAdmin(Admin admin) {
        return adminMapper.save(admin);
    }
}
