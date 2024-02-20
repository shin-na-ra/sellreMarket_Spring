package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springlec.base.model.BrandDto;
import com.springlec.base.service.AdminBrandService;
import com.springlec.base.service.AdminCategoryService;

@Controller
public class AdminController {

	@Autowired
	AdminBrandService adminBrandService;
	
	
	//시작페이지
	@GetMapping("/")
	public String start() {
		return "index";
	}

	//관리자 브랜드 현황 조회
	@GetMapping("/adminBrand")
	public String adminBrand(Model model) throws Exception {
		
		List<BrandDto> list = adminBrandService.list();
		
		model.addAttribute("list", list);
		return "adminBrand";
	}
	
	
}
