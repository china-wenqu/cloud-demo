package com.wenqu.service.impl;

import com.wenqu.domain.User;
import com.wenqu.mapper.UserMapper;
import com.wenqu.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;

@Service
@DubboService(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserByUsername(String username) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username",username);
        return userMapper.selectOneByExample(example);
    }
}
