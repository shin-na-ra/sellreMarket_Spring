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
	public List<DetailDto> productListDao(String string) throws Exception {
		// TODO Auto-generated method stub
		return dao.productListDao(string);
	}

	@Override
	public List<DetailDto> recipeListDao(String string) throws Exception {
		// TODO Auto-generated method stub
		return dao.recipeListDao(string);
	}

	@Override
	public void cartInputDao(String[] arrCartItemNames, String[] arrCartItemQuantities) {
		// TODO Auto-generated method stub
		for(int i=0; i<arrCartItemNames.length; i++) {
		dao.cartInputDao(arrCartItemNames[i], arrCartItemQuantities[i]);
		System.out.println(arrCartItemNames[i]);
		System.out.println(arrCartItemQuantities[i]);
		}
	}

}
