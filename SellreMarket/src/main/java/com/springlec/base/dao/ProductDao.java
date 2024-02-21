package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Product;


public interface ProductDao {
	
	// new Product
	// new Product info load
	public List<Product> newProductView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// new Product info align asc
	public List<Product> newProductAlignAscView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// new Product info align desc
	public List<Product> newProductAlignDescView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// new ad Img 
	public String getNewAdImg() throws Exception;
	
	수정해야수정해야수정해야수정해야수정해야수정해야수정해야수정해야수정해야
	// Paging
	// product page count 
	public int ProductPageCount(String headerCategory, String alignCategory) throws Exception;
	// new product page count  
	public int newProductPageCount() throws Exception;
	// best product page count 
	public int bestProductPageCount() throws Exception;
	// recipe product page count 
	public int recipeProductPageCount() throws Exception;
	
	// best Product info load
	public List<Product> bestProductView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;

	// Cart
	// sum cart Count 
	public int cartCount(String id) throws Exception;
}
