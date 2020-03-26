package com.tuna.springboot.exceptiontest.entity;

import lombok.Data;

@Data
public class HttpResult {

    /**
     * 响应状态
     */
    protected boolean status;

    /**
     * 响应代码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object data;

    public HttpResult() {
    	this.status = true;
    }


    /**
     * 成功
     * @param data
     * @return
     */
    public static HttpResult success(Object data) {
        HttpResult httpResult = new HttpResult();
        httpResult.setStatus(true);
        httpResult.setCode(ResultEnum.SUCCESS.getCode());
        httpResult.setMessage(ResultEnum.SUCCESS.getMessage());
        httpResult.setData(data);
        return httpResult;
    }

    public static  HttpResult success(Object data, String msg) {
        HttpResult httpResult = new HttpResult();
        httpResult.setStatus(true);
        httpResult.setCode(ResultEnum.SUCCESS.getCode());
        httpResult.setMessage(msg);
        httpResult.setData(data);
        return httpResult;
    }
    /**
     * 失败
     */
    public static HttpResult failure() {
        HttpResult httpResult = new HttpResult();
        httpResult.setStatus(false);
        httpResult.setCode(ResultEnum.DEFAULT.getCode());
        return httpResult;
    }

    public static  HttpResult failure(String msg) {
        HttpResult httpResult = new HttpResult();
        httpResult.setStatus(false);
        httpResult.setCode(ResultEnum.DEFAULT.getCode());
        httpResult.setMessage(msg);
        return httpResult;
    }

    public static  HttpResult failure(int code, String msg) {
        HttpResult result = new HttpResult();
        result.setStatus(false);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}
