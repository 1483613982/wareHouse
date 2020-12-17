package com.xiaolei.warehousedemo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;  //用户Id
    private String username;   // 用户名
    private String password; // 密码
    private String createTime; // 创建时间
    private String updateTime; // 更新时间

}
