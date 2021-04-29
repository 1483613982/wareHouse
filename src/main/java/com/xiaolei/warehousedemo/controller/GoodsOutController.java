package com.xiaolei.warehousedemo.controller;

import com.xiaolei.warehousedemo.mapper.GoodsMapper;
import com.xiaolei.warehousedemo.mapper.GoodsOutMapper;
import com.xiaolei.warehousedemo.mapper.ShelvesMapper;
import com.xiaolei.warehousedemo.entity.GoodsOut;
import com.xiaolei.warehousedemo.entity.Shelves;
import com.xiaolei.warehousedemo.ret.RetResponse;
import com.xiaolei.warehousedemo.ret.RetResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* 类注解 */
@Api(tags = {"出库管理"})
@RequestMapping("/api/GoodsOut")
@RestController
public class GoodsOutController {

    @Autowired
    GoodsOutMapper goodsOutMapper;
    @Autowired
    ShelvesMapper shelvesMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @ApiOperation(value = "分页查询商品信息")
    @GetMapping("/getGoodsOutByPage")
    public RetResult<GoodOutList> getGoodsOutByPage(int page, int size) {
        page = page - 1;
        List<GoodsOut> list = goodsOutMapper.getGoodsOutBypage(page, size);
        int count = goodsOutMapper.getCount();
        GoodOutList goodOutList = new GoodOutList();
        goodOutList.list = list;
        goodOutList.total = count;
        return RetResponse.makeOKRsp(goodOutList);
    }

    @ApiOperation(value = "查询出库信息")
    @GetMapping("/getGoodsOut")
    public RetResult<GoodsOut> getGoodsOut(int id) {
        GoodsOut goodsOut = goodsOutMapper.getGoodsOut(id);
        if (goodsOut == null) {
            return RetResponse.makeErrRsp("为查询到商品信息");
        } else {
            return RetResponse.makeOKRsp(goodsOut);
        }
    }

    @ApiOperation(value = "添加出库记录")
    @PostMapping("/addGoodsOut")
    public RetResult<String> addGoodsOut(@RequestBody GoodsOut goodsOut) {

        String shelvesNumber = goodsOut.getOutShelves();
        Shelves shelves = shelvesMapper.getShelvesBySNumber(shelvesNumber);
        if (shelves == null) {
            return RetResponse.makeErrRsp("为查询到该货架");
        }

        int state = goodsOutMapper.addGoodsOut(goodsOut);
        if (state >= 1) {
            return RetResponse.makeOKRsp("添加成功");
        } else {
            return RetResponse.makeErrRsp("添加失败");
        }

    }

    @ApiOperation(value = "删除出库信息")
    @GetMapping("/deleteGoodsOut")
    public RetResult<String> deleteGoodsOut(int id) {
        int state = goodsOutMapper.deleteGoodsOutById(id);
        if (state >= 1) {
            return RetResponse.makeOKRsp("删除成功");
        } else {
            return RetResponse.makeErrRsp("删除失败");
        }
    }

    @ApiOperation(value = "更新")
    @PostMapping("/updateGoodsOut")
    public RetResult<String> updateGoodsOut(@RequestBody GoodsOut goodsOut) {
        int state = goodsOutMapper.updateGoodsOut(goodsOut);
        if (state >= 1) {
            return RetResponse.makeOKRsp("更新成功");
        } else {
            return RetResponse.makeErrRsp("更新失败");
        }
    }

    @ApiOperation(value = "模糊查询")
    @GetMapping("getGoodsOutByGoodsName")
    public RetResult<List<GoodsOut>> getGoodsOutByGoodsName(String goodsname) {
        List<GoodsOut> list = goodsOutMapper.getGoodsOutByGoodsName(goodsname);
        return RetResponse.makeOKRsp(list);
    }

}

class GoodOutList {
    public List<GoodsOut> list;
    public Integer total;
}