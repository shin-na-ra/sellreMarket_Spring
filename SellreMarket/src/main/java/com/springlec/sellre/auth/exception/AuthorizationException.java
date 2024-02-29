package com.springlec.sellre.auth.exception;

import com.springlec.sellre.common.support.exception.CustomException;
import com.springlec.sellre.common.support.exception.ErrorCode;

public class AuthorizationException extends CustomException {
	public AuthorizationException() {
		super();
	}

	public AuthorizationException(ErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	public AuthorizationException(ErrorCode errorCode) {
		super(errorCode);
	}

	public AuthorizationException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthorizationException(String message) {
		super(message);
	}
}
