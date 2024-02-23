package com.springlec.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PurchaseListController {
	
	//구매목록 페에이지
	@GetMapping("/purchaseListPage")
	public String purchaseListPage() {
		return "purchase/purchaseListPage";
	}
}
