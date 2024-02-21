package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.DetailDao;
import com.springlec.base.model.DetailDto;

@Service
public class DetailServiceImpl implements DetailService {

	@Autowired
	DetailDao dao;
	
	@Override
	public List<DetailDto> productListDao() throws Exception {
		// TODO Auto-generated method stub
		return dao.productListDao();
	}

	@Override
	public List<DetailDto> recipeListDao() throws Exception {
		// TODO Auto-generated method stub
		return dao.recipeListDao();
	}

}
