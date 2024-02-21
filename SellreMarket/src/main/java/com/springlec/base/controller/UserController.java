package com.springlec.base.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.Inquiry;
import com.springlec.base.model.Notice;
import com.springlec.base.service.InquiryService;
import com.springlec.base.service.NoticeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class UserController {
	
	@Autowired
	InquiryService inquiryS;
	
	@Autowired
	NoticeService noticeS;
	
	
	// 로그인 Page
	@GetMapping("/login")
	public String loginPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("id", "lcy0512");
		return "Login";
	}
	
	// 회원가입 Page
	@GetMapping("/signup")
	public String signupPage() {
		return "CustomerSignup";
	}
	
	// 문의사항 목록 Page
	@GetMapping("/inquiry")
	public String inquiryPage(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("id");
//		String userid = "lcy0512";
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
	
	// 문의사항 상세내역 확인 Page
	@PostMapping("/inquirydetail")
	public String inquiryDetailPage(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		
		String inquiryid = request.getParameter("inquiryid");
		String userid = (String)session.getAttribute("id");
//		String userid = "lcy0512";
		
		model.addAttribute("detailInquiry", inquiryS.inquiryDetail(userid, inquiryid));
		
		return "InquiryDetail";
	}
	
	// 내 정보 수정 재확인 Page
	@GetMapping("/mypageinfo")
	public String mypageinfoPage(HttpServletRequest request) {
		return "mypageinfo";
	}
	
	// 공지사항 Page
	@GetMapping("/notice")
	public String noticePage() {
		return "notice";
	}
	
	// 공지사항 목록 Page
	@PostMapping("/noticelist")
	public ResponseEntity<Map<String, Object>> noticelistPage(HttpServletRequest request) throws Exception {
		String keyword = request.getParameter("keyword");
		String curPage = request.getParameter("curPage");
		
		Map<String, Object> responseData = noticeS.noticeList(curPage, keyword);
		
		return ResponseEntity.ok().body(responseData);
	}
	
	@GetMapping("/logout")
	public String getMethodName(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		// 메인화면으로 수정해야함!
		return "redirect:/login";
	}
	

	
}
