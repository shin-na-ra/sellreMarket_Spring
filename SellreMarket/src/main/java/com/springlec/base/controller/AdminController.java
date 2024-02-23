package com.springlec.base.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.BrandDto;
import com.springlec.base.service.AdminBrandService;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AdminController {

	
    protected static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    protected static final Logger fileLogger = LoggerFactory.getLogger("fileLogger");
	
	@Autowired
	AdminBrandService adminBrandService;
	
	//관리자 브랜드 현황 조회
	@GetMapping("/adminBrand")
	public String adminBrand(HttpServletRequest request, Model model) throws Exception {
		
		int page = 0;
		if((request.getParameter("page") == "") || request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int totalCnt = adminBrandService.boardCount();
		int index_no = (page - 1) * 15;
		
		int lastPage = (int) (Math.ceil((double) totalCnt/15));
		
		
		List<BrandDto> pageList = adminBrandService.pageList(page);
		AdminPageDto dto = adminBrandService.pagingParam(page);
		
		
		int rowNum = totalCnt - index_no;
		
		model.addAttribute("list", pageList);
		model.addAttribute("paging", dto);
		model.addAttribute("rowNum", rowNum);
		
		return "adminBrand";
		
	}
	
	//관리자 브랜드 상세 조회 
	@GetMapping("/adminBrandDetail")
	public String adminBrandDetail(HttpServletRequest request, Model model) throws Exception {
		
		String bname = request.getParameter("bname");
		HttpSession session = request.getSession();
		session.setAttribute("oldBname", bname);
		
		List<BrandDto> list = adminBrandService.detail(bname);
		model.addAttribute("list", list);
		
		return "adminBrandDetail";
		
	}
	
	//관리자 브랜드 수정
	@PostMapping("adminBrandUpdate")
	public String adminBrandUpdate(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		String bname = request.getParameter("bname");
		String oldBname = (String) session.getAttribute("oldBname");
		
		adminBrandService.update(bname, oldBname);
		
		return "redirect:/adminBrand"; 
	}
	
	//관리자 브랜드 삭제
	@PostMapping("/adminBrandDelete")
	public String adminBrandDelete (HttpServletRequest request)  throws Exception {
		
		String bname = request.getParameter("bname");
		adminBrandService.delete(bname);
		
		return "redirect:/adminBrand"; 
	}
	
	//관리자 브랜드 상태값 되돌리기
	@PostMapping("/adminBrandReDelete")
	public String adminBrandReDelete  (HttpServletRequest request)  throws Exception {
		
		String bname = request.getParameter("bname");
		adminBrandService.updateStatus(bname);
		
		return "redirect:/adminBrand"; 
		
	}
	
	//관리자 브랜드 등록 페이지
	@GetMapping("adminBrandRegister")
	public String adminBrandRegister () {
		return "adminBrandRegister";
	}
	
	//관리자 브랜드 등록하기
	@ResponseBody
	@PostMapping("insertBrand")
	public String insertBrand(HttpServletRequest request, Model model) throws Exception {
		
		String bname = request.getParameter("bname");
		
		int checkNum = adminBrandService.checkBrand(bname);
		
		if(checkNum == 0) {
			adminBrandService.insert(bname);
			return "1";
		} else {
			return "0";
		}
	}
	
	
	
}
