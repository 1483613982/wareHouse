package com.xiaolei.warehousedemo.controller;

import com.xiaolei.warehousedemo.dao.ShelvesMapper;
import com.xiaolei.warehousedemo.dao.UserMapper;
import com.xiaolei.warehousedemo.entity.User;
import com.xiaolei.warehousedemo.ret.RetResponse;
import com.xiaolei.warehousedemo.ret.RetResult;
import com.xiaolei.warehousedemo.utils.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 类注解 */
@Api(tags = {"用户接口"})
@RequestMapping("/api/Shelves")
@RestController
public class ShelvesController {

    @Autowired
    ShelvesMapper shelvesMapper;




}
