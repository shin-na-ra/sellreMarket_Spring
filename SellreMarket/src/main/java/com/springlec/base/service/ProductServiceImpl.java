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
	public List<Product> newProductView(int limitFrom, int countPerPage, String id, int curPage) throws Exception {
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
		
		return dao.newProductView(limitFrom, countPerPage, id, curPage);
	}
	
	// new page product load align asc
	@Override
	public List<Product> newProductAlignAscView(int limitFrom, int countPerPage, String id, int curPage) throws Exception {
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
		
		return dao.newProductAlignAscView(limitFrom, countPerPage, id, curPage);
	}

	// new page product load align desc
	@Override
	public List<Product> newProductAlignDescView(int limitFrom, int countPerPage, String id, int curPage) throws Exception {
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
		
		return dao.newProductAlignDescView(limitFrom, countPerPage, id, curPage);
	}
	수정해야수정해야수정해야
	// 조건에 맞게 페이지 조건을 통해 비교 후 count
	@Override
	public int ProductPageCount(String headerCategory, String alignCategory) throws Exception {
		if (headerCategory.equals("신상품")) {
			return dao.newProductPageCount();
		}
		return 0;
	}
	수정해야수정해야수정해야
	

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
