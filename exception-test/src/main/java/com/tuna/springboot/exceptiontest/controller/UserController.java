package com.tuna.springboot.exceptiontest.controller;

import com.tuna.springboot.exceptiontest.customerexception.BizException;
import com.tuna.springboot.exceptiontest.entity.HttpResult;
import com.tuna.springboot.exceptiontest.entity.User;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    /**
     * 无异常的请求
     * @return
     */
    @GetMapping("/list")
    public HttpResult list() {
        System.out.println("开始查询...");
        List<User> userList =new ArrayList();
        User user=new User();
        user.setId(1L);
        user.setName("Van");
        user.setAge(18);
        userList.add(user);
        return HttpResult.success(userList);
    }

    /**
     * 模拟自定义异常
     * @param user
     * @return
     */
    @PostMapping("/insert")
    public HttpResult insert(@RequestBody User user) {
        System.out.println("开始新增...");
        //如果姓名为空就手动抛出一个自定义的异常！
        if(user.getName()==null){
            throw  new BizException(-1,"用户姓名不能为空！");
        }
        return new HttpResult();
    }

    /**
     * 这里故意发送post请求，模拟请求方式错误
     * @param user
     * @return
     */
    @PutMapping("/update")
    public HttpResult update(@RequestBody User user) {
        System.out.println("开始更新...");
        return new HttpResult();
    }

    /**
     * 模拟其他异常
     * @param id
     * @return
     */
    @DeleteMapping("/deleteById")
    public HttpResult deleteById(Long id, HttpServletRequest req)  {
        System.out.println("开始删除...");
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return new HttpResult();
    }
}
