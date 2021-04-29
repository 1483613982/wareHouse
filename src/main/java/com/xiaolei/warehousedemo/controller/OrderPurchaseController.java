package com.xiaolei.warehousedemo.controller;

import com.xiaolei.warehousedemo.mapper.GoodsMapper;
import com.xiaolei.warehousedemo.mapper.OrderPurchaseMapper;
import com.xiaolei.warehousedemo.mapper.SupplierMapper;
import com.xiaolei.warehousedemo.entity.Goods;
import com.xiaolei.warehousedemo.entity.OrderPurchase;
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
@Api(tags = {"进货订单"})
@RequestMapping("/api/OrderPurchase")
@RestController
public class OrderPurchaseController {

    @Autowired
    OrderPurchaseMapper orderPurchaseMapper;
    @Autowired
    SupplierMapper supplierMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @ApiOperation(value = "分页查询")
    @PostMapping("/getOrderPurchaseList")
    public RetResult<OrderPurchaseList> getOrderPurchaseList( @RequestBody SearchOrderPurchase searchOrderPurchase) {
        String supplier = searchOrderPurchase.getSupplier();
        String goodsname = searchOrderPurchase.getGoodsname();
        String state = searchOrderPurchase.getState();
        int page = searchOrderPurchase.getPage();
        int size = searchOrderPurchase.getSize();
        page = page - 1;
        List<OrderPurchase> list = orderPurchaseMapper.getOrderPurchaseList(supplier, goodsname, state, page, size);
        int count = orderPurchaseMapper.getCount();
        OrderPurchaseList orderPurchaseList = new OrderPurchaseList();
        orderPurchaseList.list = list;
        orderPurchaseList.total = count;
        return RetResponse.makeOKRsp(orderPurchaseList);
    }

    @ApiOperation(value = "查询信息")
    @GetMapping("/getOrderPurchase")
    public RetResult<OrderPurchase> getOrderPurchase(int id) {
        OrderPurchase orderPurchase = orderPurchaseMapper.getOrderPurchase(id);
        if (orderPurchase == null) {
            return RetResponse.makeErrRsp("为查询到订单信息");
        } else {
            return RetResponse.makeOKRsp(orderPurchase);
        }
    }

    @ApiOperation(value = "添加订单")
    @PostMapping("/addOrderPurchase")
    public RetResult<String> addOrderPurchase(@RequestBody OrderPurchase orderPurchase) {

        String goodsname = orderPurchase.getGoodsname();
        List<Goods> list = goodsMapper.getGoodsByGoodsName(goodsname);
        if (list.size() == 0) {
            return RetResponse.makeErrRsp("未查询到商品信息");
        }
        String suppliername = orderPurchase.getSupplier();
        List<Supplier> supplierlist = supplierMapper.getSupplierBySName(suppliername);
        if (supplierlist.size() == 0) {
            return RetResponse.makeErrRsp("未查询到供应商信息");
        }
        int state = orderPurchaseMapper.addOrderPurchase(orderPurchase);
        if (state >= 1) {
            return RetResponse.makeOKRsp("添加成功");
        } else {
            return RetResponse.makeErrRsp("添加失败");
        }

    }

    @ApiOperation(value = "删除订单")
    @GetMapping("/deleteOrderPurchasenById")
    public RetResult<String> deleteOrderPurchasenById(int id) {
        int state = orderPurchaseMapper.deleteOrderPurchasenById(id);
        if (state >= 1) {
            return RetResponse.makeOKRsp("删除成功");
        } else {
            return RetResponse.makeErrRsp("删除失败");
        }
    }

    @ApiOperation(value = "更新订单")
    @PostMapping("/updateOrderPurchasen")
    public RetResult<String> updateOrderPurchasen(@RequestBody OrderPurchase orderPurchase) {
        String goodsname = orderPurchase.getGoodsname();
        List<Goods> list = goodsMapper.getGoodsByGoodsName(goodsname);
        if (list.size() == 0) {
            return RetResponse.makeErrRsp("未查询到商品信息");
        }
        String suppliername = orderPurchase.getSupplier();
        List<Supplier> supplierlist = supplierMapper.getSupplierBySName(suppliername);
        if (supplierlist.size() == 0) {
            return RetResponse.makeErrRsp("未查询到供应商信息");
        }
        int state = orderPurchaseMapper.updateOrderPurchasen(orderPurchase);
        if (state >= 1) {
            return RetResponse.makeOKRsp("更新成功");
        } else {
            return RetResponse.makeErrRsp("更新失败");
        }
    }


}


class OrderPurchaseList {
    public List<OrderPurchase> list;
    public Integer total;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class SearchOrderPurchase {
   private String supplier, goodsname, state;
    private  int page, size;

}