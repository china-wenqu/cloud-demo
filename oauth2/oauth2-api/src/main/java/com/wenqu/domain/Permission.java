package com.wenqu.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
    * 权限表
    */
@Data
@Table(name = "tb_permission")
public class Permission implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 父权限
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 权限名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 权限英文名称
     */
    @Column(name = "enname")
    private String enname;

    /**
     * 授权路径
     */
    @Column(name = "url")
    private String url;

    /**
     * 备注
     */
    @Column(name = "description")
    private String description;

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