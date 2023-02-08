package com.wenqu.mapper;

import com.wenqu.domain.AdminLoginLog;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;

@Mapper
public interface AdminLoginLogMapper extends MyMapper<AdminLoginLog> {
}