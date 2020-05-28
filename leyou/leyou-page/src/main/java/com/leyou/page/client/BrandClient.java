package com.leyou.page.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @description:
 * @data: 2020/2/29 16:11
 * @author:
 */
@FeignClient("item-service")
public interface BrandClient extends BrandApi {
}
