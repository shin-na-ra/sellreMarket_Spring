package com.springlec.sellre.controller;

import static com.springlec.common.support.Constants.LOGIN_USER_SESSION_NAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springlec.sellre.service.CartService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CartController {
	
	@Autowired
	CartService service;
	
	// TODO HTTP Method 구분할 수 있는 구조로 리팩토링 하면 URL에서 행위 제외
	@GetMapping("api/cart")
	public void mCartRegistry(HttpServletRequest request) {
		
	}
	
	// 장바구니 page 보여주기.
	
	// 장바구니 page에서 item 수량 변경하기.
	
	// 장바구니 page에서 item 가격 계산하기.
	
	// 장바구니 page에서 item 삭제하기.
	
	// 장바구니 page 테스트를 위한 임시 로그인
}
