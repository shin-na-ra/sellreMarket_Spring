package com.springlec.base.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.springlec.base.model.BrandDto;
import com.springlec.base.service.AdminBrandService;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

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
	@ResponseBody
	public String adminBrand(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		int currentPage = 0;
		if(request.getParameter("pageNum") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		int total = adminBrandService.brandCnt();
		int index_no = (currentPage - 1) * 15;
		int lastPage = (int) (Math.ceil((double)total/15));
		
		List<BrandDto> list = adminBrandService.list(index_no);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("total", total);
		map.put("index_no", index_no);
		map.put("lastPage", lastPage);
		map.put("brandList", list);
		
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("data", map);
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print(jsonObject.toString());
		
		
		return "adminBrand";
	}
	
	
	

	
	
}
