package com.leyou.order.config;

import com.github.wxpay.sdk.WXPayConfig;
import lombok.Data;

import java.io.InputStream;

/**
 * @description:
 * @data: 2020/5/26 19:41
 * @author: xiaoNan
 */
@Data
public class PayConfig implements WXPayConfig {

    /**
     * 公众账号ID，自行申请注册
     */
    private String appID;
    /**
     * 商户号
     */
    private String mchID;
    /**
     * 生成签名的密钥
     */
    private String key;
    /**
     * 连接超时时间
     */
    private int httpConnectTimeoutMs;
    /**
     * 读取超时时间
     */
    private int httpReadTimeoutMs;
    /**
     * 下单通知回调地址
     */
    private String notifyUrl;

    @Override
    public InputStream getCertStream() {
        return null;
    }
}
