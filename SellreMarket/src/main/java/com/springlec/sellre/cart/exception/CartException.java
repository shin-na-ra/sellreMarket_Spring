package com.springlec.sellre.cart.exception;

import com.springlec.sellre.common.support.exception.CustomException;
import com.springlec.sellre.common.support.exception.ErrorCode;

public class CartException extends CustomException {
	public CartException() {
		super();
	}

	public CartException(ErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	public CartException(ErrorCode errorCode) {
		super(errorCode);
	}

	public CartException(String message, Throwable cause) {
		super(message, cause);
	}

	public CartException(String message) {
		super(message);
	}
}
