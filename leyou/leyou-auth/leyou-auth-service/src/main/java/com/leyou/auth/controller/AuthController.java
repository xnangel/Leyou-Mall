package com.leyou.auth.controller;

import com.leyou.auth.config.JwtProperties;
import com.leyou.auth.entity.UserInfo;
import com.leyou.auth.service.AuthService;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @data: 2020/3/23 18:48
 * @author:
 */
@RestController
@EnableConfigurationProperties(JwtProperties.class)
public class AuthController {

    @Value("${leyou.jwt.cookieName}")
    private String cookieName;
    @Autowired
    private JwtProperties properties;

    @Autowired
    private AuthService authService;

    /**
     * 登录授权
     * @param username  用户名
     * @param password  密码
     * @return
     */
    @PostMapping("login")
    public ResponseEntity<Void> login(
            @RequestParam("username") String username, @RequestParam("password") String password,
            HttpServletResponse response, HttpServletRequest request
    ) {
        // 登录
        String token = authService.login(username, password);

        CookieUtils.setCookie(request, response, cookieName, token, null, null, true);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 校验用户登录状态
     * @param token
     * @param request
     * @param response
     * @return
     */
    @GetMapping("verify")
    public ResponseEntity<UserInfo> verify(
            @CookieValue("LY_TOKEN") String token,
            HttpServletRequest request, HttpServletResponse response
    ) {
        if (StringUtils.isBlank(token)) {
            // 如果没有token，证明未登录，返回403
            throw new LyException(ExceptionEnum.UNAUTHORIZED);
        }

        try {
            // 解析token
            UserInfo userInfo = JwtUtils.getInfoFromToken(token, properties.getPublicKey());
            // 刷新token，重新生成token
            String newToken = JwtUtils.generateToken(userInfo, properties.getPrivateKey(), properties.getExpire());
            // 写入cookie
            CookieUtils.setCookie(request, response, properties.getCookieName(), newToken, null, null, true);
            // 已登录，返回用户信息
            return ResponseEntity.ok(userInfo);
        } catch (Exception e) {
            // token已过期， 或者 token被篡改
            throw new LyException(ExceptionEnum.UNAUTHORIZED);
        }
    }

}
