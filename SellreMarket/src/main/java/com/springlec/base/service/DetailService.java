package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.DetailDto;

public interface DetailService {
	
	public List<DetailDto> productListDao() throws Exception;
	public List<DetailDto> recipeListDao() throws Exception;

}
