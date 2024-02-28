package com.springlec.base.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springlec.base.model.Product;
import com.springlec.base.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {

	@Autowired
	ProductService service;
	
	
	int curPage = 1;
	String id = null;
	
	@GetMapping({"/main","/"})
	public String newProductPage(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String id = null;
		
		String adImage = service.newAdImg();
		String headerCategory = "신상품";
		String alignCategory = "신상품순";
		 
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		List<Product> newProducts = service.productView(request, curPage, headerCategory, alignCategory);
		service.cartCount(request, id);
		
		// for header 클릭 시 컬러 표시
		session.setAttribute("headerCategory", headerCategory);
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("alignCategory", alignCategory);
		model.addAttribute("headerCategory", headerCategory);
		model.addAttribute("newProducts", newProducts);
		model.addAttribute("img", adImage);
		
		return "newProduct";
	}
	
	@GetMapping("/alignNewLowPrice")
	public String newProductPageAlignAsc(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String adImage = service.newAdImg();
		String headerCategory = "신상품";
		String alignCategory = "낮은 가격순";
		
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> newProducts = service.productView(request, curPage, headerCategory, alignCategory);
		service.cartCount(request, id);
		
		// for header 클릭 시 컬러 표시
		session.setAttribute("headerCategory", headerCategory);
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("alignCategory", alignCategory);
		model.addAttribute("headerCategory", headerCategory);
		model.addAttribute("newProducts", newProducts);
		model.addAttribute("img", adImage);
		
		return "newProduct";
	}
	
	@GetMapping("/alignNewHighPrice")
	public String newProductPageAlignDesc(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String adImage = service.newAdImg();
		String headerCategory = "신상품";
		String alignCategory = "높은 가격순";
		 
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> newProducts = service.productView(request, curPage, headerCategory, alignCategory);
		service.cartCount(request, id);
		
		// for header 클릭 시 컬러 표시
		session.setAttribute("headerCategory", headerCategory);
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("alignCategory", alignCategory);
		model.addAttribute("headerCategory", headerCategory);
		model.addAttribute("newProducts", newProducts);
		model.addAttribute("img", adImage);
		
		return "newProduct";
	}
	
	@GetMapping("/bestProduct")
	public String bestProductPage(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		List<Product> adImgs = service.bestAdImgs();
		String headerCategory = "베스트";
		String alignCategory = "베스트순";
		
		// session으로 보내서 request로 받는게 가능하다?
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<Product> bestProducts = service.productView(request, curPage, headerCategory, alignCategory);
		service.cartCount(request, id);
		
		// for header 클릭 시 컬러 표시
		session.setAttribute("headerCategory", headerCategory);
		
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("adImgs", adImgs);
		model.addAttribute("alignCategory", alignCategory);
		model.addAttribute("headerCategory", headerCategory);
		model.addAttribute("bestProducts", bestProducts);
		
		return "bestProduct";
	}
	
	@GetMapping("/alignBestLowPrice")
	public String bestProductPageAlignAsc(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		List<Product> adImgs = service.bestAdImgs();
		String headerCategory = "베스트";
		String alignCategory = "낮은 가격순";
		
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> bestProducts = service.productView(request, curPage, headerCategory, alignCategory);
		service.cartCount(request, id);
		
		// for header 클릭 시 컬러 표시
		session.setAttribute("headerCategory", headerCategory);
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("adImgs", adImgs);
		model.addAttribute("alignCategory", alignCategory);
		model.addAttribute("headerCategory", headerCategory);
		model.addAttribute("bestProducts", bestProducts);
		
		return "bestProduct";
	}
	
	@GetMapping("/alignBestHighPrice")
	public String bestProductPageAlignDesc(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		List<Product> adImgs = service.bestAdImgs();
		String headerCategory = "베스트";
		String alignCategory = "높은 가격순";
		
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> bestProducts = service.productView(request, curPage, headerCategory, alignCategory);
		service.cartCount(request, id);
		
		// for header 클릭 시 컬러 표시
		session.setAttribute("headerCategory", headerCategory);
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("adImgs", adImgs);
		model.addAttribute("alignCategory", alignCategory);
		model.addAttribute("headerCategory", headerCategory);
		model.addAttribute("bestProducts", bestProducts);
		
		return "bestProduct";
	}
	
	@GetMapping("/recipeProduct")
	public String recipeProductPage(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String headerCategory = "레시피";
		String alignCategory = "레시피";
		
		
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> recipeProducts = service.productView(request, curPage, headerCategory, alignCategory);
		service.cartCount(request, id);
		
		// for header 클릭 시 컬러 표시
		session.setAttribute("headerCategory", headerCategory);
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("alignCategory", alignCategory);
		model.addAttribute("headerCategory", headerCategory);
		model.addAttribute("recipeProducts", recipeProducts);
		
		return "recipeList";
		
	}
	
	@GetMapping("/alignRecipeLowPrice")
	public String recipeProductPageAlignAsc(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String headerCategory = "레시피";
		String alignCategory = "낮은 가격순";
		
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> recipeProducts = service.productView(request, curPage, headerCategory, alignCategory);
		service.cartCount(request, id);
		
		// for header 클릭 시 컬러 표시
		session.setAttribute("headerCategory", headerCategory);
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("alignCategory", alignCategory);
		model.addAttribute("headerCategory", headerCategory);
		model.addAttribute("recipeProducts", recipeProducts);
		
		return "recipeList";
	}
	
	@GetMapping("/alignRecipeHighPrice")
	public String recipeProductPageAlignDesc(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String headerCategory = "레시피";
		String alignCategory = "높은 가격순";
		
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<Product> recipeProducts = service.productView(request, curPage, headerCategory, alignCategory);
		service.cartCount(request, id);
		
		// for header 클릭 시 컬러 표시
		session.setAttribute("headerCategory", headerCategory);
		
		model.addAttribute("curPage", curPage);
		model.addAttribute("alignCategory", alignCategory);
		model.addAttribute("headerCategory", headerCategory);
		model.addAttribute("recipeProducts", recipeProducts);
		
		return "recipeList";
	}
	
	
	// paging with ResponseEntity and map
	@PostMapping("/paging")
	public ResponseEntity<Map<String, Object>> paging(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		// ajax datas from paging.js
		int curPage = Integer.parseInt(request.getParameter("curPage"));
		String align = request.getParameter("align");
		String category = request.getParameter("category");
		
		System.out.println("align :" + align);
		System.out.println("category :" + category);
		
		
		try {
			id = request.getParameter("id");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> datas = service.productPageCount(request, response, category, align, id, curPage);
		
		return ResponseEntity.ok().body(datas);
	}
	
	
	
	/************* TEST Start *************/
	// get in product detail for test
	// productDetailPage
	@GetMapping("/productDetail")
	public String pDeatilPage(HttpServletRequest request, Model model) {
		model.addAttribute("productId", request.getParameter("productId"));
		
		return "test";
	}
	
	// get in recipe detail for test
	// recipeDetailPage
	@GetMapping("/recipeDetail")
	public String rDeatilPage(HttpServletRequest request, Model model) {
		model.addAttribute("recipeId", request.getParameter("recipeId"));
		
		return "test";
	}
	/************* TEST End *************/
	
	
	/************* Order Start *************/
	@GetMapping("/order")
	public String order(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		// test 용
		id = "admin";
//		int deliveryFee = 0;
		
		List<Product> list = service.orderList(id, request);
		
		model.addAttribute("id", id);
		model.addAttribute("orderList", list);
		model.addAttribute("userInfo", service.userInfo(id));
		// if 구매한다면 정보를 받기 위해 session으로 보냄
		session.setAttribute("orderList", list);
		// 구매할 때 고객 정보와 sum result 값
		
		return "purchaseProduct";
	}
	/************* Order End *************/
	
	
	/************* Cart Start *************/
	@PostMapping("/getCart")
	public ResponseEntity<Integer> getCart(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		int productid = 0;
		int queryQty = 0;
		
		// ID 받기
		id = request.getParameter("id");
		// productid 받기
		productid = Integer.parseInt(request.getParameter("productid"));
		
		// recipe인지, product인지 확인하는 분류 받기
//		String headerCategory = request.getParameter("headerCategory");
		
		int cartCount = (int) session.getAttribute("cartCount");
		
		
		try {
			queryQty = service.searchCart(id, productid);
			System.out.println("forSearch : " + queryQty);
			// update
			if (queryQty > 0) {
				service.updateCart(id, productid, queryQty);
			}
		}
		catch (Exception e) {
			// insert
			service.getCart(id, productid);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(cartCount);
	}
	/************* Cart End *************/
	
	
	/************* popup *************/
	@GetMapping("/popup")
	public String popup(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String uname = request.getParameter("uname");
		String tel_no = request.getParameter("tel_no");
		
		session.setAttribute("uname", uname);
		session.setAttribute("tel_no", tel_no);
		
		
		return "popup";
	}
	
	@PostMapping("/sccessfulOrder")
	public String sccessfulOrder(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		// orderList from /order
		List<Product> orderList =  (List<Product>) session.getAttribute("orderList");
		// get payMethod from purchaseProduct.js
		int paymethod = Integer.parseInt(request.getParameter("payMethod"));
		int randomNumber = 0;
		// while문을 돌리기 위한 변수
		Boolean checkFlag = true;
		
		// random 번호 생성 for purchaseid
		while(checkFlag) {
			Random random = new Random();
			randomNumber = random.nextInt(900000);
			
			Integer[] checkPurchaseid = service.checkPurchaseid();
			
			// check purchaseid with randomnumber
			for (int i=0; i<checkPurchaseid.length; i++) {
				if (checkPurchaseid[i] == randomNumber) {
					continue;
				}
			}
			checkFlag = false;
		}
		
		// insert and delete same time 
		for (Product insert : orderList) {
			service.finalOrderBtn(insert.getQty(), id, insert.getCartid(), paymethod, randomNumber);
		}
		
		model.addAttribute("id", request.getParameter("id"));
		model.addAttribute("finalResult", request.getParameter("finalResult"));
		
		return "sccessfulOrder";
	}
	
	@GetMapping("/test")
	public String test(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		
		return "test";
	}
	/************* popup *************/
	
}
