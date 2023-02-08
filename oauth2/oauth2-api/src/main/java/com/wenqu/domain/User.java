package com.wenqu.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
    * 用户表
    */
@Data
@Table(name = "tb_user")
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码，加密存储
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 注册手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 注册邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 创建时间
     */
    @Column(name = "created")
    private Long created;

    /**
     * 更新时间
     */
    @Column(name = "updated")
    private Long updated;

    private static final long serialVersionUID = 1L;
}