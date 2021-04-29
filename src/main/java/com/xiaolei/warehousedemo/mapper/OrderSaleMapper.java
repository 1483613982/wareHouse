package com.xiaolei.warehousedemo.mapper;

import com.xiaolei.warehousedemo.entity.OrderSale;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderSaleMapper {

    List<OrderSale> getOrderSaleList(String supplier, String goodsname, String state, int page, int size);

    OrderSale getOrderSale(int id);

    int getCount();

    int addOrderSale(OrderSale orderSale);

    int deleteOrderSaleById(int id);

    int updateOrderSale(OrderSale orderSale);


}
