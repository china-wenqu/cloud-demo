package com.wenqu.service;

import com.wenqu.domain.User;

public interface UserService{
    User selectByPrimaryKey(Long id);
    User getUserByUsername(String username);

}
