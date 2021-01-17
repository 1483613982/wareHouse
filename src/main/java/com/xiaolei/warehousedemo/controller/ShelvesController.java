package com.xiaolei.warehousedemo.controller;

import com.xiaolei.warehousedemo.dao.ShelvesMapper;
import com.xiaolei.warehousedemo.dao.UserMapper;
import com.xiaolei.warehousedemo.entity.Shelves;
import com.xiaolei.warehousedemo.entity.Supplier;
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
@Api(tags = {"仓库接口"})
@RequestMapping("/api/Shelves")
@RestController
public class ShelvesController {

    @Autowired
    ShelvesMapper shelvesMapper;

    @ApiOperation(value = "分页查询货架信息")
    @GetMapping("/getShelvesByPage")
    public RetResult<List<Shelves>> getShelvesByPage(int page, int size) {
        page = page - 1;
        List<Shelves> list = shelvesMapper.getShelvesBypage(page, size);
        return RetResponse.makeOKRsp(list);
    }

    @ApiOperation(value = "获得货架总数")
    @GetMapping("/getShelvesCount")
    public RetResult<Integer> getCount() {
        int count = shelvesMapper.getCount();
        return RetResponse.makeOKRsp(count);
    }

    @ApiOperation(value = "查询货架信息")
    @GetMapping("/getShelves")
    public RetResult<Shelves> getShelves(int id) {
        Shelves shelves = shelvesMapper.getShelves(id);
        if (shelves == null) {
            return RetResponse.makeErrRsp("为查询到货架信息");
        } else {
            return RetResponse.makeOKRsp(shelves);
        }
    }

    @ApiOperation(value = "添加货架")
    @PostMapping("/addShelves")
    public RetResult<String> addShelves(@RequestBody Shelves shelves) {
        if (shelves == null) {
            return RetResponse.makeErrRsp("传递参数不能为空");
        } else {
            int state = shelvesMapper.addShelves(shelves);
            if (state >= 1) {
                return RetResponse.makeOKRsp("成功");
            } else {
                return RetResponse.makeErrRsp("添加失败");
            }
        }
    }

    @ApiOperation(value = "删除货架")
    @GetMapping("/deleteShelves")
    public RetResult<String> deleteShelves(int id) {
        int state = shelvesMapper.deleteShelvesById(id);
        if (state >= 1) {
            return RetResponse.makeOKRsp("删除成功");
        } else {
            return RetResponse.makeErrRsp("删除失败");
        }
    }

    @ApiOperation(value = "更新货架")
    @PostMapping("/updateShelves")
    public RetResult<String> updateShelves(@RequestBody Shelves shelves) {
        int state = shelvesMapper.updateShelves(shelves);
        if (state >= 1) {
            return RetResponse.makeOKRsp("更新成功");
        } else {
            return RetResponse.makeErrRsp("更新失败");
        }
    }

    @ApiOperation(value = "模糊查询")
    @GetMapping("getShelvesBySNumber")
    public RetResult<List<Shelves>> getShelvesBySNumber(String s_number) {
        List<Shelves> list = shelvesMapper.getShelvesBySNumber(s_number);
        return RetResponse.makeOKRsp(list);
    }

}
