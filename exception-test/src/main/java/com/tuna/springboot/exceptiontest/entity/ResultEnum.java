package com.tuna.springboot.exceptiontest.entity;

public enum ResultEnum {

    SUCCESS(200, "成功!"),

    // 数据操作错误定义,
    DEFAULT(-1, "一般错误"),
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401,"请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!")
    ;

    /** 错误码 */
    private Integer code;

    /** 错误描述 */
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
