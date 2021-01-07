package com.xiaolei.warehousedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Ljh
 * @date 2021-01-07
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shelves {

    private  int id;
    private String number;
    private int layer;
    private int column;
    private String outside;
    private int createtime;
    private int updatetime;
}
