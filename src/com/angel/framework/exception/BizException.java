package com.angel.framework.exception;

/**
 * 业务处理自定义异常
 * @author Jihann
 * @version 2015-1-30
 */
public class BizException 
				extends RuntimeException{

	private static final long serialVersionUID = -5688862067146400875L;

	public BizException() {
		super();
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(String message) {
		super(message);
	}

	public BizException(Throwable cause) {
		super(cause);
	}
}
