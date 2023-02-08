package com.wenqu.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminLoginLog implements Serializable {
    private static final long serialVersionUID = -4284274574708324212L;
    private Long id;

    private Long adminId;

    private Long createTime;

}