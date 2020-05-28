package com.leyou.item.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:Spu详情，垂直分表，目的减少读IO流
 * @data: 2020/2/25 11:41
 * @author:
 */
@Table(name = "tb_spu_detail")
@Data
public class SpuDetail {
    /**
     * 对应的SPU的id
     */
    @Id
    private Long spuId;
    /**
     * 商品描述信息
     */
    private String description;
    /**
     * 全部规格参数数据
     */
    private String genericSpec;
    /**
     * 特有规格参数及可选值信息，json格式
     */
    private String specialSpec;
    /**
     * 包装清单
     */
    private String packingList;
    /**
     * 售后服务
     */
    private String afterService;
}
