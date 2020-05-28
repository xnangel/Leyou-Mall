package com.leyou.order.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @data: 2020/5/23 23:07
 * @author: xiaoNan
 */
@Data
@Table(name = "tb_order")
public class Order {

    @Id
    private Long orderId;
    private Long totalPay;
    private Long actualPay;
    private Integer paymentType;

    private String promotionIds;
    private Long postFee = 0L;
    private Date createTime;
    private String shippingName;
    private String shippingCode;
    private Long userId;
    private String buyerMessage;
    private String buyerNick;
    private Boolean buyerRate;
    private String receiver;
    private String receiverMobile;
    private String receiverState;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverZip;
    /**
     * 发票类型，0无发票，1普通发票，2电子发票，3增值税发票
     */
    private Integer invoiceType = 0;
    /**
     * 订单来源，1：app端，2：pc端，3：M端，4：微信端，5：手机qq端
     */
    private Integer sourceType = 1;

    @Transient
    private OrderStatus orderStatus;
    @Transient
    private List<OrderDetail> orderDetails;
}
