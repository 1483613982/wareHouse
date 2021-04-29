package com.xiaolei.warehousedemo.controller;

import com.xiaolei.warehousedemo.mapper.GoodsMapper;
import com.xiaolei.warehousedemo.mapper.OrderSaleMapper;
import com.xiaolei.warehousedemo.mapper.SupplierMapper;
import com.xiaolei.warehousedemo.entity.Goods;
import com.xiaolei.warehousedemo.entity.OrderSale;
import com.xiaolei.warehousedemo.entity.Supplier;
import com.xiaolei.warehousedemo.ret.RetResponse;
import com.xiaolei.warehousedemo.ret.RetResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* 类注解 */
@Api(tags = {"销售订单"})
@RequestMapping("/api/OrderSale")
@RestController
public class OrderSaleController {

    @Autowired
    OrderSaleMapper orderSaleMapper;
    @Autowired
    SupplierMapper supplierMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @ApiOperation(value = "分页查询")
    @PostMapping("/getOrderSaleList")
    public RetResult<OrderSaleList> getOrderSaleList( @RequestBody SearchOrderSale searchOrderSale) {
        String supplier = searchOrderSale.getSupplier();
        String goodsname = searchOrderSale.getGoodsname();
        String state = searchOrderSale.getState();
        int page = searchOrderSale.getPage();
        int size = searchOrderSale.getSize();
        page = page - 1;
        List<OrderSale> list = orderSaleMapper.getOrderSaleList(supplier, goodsname, state, page, size);
        int count = orderSaleMapper.getCount();
        OrderSaleList orderSaleList = new OrderSaleList();
        orderSaleList.list = list;
        orderSaleList.total = count;
        return RetResponse.makeOKRsp(orderSaleList);
    }

    @ApiOperation(value = "查询信息")
    @GetMapping("/getOrderSale")
    public RetResult<OrderSale> getOrderSale(int id) {
        OrderSale orderSale = orderSaleMapper.getOrderSale(id);
        if (orderSale == null) {
            return RetResponse.makeErrRsp("为查询到订单信息");
        } else {
            return RetResponse.makeOKRsp(orderSale);
        }
    }

    @ApiOperation(value = "添加订单")
    @PostMapping("/addOrderSale")
    public RetResult<String> addOrderSale(@RequestBody OrderSale orderSale) {

        String goodsname = orderSale.getGoodsname();
        List<Goods> list = goodsMapper.getGoodsByGoodsName(goodsname);
        if (list.size() == 0) {
            return RetResponse.makeErrRsp("未查询到商品信息");
        }
        String suppliername = orderSale.getSupplier();
        List<Supplier> supplierlist = supplierMapper.getSupplierBySName(suppliername);
        if (supplierlist.size() == 0) {
            return RetResponse.makeErrRsp("未查询到供应商信息");
        }
        int state = orderSaleMapper.addOrderSale(orderSale);
        if (state >= 1) {
            return RetResponse.makeOKRsp("添加成功");
        } else {
            return RetResponse.makeErrRsp("添加失败");
        }

    }

    @ApiOperation(value = "删除订单")
    @GetMapping("/deleteOrderSaleById")
    public RetResult<String> deleteOrderSaleById(int id) {
        int state = orderSaleMapper.deleteOrderSaleById(id);
        if (state >= 1) {
            return RetResponse.makeOKRsp("删除成功");
        } else {
            return RetResponse.makeErrRsp("删除失败");
        }
    }

    @ApiOperation(value = "更新订单")
    @PostMapping("/updateOrderSale")
    public RetResult<String> updateOrderSale(@RequestBody OrderSale orderSale) {
        String goodsname = orderSale.getGoodsname();
        List<Goods> list = goodsMapper.getGoodsByGoodsName(goodsname);
        if (list.size() == 0) {
            return RetResponse.makeErrRsp("未查询到商品信息");
        }
        String suppliername = orderSale.getSupplier();
        List<Supplier> supplierlist = supplierMapper.getSupplierBySName(suppliername);
        if (supplierlist.size() == 0) {
            return RetResponse.makeErrRsp("未查询到供应商信息");
        }
        int state = orderSaleMapper.updateOrderSale(orderSale);
        if (state >= 1) {
            return RetResponse.makeOKRsp("更新成功");
        } else {
            return RetResponse.makeErrRsp("更新失败");
        }
    }


}


class OrderSaleList {
    public List<OrderSale> list;
    public Integer total;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class SearchOrderSale {
   private String supplier, goodsname, state;
    private  int page, size;

}