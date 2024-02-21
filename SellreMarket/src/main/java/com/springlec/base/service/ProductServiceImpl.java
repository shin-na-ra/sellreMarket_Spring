package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.ProductDao;
import com.springlec.base.model.Product;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao dao;
	
	// new page product load
	@Override
	public List<Product> recipeProductView(int limitFrom, int countPerPage, String id, int curPage) throws Exception {
		// TODO Auto-generated method stub
		
		int cartCount = 0;
		
		// 장바구니 카운트 세기
		if (id != null) {
			cartCount = dao.cartCount(id);
		}
		
		// 한 페이지에 몇개를 보여줄 것인가?
		countPerPage = 12;
		// 한 블럭에 몇개의 블럭을 보여줄 것인가?
		int countPerBlock = 5;
		
		// db에 limit의 시작점
		// ex) (1-1) * 5 = 0, (2-1) * 5 = 5, 
		limitFrom = (curPage - 1) * countPerBlock;
		
		
		return dao.recipeProductView(limitFrom, countPerPage, id, curPage);
	}

	// cart count
	@Override
	public int cartCount(String id) throws Exception {
		return dao.cartCount(id);
	}

	// get new page image
	@Override
	public String getNewAdImg() throws Exception {
		// TODO Auto-generated method stub
		
		return dao.getNewAdImg();
		
	}


}
