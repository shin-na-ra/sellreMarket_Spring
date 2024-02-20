package com.springlec.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springlec.base.service.AdminCategoryService;

@Controller
public class AdminCategory {

	@Autowired
	AdminCategoryService service;
	
	//시작페이지
	@GetMapping("/")
	public String start() {
		return "index";
	}

	
	
}
