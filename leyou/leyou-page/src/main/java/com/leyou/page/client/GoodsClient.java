package com.leyou.page.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @description:
 * @data: 2020/2/29 15:27
 * @author:
 */
@FeignClient("item-service")
public interface GoodsClient extends GoodsApi {
}
