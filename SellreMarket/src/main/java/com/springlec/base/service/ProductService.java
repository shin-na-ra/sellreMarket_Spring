package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Product;

public interface ProductService {
	// new Product info load
	public List<Product> newProductView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// new Product info align asc
	public List<Product> newProductAlignAscView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// new Product info align desc
	public List<Product> newProductAlignDescView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	public String getNewAdImg() throws Exception;
	
	// product page count 
	public int ProductPageCount(String headerCategory, String alignCategory) throws Exception;
//	// best product page count 
//	public int bestProductPageCount() throws Exception;
//	// recipe product page count 
//	public int recipeProductPageCount() throws Exception;
	
	public int cartCount(String id) throws Exception;
	
}
