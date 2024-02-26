package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Product;

public interface ProductDao {
	
	// New Product
	// main new Product info 
	public List<Product> newProductView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// new Product info align asc
	public List<Product> newProductAlignAscView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// new Product info align desc
	public List<Product> newProductAlignDescView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// new ad Img 
	public String newAdImg() throws Exception;
	
	// Best Product
	// main Best Product info 
	public List<Product> bestProductView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// Best Product info align asc
	public List<Product> bestProductAlignAscView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// Best Product info align desc
	public List<Product> bestProductAlignDescView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	public List<Product> bestAdImgs() throws Exception;
	
	// Recipe Product
	// main Recipe Product info 
	public List<Product> recipeProductView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// Recipe Product info align asc
	public List<Product> recipeProductAlignAscView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// Recipe Product info align desc
	public List<Product> recipeProductAlignDescView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	
	
	
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
	public void getRecipeCart(String id, int recipeid) throws Exception;
	
	// Order
	public List<Product> purchaseList(String id) throws Exception;
	public Product purchaseInfo(String id) throws Exception;
}
