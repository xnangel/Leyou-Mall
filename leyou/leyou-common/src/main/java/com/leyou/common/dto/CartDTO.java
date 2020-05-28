package com.leyou.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @data: 2020/5/23 23:43
 * @author: xiaoNan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    /**
     * 商品id
     */
    private Long skuId;
    /**
     * 购买数量
     */
    private Integer num;
}
