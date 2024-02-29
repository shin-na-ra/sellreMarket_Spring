package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Product;

public interface ProductDao {
	
	// New Product
	// main new Product info 
	public List<Product> newProductView(int limitFrom, int countPerPage) throws Exception;
	// new Product info align asccartCount
	public List<Product> newProductAlignAscView(int limitFrom, int countPerPage) throws Exception;
	// new Product info align desc
	public List<Product> newProductAlignDescView(int limitFrom, int countPerPage) throws Exception;
	// Order by best Product of new Product DESC
	public List<Product> newBestProduct(int limitFrom, int countPerPage) throws Exception;
	// new ad Img 
	public String newAdImg() throws Exception;
	
	// Best Product
	// main Best Product info 
	public List<Product> bestProductView(int limitFrom, int countPerPage) throws Exception;
	// Best Product info align asc
	public List<Product> bestProductAlignAscView(int limitFrom, int countPerPage) throws Exception;
	// Best Product info align desc
	public List<Product> bestProductAlignDescView(int limitFrom, int countPerPage) throws Exception;
	public List<Product> bestAdImgs() throws Exception;
	// first image from best event
//	public String firstBestEventImage() throws Exception;
	
	// Recipe Product
	// main Recipe Product info 
	public List<Product> recipeProductView(int limitFrom, int countPerPage) throws Exception;
	// Recipe Product info align asc
	public List<Product> recipeProductAlignAscView(int limitFrom, int countPerPage) throws Exception;
	// Recipe Product info align desc
	public List<Product> recipeProductAlignDescView(int limitFrom, int countPerPage) throws Exception;
	
	
	
	// Paging
	// new product page count  
	public int newProductPageCount() throws Exception;
	// best product page count 
	public int bestProductPageCount() throws Exception;
	// recipe product page count 
	public int recipeProductPageCount() throws Exception;

	
	// Cart
	// sum cart Count 
	public int cartCount(String id) throws Exception;
	// input cart
	public void getProductCart(String id, int productid) throws Exception;
	// search cart
	public int searchCart(String id, int productid) throws Exception;
	// update cart
	public void updateProductCart(String id, int productid, int qty) throws Exception;
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//  카트에서 버튼 클릭할 때 가져와야 할 cart ids
	// click order button for test
	public Integer[] clickOrderBtn() throws Exception;
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	
	// Order
	public Product orderList(String id, int cartid) throws Exception;
	public Product userInfo(String id) throws Exception;
	public void finalOrderBtn(int qty, String id, int cartid, int paymethod, String address, int purchaseid) throws Exception;
	public void updateCartStatus(int cartid) throws Exception;
//	public void deleteCart(int cartid) throws Exception;
	// check Purchaseid
	public Integer[] checkPurchaseid() throws Exception;
	
//	public List<Product> 
}
