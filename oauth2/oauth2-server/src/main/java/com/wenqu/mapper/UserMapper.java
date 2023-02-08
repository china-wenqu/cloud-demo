package com.wenqu.mapper;

import com.wenqu.domain.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}