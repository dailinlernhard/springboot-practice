package com.tuna.springboot.exceptiontest.customerexception;

import lombok.Data;

@Data
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 */
	protected Integer code;
	/**
	 * 错误信息
	 */
	protected String msg;

	public BizException() {
		super();
	}

	
	public BizException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public BizException(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public BizException(Integer code, String msg, Throwable cause) {
		super(msg, cause);
		this.code = code;
		this.msg = msg;
	}

}
