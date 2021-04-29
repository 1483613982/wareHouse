package com.xiaolei.warehousedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ljh
 * @date 2021-04-12
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSale {

    private int id;
    private String supplier;
    private String buyer;
    private String goodsname;
    private String goodsimgurl;
    private double price;
    private String content;
    private String norms;
    private int outtime;
    private int outNumber;
    private String state;
    private int createtime;
    private int updatetime;

}
