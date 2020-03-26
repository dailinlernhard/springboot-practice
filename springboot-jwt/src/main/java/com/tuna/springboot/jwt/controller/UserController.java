package com.tuna.springboot.jwt.controller;


import com.tuna.springboot.jwt.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private JwtUtils jwtUtils;


    /**
     * 用户登录
     * 1.通过service根据mobile查询用户
     * 2.比较password
     * 3.生成jwt信息
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map login(@RequestBody Map<String, String> loginMap) {
        String userName = loginMap.get("userName");
        String password = loginMap.get("password");

        HashMap<Object, Object> resultMap = new HashMap<>();
        //登录失败
        if (userName.equals("admin") && password.equals("123456")) {

            //登录成功
            Map<String, Object> map = new HashMap<>();
            map.put("companyId", "6875");
            map.put("companyName", "tuna corporation");
            String token = jwtUtils.createJwt("1", "admin", map);


            resultMap.put("code", 200);
            resultMap.put("message", "login successfully");
            resultMap.put("jwt-token", token);

        } else {
            resultMap.put("message", "login faild");
            resultMap.put("code", 404);
        }

        return resultMap;

    }

    @GetMapping("/message")
    public Map getMessage(HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Object> resultMap = new HashMap<>();

        if (StringUtils.isEmpty(token)) {
            throw new RuntimeException("怎么没登录呢");
        } else {
            Claims claims = jwtUtils.parseJwt(token);

            resultMap.put("code", 200);
            resultMap.put("message", "欢迎光临");
            resultMap.put("user", claims.getSubject());
        }


        return resultMap;
    }

}
