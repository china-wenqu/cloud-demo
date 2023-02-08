package com.wenqu.mapper;

import com.wenqu.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;
import java.util.List;

@Mapper
public interface PermissionMapper extends MyMapper<Permission> {
    List<Permission> getPermissionListByUserId(@Param("userId") Long userId);
}