package com.leyou.auth.client;

import com.leyou.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @description:
 * @data: 2020/3/23 19:43
 * @author:
 */
@FeignClient("user-service")
public interface UserClient extends UserApi {

}
