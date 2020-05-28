package com.leyou.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:库存表
 * @data: 2020/2/25 20:28
 * @author:
 */
@Table(name = "tb_stock")
@Data
public class Stock {

    @Id
    private Long skuId;
    /**
     * 秒杀可用库存
     */
    private Integer seckillStock;
    /**
     * 已秒杀数量
     */
    private Integer seckillTotal;
    /**
     * 正常库存
     */
    private Integer stock;
}
