package com.xiaolei.warehousedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ljh
 * @date 2021-01-06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    private int id;
    private String s_name;
    private String s_address;
    private String s_mobile;
    private String postcode;
    private String contacts;
    private String mobile;
    private String bank;
    private String banknumber;
    private String e_mail;
    private String fax;
    private String state;
    private int createtime;
    private int updatetime;

}
