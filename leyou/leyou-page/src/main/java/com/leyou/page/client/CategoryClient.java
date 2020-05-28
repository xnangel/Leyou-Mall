package com.leyou.page.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @description:
 * @data: 2020/2/29 14:35
 * @author:
 */
@FeignClient("item-service")
public interface CategoryClient extends CategoryApi {

}
