package com.leyou.order.dto;

import com.leyou.common.dto.CartDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description:    DTO：data transfer object
 * @data: 2020/5/23 23:39
 * @author: xiaoNan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    /**
     * 收货人地址id
     */
    @NotNull
    private Long addressId;
    /**
     * 付款类型
     */
    @NotNull
    private Integer paymentType;
    /**
     * 订单详情
     */
    @NotNull
    private List<CartDTO> carts;
}
