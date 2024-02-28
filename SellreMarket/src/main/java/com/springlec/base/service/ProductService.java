package com.springlec.base.service;

import java.util.List;
import java.util.Map;

import com.springlec.base.model.Product;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ProductService {
	// Product
	public List<Product> productView(HttpServletRequest request, int curPag, String headerCategory, String alignCategory) throws Exception;
	public String newAdImg() throws Exception;
	public List<Product> bestAdImgs() throws Exception;
	
	// product page count 
	public Map<String, Object> productPageCount(HttpServletRequest request, HttpServletResponse response, String headerCategory, String alignCategory, String id, int curPage) throws Exception;
	
	// Cart
	public void cartCount(HttpServletRequest request, String id) throws Exception;
	// Input
	public void getCart(String id, int productid) throws Exception;
	// Search
	public int searchCart(String id, int producitd) throws Exception;
	// Update
	public void updateCart(String id, int productid, int qty) throws Exception;
	
	// Order
	public List<Product> orderList(String id, HttpServletRequest request) throws Exception;
//	// 구매할 때 고객 정보
	public Product userInfo(String id) throws Exception;
	// 최종적으로 구매 버튼 클릭 시
	public void finalOrderBtn(int qty, String id, int cartid, int paymethod, String address, int purchaseid) throws Exception;
	// check Purchaseid
	public Integer[] checkPurchaseid() throws Exception;
	
}
