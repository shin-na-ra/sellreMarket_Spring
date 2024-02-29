package com.springlec.sellre.auth.exception;

import org.springframework.http.HttpStatus;

import com.springlec.sellre.common.support.exception.ErrorCode;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AuthorizationErrorCode implements ErrorCode {
	UNAUTHORIZED("로그인이 필요한 기능입니다.", HttpStatus.UNAUTHORIZED),
	DEFAULT("인가 관련 오류", HttpStatus.INTERNAL_SERVER_ERROR);
	
	private final String message;
	private final HttpStatus status;
	
	@Override
	public String defaultMessage() {
		return message;
	}
	
	@Override
	public HttpStatus defaultHttpStatus() {
		return status;
	}
	
	@Override
	public AuthorizationException defaultException() {
		return new AuthorizationException(this);
	}
	
	@Override
	public AuthorizationException defaultException(Throwable cause) {
		return new AuthorizationException(this, cause);
	}
	
	
}
