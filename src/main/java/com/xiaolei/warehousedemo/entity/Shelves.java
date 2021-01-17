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
    private String s_number;
    private int s_layer;
    private int s_column;
    private String s_outside;
    private int createtime;
    private int updatetime;
}
