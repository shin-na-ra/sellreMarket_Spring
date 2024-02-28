package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.DetailDto;

public interface DetailService {
	public List<DetailDto> productListDao(String string) throws Exception;
	public List<DetailDto> recipeListDao(String string) throws Exception;
	public void cartInputDao(String[] arrCartItemNames, String[] arrCartItemQuantities, String userid);
	public void cartProductInputDao(String sendValue, String userId);
}
