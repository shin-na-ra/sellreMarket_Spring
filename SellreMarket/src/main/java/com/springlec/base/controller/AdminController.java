package com.springlec.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springlec.base.model.BrandDto;
import com.springlec.base.service.AdminBrandService;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AdminController {

	
    protected static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    protected static final Logger fileLogger = LoggerFactory.getLogger("fileLogger");
	
	@Autowired
	AdminBrandService adminBrandService;
	
	//시작페이지
//	@GetMapping("/")
//	public String start() {
//		return "index";
//	}

	
	//관리자 브랜드 현황 조회
	@GetMapping("/adminBrand")
	public String adminBrand(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		List<BrandDto> list = adminBrandService.list();
		model.addAttribute("list",list);
		
		return "adminBrand";
		
	}
	
	//관리자 브랜드 상세 조회 
	@GetMapping("/adminBrandDetail")
	public String adminBrandDetail(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		String bname = request.getParameter("bname");
		System.out.println("sysdo :" +bname);
		List<BrandDto> list = adminBrandService.detail(bname);
		model.addAttribute("list", list);
		
		return "adminBrandDetail";
		
	}
	
	
	
	

	
	
}
