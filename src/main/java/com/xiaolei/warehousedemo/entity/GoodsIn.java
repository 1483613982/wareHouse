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
public class GoodsIn {

    private int id;
    private String goodname;
    private String supplier;
//    private String goodimgurl;
    private int inNumber;
    private int intime;
    private String inShelves;
    private String operator;
    private String remarks;

}
