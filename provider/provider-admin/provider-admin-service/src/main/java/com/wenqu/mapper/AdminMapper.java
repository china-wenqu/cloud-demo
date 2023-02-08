package com.wenqu.mapper;

import com.wenqu.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

@Mapper
public interface AdminMapper extends MyMapper<Admin> {
}