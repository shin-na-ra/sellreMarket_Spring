package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springlec.base.model.DetailDto;
import com.springlec.base.service.DetailService;

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
	public String productDetailPage(Model model) throws Exception {
		List<DetailDto> listDao =service.productListDao();
		model.addAttribute("list", listDao);
		return "detail/productDetailPage";
	}
	
	//레시피 상세페이지
	@GetMapping("/recipeDetailPage")
	public String recipeDetailPage(Model model) throws Exception {
		List<DetailDto> listDao =service.recipeListDao();
		model.addAttribute("list", listDao);
		return "detail/recipeDetailPage";
	}

}
