package com.leyou.search.client;

import com.leyou.item.api.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @description:
 * @data: 2020/2/29 16:10
 * @author:
 */
@FeignClient("item-service")
public interface SpecificationClient extends SpecificationApi {
}
