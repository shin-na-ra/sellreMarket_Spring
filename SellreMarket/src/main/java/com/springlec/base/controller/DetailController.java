package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springlec.base.model.DetailDto;
import com.springlec.base.service.DetailService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class DetailController {
	
	@Autowired
	DetailService service;
	
	//상품 선택 페이지
	@GetMapping("/productSelection")
	public String productSelection() {
		return "detail/testProductSelection";
	}
	
	//레시피 선택 페이지
	@GetMapping("/recipeSelection")
	public String recipeSelection() {
		return "detail/testRecipeSelection";
	}
	
	//상품 상세페이지
	@GetMapping("/productDetailPage")
	public String productDetailPage(HttpServletRequest request, Model model) throws Exception {
		// 언어 번역 장착
		request.setCharacterEncoding("utf-8");
		
		// 상품 선택창에서 recipeId 값 가져와 String 형태로 값 저장
		String productId = request.getParameter("productId");
		
		// 세션 생성, 그리고 세션에 productId 값을  PRODUCTID에 넣음
		HttpSession session = request.getSession();
		session.setAttribute("PRODUCTID", productId);
		
		//Dao에 PRODUCTID 값을 넣어서 조건 출력
		List<DetailDto> listDao =service.productListDao((String)session.getAttribute("PRODUCTID"));
		model.addAttribute("product",  listDao);
		
		return "detail/productDetailPage";
	}
	
	//레시피 상세페이지
	@GetMapping("/recipeDetailPage")
	public String recipeDetailPage(HttpServletRequest request, Model model) throws Exception {
		// 언어 번역 장착
		request.setCharacterEncoding("utf-8");
		
		// 레시피 선택창에서 recipeId 값 가져와 String 형태로 값 저장
		String recipeId = request.getParameter("recipeId");
		
		// 세션 생성, 그리고 세션에 recipeId 값을  RECIPEID에 넣음
		HttpSession session = request.getSession();
		session.setAttribute("RECIPEID", recipeId);
		
		//Dao에 RECIPEID 값을 넣어서 조건 출력
		List<DetailDto> listDao =service.recipeListDao((String)session.getAttribute("RECIPEID"));
		model.addAttribute("list", listDao);	
		
		return "detail/recipeDetailPage";
	}
	
	// 장바구니에 담자
	@PostMapping("/cartInput")
	public String cartInput(HttpServletRequest request, Model model) throws Exception{
		// 언어 번역 장착
		request.setCharacterEncoding("utf-8");
		
		// 상품 선택창에서 recipeId 값 가져와 String 형태로 값 저장
		String cartItemNames = request.getParameter("cartItemNames");
		String cartItemQuantities = request.getParameter("cartItemQuantities");
		
		System.out.println("진짜 카트 이름 옴? : " + cartItemNames);
		System.out.println("진짜 카트 수량 옴? : " + cartItemQuantities);
		
		String[] arrCartNames = cartItemNames.split(",");
		String[] arrCartQuantities = cartItemQuantities.split(",");
		
		System.out.println(arrCartNames.toString());
		System.out.println(arrCartQuantities.toString());
		
		// 상품 이름, 상품 수량들을 배열로 변환
		request.setAttribute("cartItemNames", arrCartNames);
		request.setAttribute("cartItemQuantities", arrCartQuantities);
		
		service.cartInputDao(arrCartNames, arrCartQuantities);
		
		return "redirect:/";
	}
}
