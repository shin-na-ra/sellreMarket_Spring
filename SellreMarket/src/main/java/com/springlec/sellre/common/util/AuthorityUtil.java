package com.springlec.sellre.common.util;

import static com.springlec.sellre.common.support.Constants.LOGIN_USER_SESSION_NAME;

import com.springlec.sellre.auth.domain.User;
import com.springlec.sellre.auth.exception.AuthorizationErrorCode;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthorityUtil {
	/**
	 * @deprecated 대체됨: getUserOrThrow(HttpServletRequest): User
	 * @param request
	 * @param response
	 */
	@Deprecated(forRemoval = true, since = "버전(일반적)이나 날짜 등을 쓸 수 있음.")
	public static void requireSigning(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(LOGIN_USER_SESSION_NAME);
		
		if (user == null) {
			// response.setStatus(401);
			throw new RuntimeException("로그인되어 있지 않습니다.");
		}
	}
	
	public static User getUserOrThrow(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(LOGIN_USER_SESSION_NAME);
		
		if (user == null) {
			throw AuthorizationErrorCode.UNAUTHORIZED.defaultException();
		}
		
		return user;
	}
}
