package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springlec.base.model.Product;
import com.springlec.base.service.Paging;
import com.springlec.base.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/")
	public String newProductPage(HttpServletRequest request, Model model) throws Exception {
		int curPage = 0;
		String id = null;
		String adImage = service.getNewAdImg();
		 
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			curPage = 1;
			e.printStackTrace();
		}
		
		try {
			id = request.getParameter("id");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Product> newProducts = service.recipeProductView(0, 0, id, curPage);
		
		model.addAttribute("newProducts", newProducts);
		model.addAttribute("img", adImage);
		
		return "newProduct";
	}
	
}
