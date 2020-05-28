package com.leyou.auth.test;

import com.leyou.auth.entity.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.auth.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @description:
 * @data: 2020/3/23 10:48
 * @author:
 */
public class JwtTest {

    private static final String pubKeyPath = "E:\\prictice6_JavaEE\\projects\\leyou\\data\\rsa.pub";
    private static final String priKeyPath = "E:\\prictice6_JavaEE\\projects\\leyou\\data\\rsa.pri";

    private PublicKey publicKey;
    private PrivateKey privateKey;

    /**
     * 生成rsa的私钥和公钥
     * @throws Exception
     */
    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "hello word, hello XiaoNan");
    }

    /**
     * 从私钥和公钥的文件中获取私钥和公钥
     * @throws Exception
     */
    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    /**
     * 私钥生成token
     * @throws Exception
     */
    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    /**
     * 公钥解析token，获取对象信息
     * @throws Exception
     */
    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU4NDkzNzI5NH0.Zfq_scH8vPD0RugFd9vHLjQCLR2m_x4O2JyvmN344qI8aEq4dUb0MxWdCFQdNA1zlufvbF1XO6jdc0zjrvD2d6bqvXVVbTI0d4kKUoX0KQG3aZ9hbHV65024_XxWYlN9IFQ7vsO_wcUDpCT-evyqQIpELfQ_5JztFy5JGbEWr2c";
        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}
