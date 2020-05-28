package com.leyou.cart.interceptor;

import com.leyou.auth.entity.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.cart.config.JwtProperties;
import com.leyou.common.utils.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @data: 2020/3/25 21:10
 * @author:
 */
@Slf4j
public class UserInterceptor implements HandlerInterceptor {

    private JwtProperties jwtProperties;

    private static final ThreadLocal<UserInfo> tl = new ThreadLocal<>();

    public UserInterceptor(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 获取cookie中的token
        String token = CookieUtils.getCookieValue(request, jwtProperties.getCookieName());
        try {
            // 解析token
            UserInfo userInfo = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
            // 传递userInfo
            /* spring中不推荐使用域
            request.setAttribute("user", userInfo);*/
            tl.set(userInfo);
            // 放行
            return true;
        } catch (Exception e) {
            log.error("【购物车服务】 解析用户身份失败", e);
            // 拦截
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 最后用完数据，一定要清空
        tl.remove();
    }

    public static UserInfo getUser() {
        return tl.get();
    }
}
