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
public class Notice {

    private int id;
    private String title;
    private String content;
    private String informer;
    private String isshow;
    private int noticetime;
    private int createtime;
    private int updatetime;

}
