package com.xiaolei.warehousedemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/* 类注解 */
@Api(tags ={"用户接口"} )
@RequestMapping("/api/User")
@RestController
public class UserController {

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public String login(@ApiParam(value = "用户名", required = true) @RequestParam String username, @ApiParam(value = "密码", required = true) @RequestParam String password) {

        return "login";
    }
}
