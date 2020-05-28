package com.leyou.order.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description:
 * @data: 2020/5/23 23:19
 * @author: xiaoNan
 */
@Data
@Table(name = "tb_order_status")
public class OrderStatus {

    @Id
    private Long orderId;
    private Integer status;
    private Date createTime;
    private Date paymentTime;
    private Date consignTime;
    private Date endTime;
    private Date closeTime;
    private Date commentTime;
}
