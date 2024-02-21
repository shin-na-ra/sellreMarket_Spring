package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Product;


public interface ProductDao {
	// new Product info load
	public List<Product> recipeProductView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	// sum cart Count 
	public int cartCount(String id) throws Exception;
	// new ad Img 
	public String getNewAdImg() throws Exception;

}
