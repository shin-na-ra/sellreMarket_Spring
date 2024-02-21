package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.Product;

public interface ProductService {
	public List<Product> recipeProductView(int limitFrom, int countPerPage, String id, int curPage) throws Exception;
	public int cartCount(String id) throws Exception;
	public String getNewAdImg() throws Exception;
}
