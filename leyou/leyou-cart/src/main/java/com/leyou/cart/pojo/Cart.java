package com.leyou.cart.pojo;

import lombok.Data;

/**
 * @description: redis中存储的购物车商品结构
 * @data: 2020/5/23 15:02
 * @author: xiaoNan
 */
@Data
public class Cart {
    /**
     * 商品id
     */
    private Long skuId;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片
     */
    private String image;
    /**
     * 加入购物车时的价格
     */
    private Long price;
    /**
     * 购买数量
     */
    private Integer num;
    /**
     * 商品的规格参数
     */
    private String ownSpec;
}
