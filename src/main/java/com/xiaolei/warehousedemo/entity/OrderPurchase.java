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
public class OrderPurchase {

    private int id;
    private String supplier;
    private String goodsname;
    private String goodsimgurl;
    private double price;
    private String content;
    private String norms;
    private int intime;
    private int inNumber;
    private String state;
    private int createtime;
    private int updatetime;

}

