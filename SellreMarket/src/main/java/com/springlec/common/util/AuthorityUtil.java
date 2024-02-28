package com.springlec.common.util;

import static com.springlec.common.support.Constants.LOGIN_USER_SESSION_NAME;

import com.springlec.auth.domain.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthorityUtil {
	public static void requireSigning(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(LOGIN_USER_SESSION_NAME);
		
		if (user == null) {
			// response.setStatus(401);
			throw new RuntimeException("로그인되어 있지 않습니다.");
		}
	}
}
