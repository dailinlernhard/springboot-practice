package com.tuna.springboot.jwt.interceptor;

import com.tuna.springboot.jwt.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    JwtUtils jwtUtils;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        // 执行认证
        if (StringUtils.isEmpty(token)) {
            throw new RuntimeException("无效token，请重新登录！");
        }

        Claims claims = jwtUtils.parseJwt(token);

        String user = claims.getSubject();
        String password = (String)claims.get("password");

        if(!user.equals("admin")){
            throw new RuntimeException("身份无效token，或登录过期，请重新登录！");
        }

        return true;
}


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
