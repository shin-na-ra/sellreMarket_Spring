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

import com.springlec.base.model.AdminOrderDto;
import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.AdminQuestDto;
import com.springlec.base.model.BrandDto;
import com.springlec.base.model.Category;
import com.springlec.base.service.AdminBrandService;
import com.springlec.base.service.AdminCategoryService;
import com.springlec.base.service.AdminOrderService;
import com.springlec.base.service.AdminQuestService;

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
	
	@Autowired
	AdminQuestService adminQuestService;
	
	@Autowired
	AdminOrderService adminOrderService;
	
	@Autowired
	AdminCategoryService adminCategoryService;
	
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
	
	//관리자 고객문의 페이지 조회
	@GetMapping("/adminQuest")
	public String selectQuest(HttpServletRequest request, Model model) throws Exception {

		int page = 0;
		if((request.getParameter("page") == "") || request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int totalCnt = adminQuestService.listCount();
		int index_no = (page - 1) * 15;
		
		
		List<AdminQuestDto> list = adminQuestService.questList(page);
		AdminPageDto dto = adminQuestService.pagingParam(page);
		
		int rowNum = totalCnt - index_no;
		
		model.addAttribute("list", list);
		model.addAttribute("paging", dto);
		model.addAttribute("rowNum", rowNum);
		
		
		return "adminQuest";
	}
	
	//관리자 고객문의 상세 조회
	@GetMapping("/adminQuestDetail")
	public String adminQuestDetail(HttpServletRequest request, Model model) throws Exception {
		
		int inquiryid = Integer.parseInt(request.getParameter("inquiryid"));
		
		List<AdminQuestDto> list = adminQuestService.detail(inquiryid);
		
		model.addAttribute("list", list);
		
		return "adminQuestDetailPage";
	}
	
	//관리자 브랜드 수정
	@PostMapping("adminQuestUpdate")
	public String adminQuestUpdate(HttpServletRequest request) throws Exception {
		
		String answer = request.getParameter("answer");
		String inquiryid = request.getParameter("inquiryid");
		int num = adminQuestService.updateAnswer(answer, Integer.parseInt(inquiryid));
		
		return "redirect:/adminQuest";
	}
	
	//관리자 입고요청페이지 제품조회
	@GetMapping("/adminOrder")
	public String adminOrder(HttpServletRequest request, Model model) throws Exception {
	
		int page = 0;
		if((request.getParameter("page") == "") || request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int totalCnt = adminOrderService.listCount();
		int index_no = (page - 1) * 15;
		
		List<AdminOrderDto> pageList = adminOrderService.questList(page);
		AdminPageDto dto = adminOrderService.pagingParam(page);
		
		
		int rowNum = totalCnt - index_no;
		
		model.addAttribute("list", pageList);
		model.addAttribute("paging", dto);
		model.addAttribute("rowNum", rowNum);
		
		return "adminOrder";			
	}
	
	//관리자 입고요청 상세 조회
	@GetMapping("/adminOrderDetail")
	public String adminOrderDetail(HttpServletRequest request, Model model) throws Exception {
		
		int productid = Integer.parseInt(request.getParameter("productid"));
		List<AdminOrderDto> list = adminOrderService.detail(productid);
		
		model.addAttribute("list", list);
		
		return "adminOrderDetail";
	}
	
	//관리자 입고요청 하기
	@GetMapping("adminOrderInsert")
	public String adminOrderInsert(HttpServletRequest request, Model model) throws Exception {
		 
		String productid = request.getParameter("productid");
		String rcount = request.getParameter("rcount");
		String rcomment = request.getParameter("rcomment");
		
		adminOrderService.insertOrder(Integer.parseInt(rcount), rcomment, Integer.parseInt(productid));
		
		return "redirect:/adminOrder";
	}
	
	//관리자 카테고리 조회하기
	@GetMapping("/adminCategory")
	public String adminCategory (HttpServletRequest request, Model model) throws Exception {

		int page = 0;
		if((request.getParameter("page") == "") || request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int totalCnt = adminCategoryService.boardCount();
		int index_no = (page - 1) * 15;
		
		List<Category> list = adminCategoryService.list(page);
		AdminPageDto dto = adminCategoryService.pagingParam(page);
		
		int rowNum = totalCnt - index_no;
		
		model.addAttribute("list", list);
		model.addAttribute("paging", dto);
		model.addAttribute("rowNum", rowNum);
		
		return "adminCategory";			
	}

	//관리자 카테고리 등록 페이지 전환
	@GetMapping("adminCategoryRegister")
	public String adminCategoryRegister () {
		return "adminCategoryRegister";
	}
	
	//관리자 카테고리 등록
	@PostMapping("adminCategoryInsert")
	public String adminCategoryInsert (HttpServletRequest request) throws Exception {
		String type = request.getParameter("type");
		String subtype = request.getParameter("subtype");
		
		adminCategoryService.insertCategory(type, subtype);
		return "redirect:/adminCategory";
	}
	
	//관리자 카테고리 상세보기
	@GetMapping("adminCategoryDetail")
	public String adminCategoryDetail(HttpServletRequest request, Model model) throws Exception {
		
		int catetoryid = Integer.parseInt(request.getParameter("catetoryid"));
		List<Category> list = adminCategoryService.detail(catetoryid);
		
		model.addAttribute("list", list);
		System.out.println("lisdfsf : "+list.get(0).getStatus());
		return "adminCategoryDetail";
	}
	
	//관리자 카테고리 수정하기
	@PostMapping("adminCategoryUpdate")
	public String adminCategoryUpdate(HttpServletRequest request, Model model) throws Exception {
		int catetoryid = Integer.parseInt(request.getParameter("catetoryid"));
		String type = request.getParameter("type");
		String subtype = request.getParameter("subtype");
		
		adminCategoryService.update(catetoryid, type, subtype);
		
		return "redirect:/adminCategory";
	}
	
	//관리자 카테고리 삭제
	@PostMapping("adminCategoryDelete")
	public String adminCategoryDelete(HttpServletRequest request, Model model) throws Exception {
		int catetoryid = Integer.parseInt(request.getParameter("catetoryid"));
		
		adminCategoryService.delete(catetoryid);
		
		return "redirect:/adminCategory";
	}
	
	//관리자 카테고리 상태변경
	@PostMapping("adminCategoryChangeStatus")
	public String adminCategoryChangeStatus(HttpServletRequest request, Model model) throws Exception {
		int catetoryid = Integer.parseInt(request.getParameter("catetoryid"));
		
		adminCategoryService.changeStatus(catetoryid);
		
		return "redirect:/adminCategory";
	}
	
}
