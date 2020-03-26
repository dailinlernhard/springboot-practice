package com.tuna.springboot.exceptiontest.exceptionhandler;

import com.tuna.springboot.exceptiontest.customerexception.BizException;
import com.tuna.springboot.exceptiontest.entity.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 异常捕获
     * @param e 捕获的异常
     * @return 封装的返回对象
     **/
    @ExceptionHandler(BizException.class)
    public HttpResult handlerException(Throwable e) {

        return HttpResult.failure(500,"发生自定义异常。。。");
    }

    @ExceptionHandler(Exception.class)
    public HttpResult handlerUnknownException(Throwable e) {

        return HttpResult.failure("未知异常:" + e.getMessage());
    }
}
