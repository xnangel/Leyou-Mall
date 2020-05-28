package com.leyou.sms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: 短信服务基本属性
 * @data: 2020/3/11 16:06
 * @author:
 */
@Data
@ConfigurationProperties(prefix = "ly.sms")
public class SmsProperties {

    private String accessKeyId;
    private String accessKeySecret;
    private String signName;
    private String verifyCodeTemplate;
}
