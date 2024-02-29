package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.dao.YoutubeDao;
import com.springlec.base.model.AdminChartDto;
import com.springlec.base.model.AdminDeliveryDto;
import com.springlec.base.model.AdminEventDto;
import com.springlec.base.model.AdminOrderDto;
import com.springlec.base.model.AdminPackDto;
import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.AdminProductDto;
import com.springlec.base.model.AdminQuestDto;
import com.springlec.base.model.BrandDto;
import com.springlec.base.model.Category;
import com.springlec.base.model.UserInfo;
import com.springlec.base.service.AdminBrandService;
import com.springlec.base.service.AdminCategoryService;
import com.springlec.base.service.AdminChartService;
import com.springlec.base.service.AdminEventService;
import com.springlec.base.service.AdminOrderService;
import com.springlec.base.service.AdminProductService;
import com.springlec.base.service.AdminQuestService;
import com.springlec.base.service.YoutubeService;

import jakarta.servlet.http.HttpServletRequest;
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
	
	@Autowired
	AdminEventService adminEventService;
	
	@Autowired
	AdminProductService adminProductService;
	
	@Autowired
	AdminChartService adminChartService;
	
	@Autowired
	YoutubeService youtubeService;
	
	
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
		
		String type = request.getParameter("type");
		String subtype = request.getParameter("subtype");
		List<Category> list = adminCategoryService.detail(type, subtype);
		
		model.addAttribute("list", list);
		return "adminCategoryDetail";
	}
	
	//관리자 카테고리 수정하기
	@PostMapping("adminCategoryUpdate")
	public String adminCategoryUpdate(HttpServletRequest request, Model model) throws Exception {
		String type = request.getParameter("type");
		String oldtype = request.getParameter("oldtype");
		String subtype = request.getParameter("subtype");
		String oldsubtype = request.getParameter("oldsubtype");
		
		adminCategoryService.update(type, subtype, oldtype, oldsubtype);
		
		
		return "redirect:/adminCategory";
	}
	
	//관리자 카테고리 삭제
	@PostMapping("adminCategoryDelete")
	public String adminCategoryDelete(HttpServletRequest request, Model model) throws Exception {
		
		String type = request.getParameter("type");
		String subtype = request.getParameter("subtype");
		
		adminCategoryService.delete(type, subtype);
		
		return "redirect:/adminCategory";
	}
	
	//관리자 카테고리 상태변경
	@PostMapping("adminCategoryChangeStatus")
	public String adminCategoryChangeStatus(HttpServletRequest request, Model model) throws Exception {
		
		String type = request.getParameter("type");
		String subtype = request.getParameter("subtype");
		
		adminCategoryService.changeStatus(type, subtype);
		
		return "redirect:/adminCategory";
	}
	
	//관리자 이벤트 조회하기
	@GetMapping("/adminEvent")
	public String adminEvent (HttpServletRequest request, Model model) throws Exception {

		int page = 0;
		if((request.getParameter("page") == "") || request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int totalCnt = adminEventService.boardCount();
		int index_no = (page - 1) * 15;
		
		List<AdminEventDto> list = adminEventService.list(page);
		AdminPageDto dto = adminEventService.pagingParam(page);
		
		int rowNum = totalCnt - index_no;
		
		model.addAttribute("list", list);
		model.addAttribute("paging", dto);
		model.addAttribute("rowNum", rowNum);
		
		return "adminEvent";			
	}
	
	//관리자 이벤트 등록페이지 전환
	@GetMapping("adminEventRegister")
	public String adminEventRegister(Model model) throws Exception {
		List<AdminOrderDto> list = adminEventService.productSelect();
		
		model.addAttribute("list", list);
		return "adminEventRegister";
	}
	
	//관리자 이벤트 등록
	@PostMapping("adminEventInsert")
		public String adminEventInsert(HttpServletRequest request, Model model, @RequestParam("image") MultipartFile file)  throws Exception {
	
		String ename = request.getParameter("ename");
		String econtent = request.getParameter("econtent");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		int salerate = Integer.parseInt(request.getParameter("salerate"));
		int productid = Integer.parseInt(request.getParameter("pname"));	//제품id
		
		int catetoryid = adminEventService.selectCategoryId(productid);
		
		String image = null;
		if(file != null && !file.isEmpty()) image = adminEventService.uploadFile(file);
		
		
		//제품등록
		adminEventService.insert(image, ename, econtent, startdate, enddate, salerate, productid, catetoryid);

		
		return "redirect:/adminEvent";
	}
	
	//관리자 이벤트 상세
	@GetMapping("adminEventDetail")
	public String adminEventDetail(HttpServletRequest request, Model model) throws Exception {
		
		int eventid = Integer.parseInt(request.getParameter("eventid"));
		List<AdminEventDto> list = adminEventService.detail(eventid);
		
		model.addAttribute("list", list);
		return "adminEventDetail";
	}
	
	@PostMapping("adminEventUpdate")
	public String adminEventUpdate(HttpServletRequest request, Model model , @RequestParam("image") MultipartFile file) throws Exception {
		int eventid = Integer.parseInt(request.getParameter("eventid"));
		String ename= request.getParameter("ename");
		String econtent= request.getParameter("econtent");
		String startdate= request.getParameter("startdate");
		String enddate= request.getParameter("enddate");
		int salerate= Integer.parseInt(request.getParameter("salerate"));
		
		
		String image = null;
		
		if(file != null && !file.isEmpty()) {
			image = adminProductService.uploadFile(file);
			adminEventService.update(eventid, ename, econtent, startdate, enddate, salerate, image);
		} else {
			adminEventService.updateNoImage(eventid, ename, econtent, startdate, enddate, salerate);
		}
			
		
		
		
		
		return "redirect:/adminEvent";
	}
	
	//관리자 카테고리 삭제
	@PostMapping("adminEventDelete")
	public String adminEventDelete(HttpServletRequest request, Model model) throws Exception {
		int eventid = Integer.parseInt(request.getParameter("eventid"));
		
		adminEventService.delete(eventid);
		
		return "redirect:/adminEvent";
	}
	
	
	//관리자 제품조회
	@GetMapping("/adminProduct")
	public String adminProduct(HttpServletRequest request, Model model) throws Exception {
	
		int page = 0;
		if((request.getParameter("page") == "") || request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int totalCnt = adminProductService.listCount();
		int index_no = (page - 1) * 15;
		
		List<AdminProductDto> pageList = adminProductService.list(page);
		AdminPageDto dto = adminProductService.pagingParam(page);
		
		
		int rowNum = totalCnt - index_no;
		
		model.addAttribute("list", pageList);
		model.addAttribute("paging", dto);
		model.addAttribute("rowNum", rowNum);
		
		return "admin_product";			
	}
	
	//관리자 제품 등록 페이지 전환
	@GetMapping("adminProductRegister")
	public String adminProductRegister(Model model) throws Exception {
		
		List<BrandDto> brandList =  adminProductService.brandList();
		List<Category> categoryList = adminProductService.categoryList();
		List<AdminPackDto> packList = adminProductService.selectPackType();
		List<AdminPackDto> pakcKind = adminProductService.selectPackKind();
		List<AdminDeliveryDto> deliveryList = adminProductService.selectDelivery();
		List<Category> subCategoryList = adminProductService.selectSubCategory();
		
		model.addAttribute("brandList", brandList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("packList", packList);
		model.addAttribute("pakcKind", pakcKind);
		model.addAttribute("deliveryList", deliveryList);
		model.addAttribute("subCategoryList", subCategoryList);
		
		return "adminProductRegister";
	}
	
	//중분류 카테고리 가져오기
	@ResponseBody
	@PostMapping("selectSubCategory")
	public List<Category> selectSubCategory(HttpServletRequest request) throws Exception {
		String type = request.getParameter("categoryType");
	    List<Category> subList = adminProductService.subCategoryList(type);
	    return subList;
	  }
	
	//관리자 product 등록
	@PostMapping("adminProductInsert")
	public String adminProductInsert(HttpServletRequest request, Model model, @RequestParam("image") MultipartFile file)  throws Exception {
		String pname = request.getParameter("pname");
		String allery = request.getParameter("allery");
		String nutrition = request.getParameter("nutrition");
		int pstock = Integer.parseInt(request.getParameter("pstock"));
		String origin = request.getParameter("origin");
		String description = request.getParameter("description");
		
		int price = Integer.parseInt(request.getParameter("price"));
		String bname = request.getParameter("bname");
		String type = request.getParameter("type");
		String subtype = request.getParameter("subtype");
		String packkind = request.getParameter("packkind");
		String packtype = request.getParameter("packtype");
		String utype = request.getParameter("utype");
		String ugram = request.getParameter("ugram");
		String dname = request.getParameter("dname");
		
		String image = null;
		if(file != null && !file.isEmpty()) image = adminProductService.uploadFile(file);
		
		
		//제품등록
		adminProductService.insertInfo(pname,  allery, nutrition, pstock, origin, description
				,price, bname, subtype, type, packkind, packtype, utype, ugram, dname, image);
	
		return "redirect:/adminProduct";
		
	}
	
	//관리자 제품 검색
	@PostMapping("productListQuery")
	public String productListQuery(HttpServletRequest request, Model model) throws Exception {
		String search = request.getParameter("search");
		
		int page = 0;
		if((request.getParameter("page") == "") || request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<AdminProductDto> list = adminProductService.listQuery(search, page);
		
		int totalCnt = adminProductService.searchCount(search);
		int index_no = (page - 1) * 15;
		
		AdminPageDto dto = adminProductService.pagingParam2(page, search);
		
		
		int rowNum = totalCnt - index_no;
		
		model.addAttribute("list", list);
		model.addAttribute("paging", dto);
		model.addAttribute("rowNum", rowNum);
		
		
		return "admin_product";
	}
	
	//관리자 브랜드 검색
	@PostMapping("brandListQuery")
	public String brandListQuery(HttpServletRequest request, Model model) throws Exception {
		String search = request.getParameter("search");
		
		int page = 0;
		if((request.getParameter("page") == "") || request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<BrandDto> list = adminBrandService.listQuery(search, page);
		
		int totalCnt = adminBrandService.searchCount(search);
		int index_no = (page - 1) * 15;
		
		AdminPageDto dto = adminBrandService.pagingParam2(page, search);
		
		
		int rowNum = totalCnt - index_no;
		
		model.addAttribute("list", list);
		model.addAttribute("paging", dto);
		model.addAttribute("rowNum", rowNum);
		
		
		return "adminBrand";
	}
	
	//관리자 문의 검색
	@PostMapping("qusetListQuery")
	public String qusetListQuery(HttpServletRequest request, Model model) throws Exception {
		String search = request.getParameter("search");
		String query = request.getParameter("query");
		
		int page = 0;
		if((request.getParameter("page") == "") || request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<AdminQuestDto> list = adminQuestService.listQuery(search, query, page);
		
		int totalCnt = adminQuestService.searchCount(search, query);
		int index_no = (page - 1) * 15;
		
		AdminPageDto dto = adminQuestService.pagingParam2(page,search,query);
		
		
		int rowNum = totalCnt - index_no;
		
		model.addAttribute("list", list);
		model.addAttribute("paging", dto);
		model.addAttribute("rowNum", rowNum);
		
		
		return "adminQuest";
	}
	
	@PostMapping("orderListQuery")
	public String orderListQuery(HttpServletRequest request, Model model) throws Exception {
		String search = request.getParameter("search");
		
		int page = 0;
		if((request.getParameter("page") == "") || request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<AdminOrderDto> list = adminOrderService.listQuery(search, page);
		
		int totalCnt = adminOrderService.searchCount(search);
		int index_no = (page - 1) * 15;
		
		AdminPageDto dto = adminOrderService.pagingParam2(page, search);
		
		
		int rowNum = totalCnt - index_no;
		
		model.addAttribute("list", list);
		model.addAttribute("paging", dto);
		model.addAttribute("rowNum", rowNum);
		
		
		return "adminOrder";
	}
	
	//카테고리 검색
	@PostMapping("categoryQuery")
	public String categoryQuery(HttpServletRequest request, Model model) throws Exception {
		String search = request.getParameter("search");
		String query = request.getParameter("query");
		
		int page = 0;
		if((request.getParameter("page") == "") || request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<Category> list = adminCategoryService.listQuery(search, query, page);
		
		int totalCnt = adminCategoryService.searchCount(search, query);
		int index_no = (page - 1) * 15;
		
		AdminPageDto dto = adminCategoryService.pagingParam2(page,search,query);
		
		
		int rowNum = totalCnt - index_no;
		
		model.addAttribute("list", list);
		model.addAttribute("paging", dto);
		model.addAttribute("rowNum", rowNum);
		
		
		return "adminCategory";
	}
	
	//이벤트 검색
	@PostMapping("eventListQuery")
	public String eventListQuery(HttpServletRequest request, Model model) throws Exception {
		String search = request.getParameter("search");
		String query = request.getParameter("query");
		
		int page = 0;
		if((request.getParameter("page") == "") || request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<AdminEventDto> list = adminEventService.listQuery(search, query, page);
		
		int totalCnt = adminEventService.searchCount(search, query);
		int index_no = (page - 1) * 15;
		
		AdminPageDto dto = adminEventService.pagingParam2(page,search,query);
		
		
		int rowNum = totalCnt - index_no;
		
		model.addAttribute("list", list);
		model.addAttribute("paging", dto);
		model.addAttribute("rowNum", rowNum);
		
		
		return "adminEvent";
	}
	
	//제품 상세보기
	@PostMapping("adminProductDetail")
	public String adminProductDetail(HttpServletRequest request, Model model) throws Exception {
		
		//해당 id의 제품 정보 가져오기
		int productid = Integer.parseInt(request.getParameter("productid"));
		List<AdminProductDto> list = adminProductService.detail(productid);
		
		//select box를 위한 정보 가져오기
		List<BrandDto> brandList =  adminProductService.brandList();
		List<Category> categoryList = adminProductService.categoryList();
		List<AdminPackDto> packList = adminProductService.selectPackType();
		List<AdminPackDto> pakcKind = adminProductService.selectPackKind();
		List<AdminDeliveryDto> deliveryList = adminProductService.selectDelivery();
		List<Category> subCategoryList = adminProductService.selectSubCategory();
		
		model.addAttribute("list", list);
		model.addAttribute("brandList", brandList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("packList", packList);
		model.addAttribute("pakcKind", pakcKind);
		model.addAttribute("deliveryList", deliveryList);
		model.addAttribute("subCategoryList", subCategoryList);
		
		return "adminProductDetail";
	}
	
	//제품 수정하기
	@PostMapping("adminProductUpdate")
	public String adminProductUpdate(HttpServletRequest request, Model model, @RequestParam("image") MultipartFile file) throws Exception {
		String pname = request.getParameter("pname");
		String allery = request.getParameter("allery");
		String nutrition = request.getParameter("nutrition");
		int pstock = Integer.parseInt(request.getParameter("pstock"));
		String origin = request.getParameter("origin");
		String description = request.getParameter("description");
		
		int price = Integer.parseInt(request.getParameter("price"));
		String bname = request.getParameter("bname");
		String type = request.getParameter("type");
		String subtype = request.getParameter("subtype");
		String packkind = request.getParameter("packkind");
		String packtype = request.getParameter("packtype");
		String utype = request.getParameter("utype");
		String ugram = request.getParameter("ugram");
		String dname = request.getParameter("dname");
		
		int productid = Integer.parseInt(request.getParameter("productid"));
		
		String image = null;
		if(file != null && !file.isEmpty()) image = adminProductService.uploadFile(file);
		
		//제품등록
		adminProductService.updateInfo(pname, allery, nutrition, pstock, origin, description
				,price, bname, subtype, type, packkind, packtype, utype, ugram, dname, productid, image);
	
		return "redirect:/adminProduct";
	}
	
	//제품 삭제하기
	@PostMapping("adminProductDelete")
	public String adminProductDelete(HttpServletRequest request, Model model) throws Exception {
		int productid = Integer.parseInt(request.getParameter("productid"));
		adminProductService.delete(productid);
		
		return "redirect:/adminProduct";
	}
	
	//현황차트 페이지
	@GetMapping("adminSales")
	public String adminSales() {
		return "adminSales";
	}
	
	//매출 불러오기
	@ResponseBody
	@PostMapping("showSaleChart")
	public List<AdminChartDto> showSaleChart(Model model) throws Exception {
		List<AdminChartDto> list = adminChartService.list();
		
		return list;
	}
	
	@ResponseBody
	@PostMapping("showPopular")
	public List<AdminChartDto> showPopular(Model model) throws Exception {
		List<AdminChartDto> list = adminChartService.popular();
		return list;
	}
	
	@ResponseBody
	@PostMapping("showGender")
	public List<AdminChartDto> showGender(Model model) throws Exception {
		List<AdminChartDto> list = adminChartService.gender();
		return list;
	}
	
	@ResponseBody
	@PostMapping("showUser")
	public List<AdminChartDto> showUser(Model model) throws Exception {
		List<AdminChartDto> list = adminChartService.user();
		return list;
	}
	
	//adminLogin 페이지 이동
	@GetMapping("adminLogin")
	public String adminLogin() throws Exception {
		return "adminLogin";
	}
	
	//adminLogin Check
	@PostMapping("adminLoginCheck")
	public  ResponseEntity<String> adminLoginCheck(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		List<UserInfo> check = adminProductService.checkID(id, password);
		
		if (check.get(0).getUserid().equals(id) && check.get(0).getPassword().equals(password)) {
			session.setAttribute("adminLogin", id);
			return ResponseEntity.ok("true");
			
		} else {
			return ResponseEntity.ok("false");
		}
	}
	
	@GetMapping("adminLogout")
	public String adminLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
		    session.removeAttribute("adminid"); // adminid 제거
		}
		
		return "adminLogin";
	}
	
	//제품 상태 변경 - 다시 살려!!
	@PostMapping("changeProductStatus")
	public String changeProductStatus(HttpServletRequest request, Model model) throws Exception {
		
		int productid = Integer.parseInt(request.getParameter("productid"));
		
		adminProductService.changeStatus(productid);
		System.out.println("dddd  L: " + productid);
		
		return "redirect:/adminProduct";
	}
	
	
	//레시피 등록 페이지
	@GetMapping("adminRecipe")
	public String adminRecipe(Model model) throws Exception{
		List<Category> categoryList = youtubeService.categoryList();
		List<Category> subCategoryList = youtubeService.selectSubCategory();
		
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("subCategoryList", subCategoryList);
		
		
		return "adminRecipeRegister";
	}
	
	
	//카테고리에 해당하는 제품 가져오기
	@ResponseBody
	@PostMapping("searchForProduct")
	public List<AdminProductDto> searchForProduct(HttpServletRequest request) throws Exception {
		
		String type = request.getParameter("type");
		String subtype = request.getParameter("subtype");
	    List<AdminProductDto> list = youtubeService.getProductlist(type, subtype);
	    
	    return list;
	}
	
	@PostMapping("adminRecipeInsert")
	public String adminRecipeInsert(HttpServletRequest request ,@RequestParam("ysrc") MultipartFile file) throws Exception {
		String yname = request.getParameter("yname");
		String ytitle = request.getParameter("ytitle");
		String image = null;
		String rcontent = request.getParameter("rcontent");
		String[] selectedProducts = request.getParameterValues("selectedProducts");
		
		if(file != null && !file.isEmpty()) image = youtubeService.uploadFile(file);
		
		youtubeService.insertInfo(yname, image, rcontent, selectedProducts, ytitle);
		
		
		return "redirect:/adminRecipe";
	}
}
