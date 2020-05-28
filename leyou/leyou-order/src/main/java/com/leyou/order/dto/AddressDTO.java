package com.leyou.order.dto;

import lombok.Data;

/**
 * @description:
 * @data: 2020/5/25 19:37
 * @author: xiaoNan
 */
@Data
public class AddressDTO {

    private Long id;
    /**
     * 收件人姓名
     */
    private String name;
    /**
     * 电话
     */
    private String phone;
    /**
     * 省份
     */
    private String state;
    /**
     * 城市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 街道地址
     */
    private String address;
    /**
     * 邮编
     */
    private String zip;
    private Boolean isDefault;
}
