package com.tuna.springboot.jwt.controller;


import com.tuna.springboot.jwt.entity.HttpResult;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获jwt超时异常
     * @param e 捕获的异常
     * @return 封装的返回对象
     **/
    @ExceptionHandler(ExpiredJwtException.class)
    public HttpResult handlerException(Throwable e) {

        return HttpResult.failure(500,e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public HttpResult handlerUnknownException(Throwable e) {

        return HttpResult.failure("未知异常:" + e.getMessage());
    }
}
