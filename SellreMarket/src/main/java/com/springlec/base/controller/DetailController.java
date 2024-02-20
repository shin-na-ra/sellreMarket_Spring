package com.springlec.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springlec.base.service.DetailService;

@Controller
public class DetailController {
	
	@Autowired
	DetailService detailService;
	
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
	public String productDetailPage() {
		System.out.println("해치웠나?");
		return "detail/productDetailPage";	
	}
	

}
