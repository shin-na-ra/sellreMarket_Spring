package com.springlec.sellre.cart.exception;

import org.springframework.http.HttpStatus;

import com.springlec.sellre.common.support.exception.ErrorCode;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CartErrorCode implements ErrorCode {
	CART_ID_DUPLICATED("중복된 장바구니 일련번호입니다.", HttpStatus.CONFLICT),
	UNAUTHORIZED("로그인이 필요한 기능입니다.", HttpStatus.UNAUTHORIZED),
	NOT_OWN_ITEM("이 장바구니 소유자가 아닙니다.", HttpStatus.FORBIDDEN),
	DEFAULT("장바구니 오류", HttpStatus.INTERNAL_SERVER_ERROR); // 500
	
	private String message;
	private HttpStatus status;

	@Override
	public String defaultMessage() {
		return message;
	}

	@Override
	public HttpStatus defaultHttpStatus() {
		return status;
	}

	@Override
	public RuntimeException defaultException() {
		return new CartException(this);
	}

	@Override
	public RuntimeException defaultException(Throwable cause) {
		return new CartException(this, cause);
	}
}
