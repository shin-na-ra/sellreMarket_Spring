package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.DetailDto;

public interface DetailDao {
	public List<DetailDto> productListDao(String string) throws Exception;
	public List<DetailDto> recipeListDao(String string) throws Exception;
	public void cartInputDao(String cartItemNames, String cartItemQuantities);
}
