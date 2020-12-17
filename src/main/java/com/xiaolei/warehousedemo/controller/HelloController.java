package com.xiaolei.warehousedemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* 类注解 */
@Api(value = "hello world")
@Controller
public class HelloController {

    /* 方法注解 */
    @ApiOperation(value = "desc of method", notes = "")
    @GetMapping(value = "/hello")
    public Object hello( /* 参数注解 */ @ApiParam(value = "desc of param", required = true) @RequestParam String name) {
        return "Hello " + name + "!";
    }
}
