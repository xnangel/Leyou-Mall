package com.leyou.order.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @description:
 * @data: 2020/5/25 23:01
 * @author: xiaoNan
 */
@FeignClient("item-service")
public interface GoodsClient extends GoodsApi {
}
