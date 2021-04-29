package com.xiaolei.warehousedemo.controller;

import com.xiaolei.warehousedemo.mapper.GoodsInMapper;
import com.xiaolei.warehousedemo.mapper.GoodsMapper;
import com.xiaolei.warehousedemo.mapper.ShelvesMapper;
import com.xiaolei.warehousedemo.entity.GoodsIn;
import com.xiaolei.warehousedemo.entity.Shelves;
import com.xiaolei.warehousedemo.ret.RetResponse;
import com.xiaolei.warehousedemo.ret.RetResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* 类注解 */
@Api(tags = {"入库管理"})
@RequestMapping("/api/GoodsIn")
@RestController
public class GoodsInController {

    @Autowired
    GoodsInMapper goodsInMapper;
    @Autowired
    ShelvesMapper shelvesMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @ApiOperation(value = "分页查询")
    @GetMapping("/getGoodsInByPage")
    public RetResult<GoodInList> getGoodsInByPage(int page, int size) {
        page = page - 1;
        List<GoodsIn> list = goodsInMapper.getGoodsInBypage(page, size);
        int count = goodsInMapper.getCount();
        GoodInList goodInList = new GoodInList();
        goodInList.list = list;
        goodInList.total = count;
        return RetResponse.makeOKRsp(goodInList);
    }

    @ApiOperation(value = "查询入库信息")
    @GetMapping("/getGoodsIn")
    public RetResult<GoodsIn> getGoodsOut(int id) {
        GoodsIn goodsIn = goodsInMapper.getGoodsIn(id);
        if (goodsIn == null) {
            return RetResponse.makeErrRsp("为查询到商品信息");
        } else {
            return RetResponse.makeOKRsp(goodsIn);
        }
    }

    @ApiOperation(value = "添加入库记录")
    @PostMapping("/addGoodsIn")
    public RetResult<String> addGoodsIn(@RequestBody GoodsIn goodsIn) {

        String shelvesNumber = goodsIn.getInShelves();
        Shelves shelves = shelvesMapper.getShelvesBySNumber(shelvesNumber);
        if (shelves == null) {
            return RetResponse.makeErrRsp("为查询到该货架");
        }

        int state = goodsInMapper.addGoodsIn(goodsIn);
        if (state >= 1) {
            return RetResponse.makeOKRsp("添加成功");
        } else {
            return RetResponse.makeErrRsp("添加失败");
        }

    }

    @ApiOperation(value = "删除入库信息")
    @GetMapping("/deleteGoodsIn")
    public RetResult<String> deleteGoodsIn(int id) {
        int state = goodsInMapper.deleteGoodsInById(id);
        if (state >= 1) {
            return RetResponse.makeOKRsp("删除成功");
        } else {
            return RetResponse.makeErrRsp("删除失败");
        }
    }

    @ApiOperation(value = "更新")
    @PostMapping("/updateGoodsIn")
    public RetResult<String> updateGoodsIn(@RequestBody GoodsIn goodsIn) {
        int state = goodsInMapper.updateGoodsIn(goodsIn);
        if (state >= 1) {
            return RetResponse.makeOKRsp("更新成功");
        } else {
            return RetResponse.makeErrRsp("更新失败");
        }
    }

    @ApiOperation(value = "模糊查询")
    @GetMapping("getGoodsInByGoodsName")
    public RetResult<List<GoodsIn>> getGoodsInByGoodsName(String goodsname) {
        List<GoodsIn> list = goodsInMapper.getGoodsInByGoodsName(goodsname);
        return RetResponse.makeOKRsp(list);
    }

}

class GoodInList {
    public List<GoodsIn> list;
    public Integer total;
}