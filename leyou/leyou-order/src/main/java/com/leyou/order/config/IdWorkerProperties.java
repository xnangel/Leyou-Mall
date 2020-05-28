package com.leyou.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description:
 * @data: 2020/5/25 19:20
 * @author: xiaoNan
 */
@Data
@ConfigurationProperties(prefix = "ly.worker")
public class IdWorkerProperties {

    /**
     * 当前机器id
     */
    private long workerId;
    /**
     * 序列号
     */
    private long dataCenterId;
}
