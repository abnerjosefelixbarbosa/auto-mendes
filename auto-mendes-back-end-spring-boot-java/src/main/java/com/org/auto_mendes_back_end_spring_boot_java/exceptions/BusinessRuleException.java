package com.org.auto_mendes_back_end_spring_boot_java.exceptions;

public class BusinessRuleException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BusinessRuleException() {
		super();
	}

	public BusinessRuleException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessRuleException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessRuleException(String message) {
		super(message);
	}

	public BusinessRuleException(Throwable cause) {
		super(cause);
	}
}