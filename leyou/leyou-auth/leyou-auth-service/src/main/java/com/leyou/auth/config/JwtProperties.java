package com.leyou.auth.config;

import com.leyou.auth.utils.RsaUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @description: jwt配置文件类，数据来自application文件
 * @data: 2020/3/23 12:28
 * @author:
 */
@Data
@ConfigurationProperties(prefix = "leyou.jwt")
public class JwtProperties {

    private String secret;
    private String pubKeyPath;
    private String priKeyPath;
    private int expire;
    private String cookieName;

    /**
     * 公钥
     */
    private PublicKey publicKey;
    /**
     * 私钥
     */
    private PrivateKey privateKey;

    /**
     * 对象一旦实例化【后】，就应该读取公钥和私钥
     * @PostConstruct 是java自己的注解，该注解被用于修饰一个 非静态的void方法。
     *  被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。
     *  @PostConstruct在构造函数之后执行，init方法之前执行。
     * 在Spring框架中使用到@PostConstruct注解，该注解的方法在整个Bean初始化中的执行顺序：
     *  Constructor（构造方法） -> @Autowired（依赖注入） -> @PostConstruct（注释的方法）
     */
    @PostConstruct
    public void init() throws Exception {
        // 公钥私钥如果不存在，先生成
        File pubPath = new File(pubKeyPath);
        File priPath = new File(priKeyPath);
        if (!pubPath.exists() || !priPath.exists()) {
            // 生成公钥和私钥
            RsaUtils.generateKey(pubKeyPath, priKeyPath, secret);
        }
        // 读取公钥和私钥
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }
}
