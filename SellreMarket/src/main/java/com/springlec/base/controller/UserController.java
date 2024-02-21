package com.springlec.base.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.Inquiry;
import com.springlec.base.service.InquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	InquiryService inquiryS;
	
	// 로그인 Page
	@GetMapping("/login")
	public String loginPage() {
		
		return "Login";
	}
	
	// 문의사항 목록 Page
	@GetMapping("/inquiry")
	public String inquiryPage(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("id");
		List<Inquiry> inquiryList = inquiryS.inquiryList(userid);
		
		model.addAttribute("InquiryList",inquiryList);
		
		return "individualInquiry";
	}
	
	// 1:1 문의 Page
	@PostMapping("/inquirywrite")
	public String inquiryWrite(HttpServletRequest request) {
		
		return "inquirywrite";
	}
	
	// 문의사항 Insert Action
	@PostMapping("/inquiryInsert")
	public String inquiryInsertAction(HttpServletRequest request, @RequestParam (name = "image", required = false) MultipartFile file) throws Exception {
		HttpSession session = request.getSession(); 
		String inimage = null;
		
		if (file != null && !file.isEmpty()) {
			inimage = inquiryS.uploadFile(request, file);
		}
		
		String intitle = request.getParameter("intitle");
		String incontent = request.getParameter("incontent");
		String userid = (String)session.getAttribute("id");
		String questid = request.getParameter("questid");
		
		inquiryS.inquiryInsert(intitle, incontent, inimage, questid, userid);
		
		return "redirect:/inquiry";
	}
	
}
