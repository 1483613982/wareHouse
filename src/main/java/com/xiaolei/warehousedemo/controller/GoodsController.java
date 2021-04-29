package com.xiaolei.warehousedemo.controller;

import com.xiaolei.warehousedemo.mapper.GoodsMapper;
import com.xiaolei.warehousedemo.mapper.ShelvesMapper;
import com.xiaolei.warehousedemo.entity.Goods;
import com.xiaolei.warehousedemo.entity.Shelves;
import com.xiaolei.warehousedemo.ret.RetResponse;
import com.xiaolei.warehousedemo.ret.RetResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* 类注解 */
@Api(tags = {"仓库接口"})
@RequestMapping("/api/Goods")
@RestController
public class GoodsController {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    ShelvesMapper shelvesMapper;

    @ApiOperation(value = "分页查询商品信息")
    @GetMapping("/getGoodsByPage")
    public RetResult<GoodList> getGoodsByPage(int page, int size) {
        page = page - 1;
        List<Goods> list = goodsMapper.getGoodsBypage(page, size);
        int count = goodsMapper.getCount();
        GoodList goodList = new GoodList();
        goodList.list = list;
        goodList.total = count;
        return RetResponse.makeOKRsp(goodList);
    }

    @ApiOperation(value = "获得商品总数")
    @GetMapping("/getGoodsCount")
    public RetResult<Integer> getCount() {
        int count = goodsMapper.getCount();
        return RetResponse.makeOKRsp(count);
    }

    @ApiOperation(value = "查询预警商品")
    @GetMapping("getGoodsWarning")
    public RetResult<List<Goods>> getGoodsWarning(int stock){
        List<Goods> list = goodsMapper.getGoodsWarning(stock);
        return RetResponse.makeOKRsp(list);
    }

    @ApiOperation(value = "查询商品信息")
    @GetMapping("/getGoods")
    public RetResult<Goods> getGoods(int id) {
        Goods goods = goodsMapper.getGoods(id);
        if (goods == null) {
            return RetResponse.makeErrRsp("为查询到商品信息");
        } else {
            return RetResponse.makeOKRsp(goods);
        }
    }

    @ApiOperation(value = "添加商品")
    @PostMapping("/addGoods")
    public RetResult<String> addGoods(@RequestBody Goods goods) {

        String shelvesNumber = goods.getShelves_number();
        Shelves shelves = shelvesMapper.getShelvesBySNumber(shelvesNumber);
        if (shelves == null) {
            return RetResponse.makeErrRsp("为查询到该货架");
        }
        if (goods == null) {
            return RetResponse.makeErrRsp("传递参数不能为空");
        } else {
            int state = goodsMapper.addGoods(goods);
            if (state >= 1) {
                return RetResponse.makeOKRsp("添加成功");
            } else {
                return RetResponse.makeErrRsp("添加失败");
            }
        }
    }

    @ApiOperation(value = "删除商品")
    @GetMapping("/deleteGoods")
    public RetResult<String> deleteGoods(int id) {
        int state = goodsMapper.deleteGoodsById(id);
        if (state >= 1) {
            return RetResponse.makeOKRsp("删除成功");
        } else {
            return RetResponse.makeErrRsp("删除失败");
        }
    }

    @ApiOperation(value = "获取所有商品")
    @GetMapping("/getAllGoods")
    public RetResult<List<Goods>> getAllGoods(){
        List<Goods> list = goodsMapper.getAllGoods();
        return  RetResponse.makeOKRsp(list);
    }

    @ApiOperation(value = "更新商品")
    @PostMapping("/updateGoods")
    public RetResult<String> updateGoods(@RequestBody Goods goods) {
        int state = goodsMapper.updateGoods(goods);
        if (state >= 1) {
            return RetResponse.makeOKRsp("更新成功");
        } else {
            return RetResponse.makeErrRsp("更新失败");
        }
    }

    @ApiOperation(value = "模糊查询商品")
    @GetMapping("getGoodsBySNumber")
    public RetResult<List<Goods>> getGoodssBySNumber(String goodsname) {
        List<Goods> list = goodsMapper.getGoodsByGoodsName(goodsname);
        return RetResponse.makeOKRsp(list);
    }

}

class GoodList{
    public List<Goods> list;
    public Integer total;
}