package com.xiaolei.warehousedemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户实体")
public class User {

    @ApiModelProperty("用户Id")
    private int id;
    @ApiModelProperty("用户名")
    private String username;   // 用户名
    @ApiModelProperty("用户昵称")
    private String usernick;   // 用户昵称
    @ApiModelProperty("密码")
    private String password; // 密码
    @ApiModelProperty("创建时间")
    private String create_time; // 创建时间
    @ApiModelProperty("更新时间")
    private String update_time; // 更新时间
    @ApiModelProperty("用户头像")
    private String avatar; //用户头像
    @ApiModelProperty("用户权限")
    private String rank; //用户权限

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
