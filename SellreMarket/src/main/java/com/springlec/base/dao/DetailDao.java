package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.DetailDto;

public interface DetailDao {
	public List<DetailDto> productListDao() throws Exception;
	public List<DetailDto> recipeListDao() throws Exception;
}
