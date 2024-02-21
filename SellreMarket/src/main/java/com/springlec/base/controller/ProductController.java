package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springlec.base.model.Product;
import com.springlec.base.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/")
	public String newProductPage(HttpServletRequest request, Model model) throws Exception {
		int curPage = 1;
		String id = null;
		String adImage = service.getNewAdImg();
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
		
		List<Product> newProducts = service.newProductView(0, 0, id, curPage);
		
		// alignCategory를 넣어 주어서 어떤 것인지 비교
		service.ProductPageCount("신상품", alignCategory);
		
		model.addAttribute("alignCategory", alignCategory);
		model.addAttribute("newProducts", newProducts);
		model.addAttribute("img", adImage);
		
		return "newProduct";
	}
	
	@GetMapping("alignNewLowPrice")
	public String newProductPageAlignAsc(HttpServletRequest request, Model model) throws Exception {
		int curPage = 1;
		String id = null;
		String adImage = service.getNewAdImg();
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
		
		List<Product> newProducts = service.newProductView(0, 0, id, curPage);
		
		// alignCategory를 넣어 주어서 어떤 것인지 비교
		service.ProductPageCount("신상품", alignCategory);
				
		model.addAttribute("alignCategory", alignCategory);
		model.addAttribute("newProducts", newProducts);
		model.addAttribute("img", adImage);
		
		return "newProduct";
	}
	
	@GetMapping("alignHighLowPrice")
	public String newProductPageAlignDesc(HttpServletRequest request, Model model) throws Exception {
		int curPage = 1;
		String id = null;
		String adImage = service.getNewAdImg();
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
		
		List<Product> newProducts = service.newProductView(0, 0, id, curPage);
		
		// alignCategory를 넣어 주어서 어떤 것인지 비교
		service.ProductPageCount("신상품", alignCategory);
		
		model.addAttribute("alignCategory", alignCategory);
		model.addAttribute("newProducts", newProducts);
		model.addAttribute("img", adImage);
		
		return "newProduct";
	}
	
}
