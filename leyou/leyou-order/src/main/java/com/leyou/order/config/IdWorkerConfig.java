package com.leyou.order.config;

import com.leyou.common.utils.IdWorker;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @data: 2020/5/25 19:22
 * @author: xiaoNan
 */
@Configuration
@EnableConfigurationProperties(IdWorkerProperties.class)
public class IdWorkerConfig {

    /**
     * 注册IdWorker
     * @param idWorkerProperties
     * @return
     */
    @Bean
    public IdWorker idWorker(IdWorkerProperties idWorkerProperties) {
        return new IdWorker(idWorkerProperties.getWorkerId(), idWorkerProperties.getDataCenterId());
    }
}
