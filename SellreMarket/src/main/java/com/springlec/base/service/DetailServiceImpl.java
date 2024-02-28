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
	public void cartInputDao(String[] cartItemNames, String[] cartItemQuantities, String userId) {
		// TODO Auto-generated method stub
		for(int i=0; i<cartItemNames.length; i++) {
			System.out.println("길이가 얼마나 되냐? : " + cartItemNames.length);
			System.out.println("name : " + cartItemNames[i]);
			System.out.println("qty : " + cartItemQuantities[i]);
			System.out.println("userid : " + userId);
			dao.cartInputDao(cartItemNames[i], cartItemQuantities[i], userId);
		}
	}

	@Override
	public void cartProductInputDao(String sendValue, String userId) {
		// TODO Auto-generated method stub
		dao.cartProductInputDao(sendValue, userId);
	}
}
