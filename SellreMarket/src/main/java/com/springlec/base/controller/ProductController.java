package com.springlec.base.controller;

import java.util.List;
import java.util.Map;

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
	
	@GetMapping("/main")
	public String newProductPage(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		
		String adImage = service.newAdImg();
		String headerCategory = "신상품";
		String alignCategory = "신상품순";
		 
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			id = request.getParameter("id");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> newProducts = service.productView(request, id, curPage, headerCategory, alignCategory);
		
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
		
		try {
			id = request.getParameter("id");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> newProducts = service.productView(request, id, curPage, headerCategory, alignCategory);
		
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
		
		try {
			id = request.getParameter("id");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> newProducts = service.productView(request, id, curPage, headerCategory, alignCategory);
		
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
		
		
		try {
			id = request.getParameter("id");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> bestProducts = service.productView(request, id, curPage, headerCategory, alignCategory);
		
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
		
		try {
			id = request.getParameter("id");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> bestProducts = service.productView(request, id, curPage, headerCategory, alignCategory);
		
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
		
		try {
			id = request.getParameter("id");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> bestProducts = service.productView(request, id, curPage, headerCategory, alignCategory);
		
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
		
		try {
			id = request.getParameter("id");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> recipeProducts = service.productView(request, id, curPage, headerCategory, alignCategory);
		
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
		
		try {
			id = request.getParameter("id");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> recipeProducts = service.productView(request, id, curPage, headerCategory, alignCategory);
		
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
		
		
		try {
			id = request.getParameter("id");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> recipeProducts = service.productView(request, id, curPage, headerCategory, alignCategory);
		
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
		
		System.out.println("chceck inside Controller curPage :" + curPage);
		
		
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
	@GetMapping("/productDetailPage")
	public String pDeatilPage(HttpServletRequest request, Model model) {
		model.addAttribute("productId", request.getParameter("productId"));
		try { 
			model.addAttribute("recipeId", request.getParameter("recipeId"));
		}catch (Exception e) {
			model.addAttribute("recipeId", null);
			e.printStackTrace();
		}
		return "test";
	}
	
	// get in recipe detail for test
	@GetMapping("/recipeDetailPage")
	public String rDeatilPage(HttpServletRequest request, Model model) {
		model.addAttribute("recipeId", request.getParameter("recipeId"));
		try { 
			model.addAttribute("productId", request.getParameter("productId"));
		}catch (Exception e) {
			model.addAttribute("productId", null);
			e.printStackTrace();
		}
		return "test";
	}
	/************* TEST End *************/
	
	
	/************* Order Start *************/
	@GetMapping("/order")
	public String order(Model model) throws Exception {
		
		// test 용
		id = "admin";
				
		List<Product> list = service.purchaseList();
		Product userInfo = service.userInfo(id);
		
		model.addAttribute("orderList", list);
		model.addAttribute("userInfo", userInfo);
		
		return "purchaseProduct";
	}
	/************* Order End *************/
	
	
	/************* Cart Start *************/
	@PostMapping("/getCart")
	public ResponseEntity<Integer> getCart(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		
		// ID 받기
		id = request.getParameter("id");
		
		// productid 받기
		int productid = 0;
		
		try {
			productid = Integer.parseInt(request.getParameter("productid"));
		} catch (Exception e) {
			productid = Integer.parseInt(request.getParameter("recipeid"));
		}
		
		// recipe인지, product인지 확인하는 분류 받기
		String headerCategory = request.getParameter("headerCategory");
		
		int cartCount = (int) session.getAttribute("cartCount");
		
		// getCart insert문
		service.getCart(id, productid, headerCategory);
		
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
	
	
	/************* popup *************/
	
}
