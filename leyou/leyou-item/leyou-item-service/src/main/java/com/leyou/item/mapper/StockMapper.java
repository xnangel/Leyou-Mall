package com.leyou.item.mapper;

import com.leyou.common.mapper.BaseMapper;
import com.leyou.item.pojo.Stock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @description:
 * @data: 2020/2/25 20:35
 * @author:
 */
public interface StockMapper extends BaseMapper<Stock, Long> {

    /**
     * 减库存
     * @param id
     * @param num
     * @return
     */
    @Update("update tb_stock set stock = stock - #{num} where sku_id = #{id} and stock >= #{num}")
    int decreaseStock(@Param("id") Long id, @Param("num") Integer num);
}
