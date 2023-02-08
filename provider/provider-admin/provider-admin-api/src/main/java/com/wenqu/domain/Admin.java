package com.wenqu.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "`admin`")
public class Admin implements Serializable {
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 登录账号
     */
    @Column(name = "username")
    private String username;

    /**
     * 登录密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 是否初始0否1是(不可删除)
     */
    @Column(name = "is_default")
    private Integer isDefault;

    /**
     * 是否启用0禁用1启用
     */
    @Column(name = "is_enabled")
    private Integer isEnabled;

    private static final long serialVersionUID = 1L;
}