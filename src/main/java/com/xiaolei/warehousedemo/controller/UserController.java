package com.xiaolei.warehousedemo.controller;

import com.xiaolei.warehousedemo.mapper.UserMapper;
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
@RequestMapping("/api/User")
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @ApiOperation(value = "查询用户详情")
    @GetMapping("/getUser")
    public RetResult<User> getUser(String username) {
        if (username.isEmpty()) {
            return RetResponse.makeErrRsp("用户名必选传递");
        }
        User user = userMapper.findUserByUsername(username);
        user.setPassword("");
        return RetResponse.makeOKRsp(user);
    }

    @ApiOperation(value = "查询用户")
    @GetMapping("/findUser")
    public RetResult<List<User>> findUser(String username){
        List<User> userList = userMapper.findUser(username);
        return RetResponse.makeOKRsp(userList);
    }

    @ApiOperation(value = "查询用户总数")
    @GetMapping("/getCount")
    public RetResult<Integer> getCount(){
        int total = userMapper.getcount();
        return RetResponse.makeOKRsp(total);
    }

    @ApiOperation(value = "分页查询用户列表")
    @GetMapping("/getPageUser")
    public RetResult<List<User>> getUserBypage(int page,int size){
        page = page-1;
        List<User> list = userMapper.getUserBypage(page,size);
        return RetResponse.makeOKRsp(list);
    }

    @ApiOperation(value = "修改用户信息 除密码")
    @PostMapping("/updateUser")
    public RetResult<User> updateUser(@RequestBody User user) {
        int n = userMapper.updateUserById(user);
        System.out.println(n);
        if (n > 0) {
            return RetResponse.makeOKRsp();
        } else {
            return RetResponse.makeErrRsp("更新失败");
        }

    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/addUser")
    public RetResult<User> addUser(@RequestBody User user) {
        int n = userMapper.saveUser(user);
        if (n > 0) {
            return RetResponse.makeOKRsp();
        } else {
            return RetResponse.makeErrRsp("添加失败");
        }
    }

    @ApiOperation(value = "删除用户")
    @GetMapping("/deleteUser")
    public RetResult<User> deleteUser( int id) {
        int n = userMapper.deleteUserById(id);
        if (n > 0) {
            return RetResponse.makeOKRsp();
        } else {
            return RetResponse.makeErrRsp("添加失败");
        }
    }

    @ApiOperation(value = "查询用户列表")
    @GetMapping("/getUserList")
    public RetResult<List<User>> getUserList(String username, String password) {
        List<User> userList = userMapper.getUserList();
        if (userList.isEmpty()) {
            return RetResponse.makeErrRsp("获取用户列表失败");
        }
        return RetResponse.makeOKRsp(userList);
    }

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public RetResult<Map<String, Object>> login(@RequestBody User loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
//        String md5pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = userMapper.findUserByUsername(username);
        if (user != null) {
            if (!password.equals(user.getPassword())) {
                return RetResponse.makeErrRsp("用户名或密码错误");
            }
        }
        if (user == null) {
            return RetResponse.makeErrRsp("用户名不存在");
        }
        String token = TokenUtil.sign(loginUser);
        user.setPassword("");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", token);
        map.put("userInfo", user);
        return RetResponse.makeOKRsp(map);
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logOut")
    public RetResult<String> logOut() {
        return RetResponse.makeOKRsp("退出登录成功");
    }


}
