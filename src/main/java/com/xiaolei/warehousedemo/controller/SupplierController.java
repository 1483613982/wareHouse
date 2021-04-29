package com.xiaolei.warehousedemo.controller;

import com.xiaolei.warehousedemo.mapper.SupplierMapper;
import com.xiaolei.warehousedemo.entity.Supplier;
import com.xiaolei.warehousedemo.ret.RetResponse;
import com.xiaolei.warehousedemo.ret.RetResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ljh
 * @date 2021-01-06
 */
@Api(tags = {"供应商接口"})
@RequestMapping("/api/Supplier")
@RestController
public class SupplierController {

    @Autowired
    SupplierMapper supplierMapper;

    @ApiOperation(value = "分页获得供应商列表")
    @GetMapping("/getSupplierList")
    public RetResult<List<Supplier>> getSupplier(int page,int size) {
        page = page-1;
        List<Supplier> list = supplierMapper.getSupplierList(page,size);
        return RetResponse.makeOKRsp(list);
    }

    @ApiOperation(value = "查询供应商总数")
    @GetMapping("/getcount")
    public RetResult<Integer> getCount(){
        int count = supplierMapper.getCount();
        return  RetResponse.makeOKRsp(count);
    }

    @ApiOperation(value = "获取所有供应商")
    @GetMapping("/getAllSuppler")
    public RetResult<List<Supplier>> getAllSuppler(){
        List<Supplier> list = supplierMapper.getAllSuppler();
        return  RetResponse.makeOKRsp(list);
    }


    @ApiOperation(value = "添加供应商")
    @PostMapping("/addSupplier")
    public RetResult<String> addSupplier(@RequestBody Supplier supplier) {
        int n = supplierMapper.addSupplier(supplier);
        if (n > 0) {
            return RetResponse.makeOKRsp();
        } else {
            return RetResponse.makeErrRsp("添加失败！");
        }
    }

    @ApiOperation(value = "更新供应商信息")
    @PostMapping("/updateSupplier")
    public RetResult<String> updateSupplier(@RequestBody Supplier supplier){
        int n = supplierMapper.updateSupplier(supplier);
        if (n > 0) {
            return RetResponse.makeOKRsp();
        } else {
            return RetResponse.makeErrRsp("更新失败！");
        }
    }

    @ApiOperation(value = "通过ID删除供应商")
    @GetMapping("/deleteSupplier")
    public RetResult<String> deleteSupplier( int id){
        int n = supplierMapper.deleteSupplierById(id);
        if (n > 0) {
            return RetResponse.makeOKRsp();
        } else {
            return RetResponse.makeErrRsp("删除失败！");
        }
    }

    @ApiOperation(value = "通过供应商名称查询供应商列表")
    @GetMapping("/getSupplierlistByName")
    public RetResult<List<Supplier>> getSupplier(String name){
       List<Supplier>  list = supplierMapper.getSupplierBySName(name);
       return RetResponse.makeOKRsp(list);
    }
}
