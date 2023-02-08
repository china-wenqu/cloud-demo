package com.wenqu.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "admin_login_log")
public class AdminLoginLog implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "create_time")
    private Long createTime;

    private static final long serialVersionUID = 1L;
}