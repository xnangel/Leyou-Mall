package com.leyou.item.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @description:Spu
 * @data: 2020/2/25 11:11
 * @author:
 */
@Table(name = "tb_spu")
@Data
public class Spu {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long brandId;
    private Long cid1;
    private Long cid2;
    private Long cid3;
    private String title;
    private String subTitle;
    private Boolean saleable;

    @JsonIgnore
    private Boolean valid;
    private Date createTime;

    /**
     * 在实体类向前台返回数据时用来忽略不想传递给前台的属性或接口。
     */
    @JsonIgnore
    private Date lastUpdateTime;

    /**
     * 非数据库字段
     * @Transient：表示该属性并非一个到数据库表的字段的映射,ORM框架将忽略该属性. 
     * 如果一个属性并非数据库表的字段映射,就务必将其标示为@Transient,否则,ORM框架默认其注解为@Basic
     */
    @Transient
    private String cname;
    @Transient
    private String bname;

    @Transient
    private List<Sku> skus;
    @Transient
    private SpuDetail spuDetail;
}
