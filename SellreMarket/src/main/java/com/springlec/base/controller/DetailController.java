package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
		
		// 상품 선택창에서 productId 값 가져와 String 형태로 값 저장
		String productId = request.getParameter("productId");
		System.out.println("띠바 해치웠나? : " + productId);
		
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
	public ResponseEntity<String> cartInput(HttpServletRequest request, Model model) throws Exception{
		// 언어 번역 장착
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();		
		String userId = (String)session.getAttribute("id");
		
		// 상품 선택창에서 recipeId 값 가져와 String 형태로 값 저장
		String cartItemNames = request.getParameter("cartItemNames");
		String cartItemQuantities = request.getParameter("cartItemQuantities");
		
		System.out.println("진짜 카트 이름 옴? : " + cartItemNames);
		System.out.println("진짜 카트 수량 옴? : " + cartItemQuantities);
		
		// 상품 이름, 상품 수량들을 배열로 변환
		String[] arrCartNames = cartItemNames.split(",");
		String[] arrCartQuantities = cartItemQuantities.split(",");
		
		for(int i=0; i<arrCartNames.length; i++) {
			System.out.println("껀트롤 name : " + arrCartNames[i]);
			System.out.println("껀트롤 qty : " + arrCartQuantities[i]);
		}
		
		service.cartInputDao(arrCartNames, arrCartQuantities, userId);
		
		return ResponseEntity.ok("res");
	}
	
	// 장바구니에 담자
	@GetMapping("/cartProductInput")
	public String cartProductInput(HttpServletRequest request, Model model) throws Exception{
		
		// 언어 번역 장착
		request.setCharacterEncoding("utf-8");
		
		// 상품 선택창에서 recipeId 값 가져와 String 형태로 값 저장
		String sendValue = request.getParameter("sendValue");
		System.out.println("Tqlfk 값 들어왔냐? : " + sendValue);
		HttpSession session = request.getSession();		
		String userId = (String)session.getAttribute("id");
		System.out.println(userId);
		
		service.cartProductInputDao(sendValue, userId);
		
		return "redirect:/main";
	}	
}
