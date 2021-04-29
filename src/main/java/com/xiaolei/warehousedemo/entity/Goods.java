package com.xiaolei.warehousedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ljh
 * @date 2021-01-18
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    private int id;
    private String goodsname;
    private String goodsnumber;
    private String goodimgurl;
    private String norms;
    private String content;
    private Double price;
    private String productcode;
    private String promitcode;
    private int stock;
    private String goodstype;
    private String state;
    private String shelves_number;
    private int shelves_layer;
    private int shelves_column;
    private int createtime;
    private int updatetime;

}
