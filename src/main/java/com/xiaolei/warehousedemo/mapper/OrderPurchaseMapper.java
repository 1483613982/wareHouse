package com.xiaolei.warehousedemo.mapper;

import com.xiaolei.warehousedemo.entity.OrderPurchase;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderPurchaseMapper {

    List<OrderPurchase> getOrderPurchaseList(String supplier, String goodsname, String state, int page, int size);

    OrderPurchase getOrderPurchase(int id);

    int getCount();

    int addOrderPurchase(OrderPurchase orderPurchase);

    int deleteOrderPurchasenById(int id);

    int updateOrderPurchasen(OrderPurchase orderPurchase);


}
