package com.springlec.sellre.common.support.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String name(); // -> enum 클래스들은 모두 기본적으로 구현됨. (우리가 안 만듦.)
    String defaultMessage();
    HttpStatus defaultHttpStatus();
    RuntimeException defaultException();
    RuntimeException defaultException(Throwable cause);
}
