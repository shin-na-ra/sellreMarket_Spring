package com.springlec.sellre.cart.controller;

import static com.springlec.sellre.common.util.AuthorityUtil.getUserOrThrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springlec.sellre.auth.domain.User;
import com.springlec.sellre.cart.controller.dto.CartQueryResponseDto.CartListAndPriceQueryResponseDto;
import com.springlec.sellre.cart.service.CartService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	
	// 장바구니 page 보여주기.
	@GetMapping("/carts")
	public String cartListView(
			HttpServletRequest request,
			Model model
	) throws Exception {
		User loginUser = getUserOrThrow(request);
		// TODO input "admin" as default to test (remove later)
		String loginUserId = loginUser != null ? loginUser.getId() : "admin";
		
		CartListAndPriceQueryResponseDto dto = cartService.findCartsByUserId(loginUserId);
		
		model.addAttribute("carts", dto.carts());
		model.addAttribute("priceSummary", dto.priceSummary());
		
		request.setAttribute("router", "cart");
		return "gwangyeong";
	}
}
