package com.springlec.base.service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springlec.base.dao.ProductDao;
import com.springlec.base.model.Product;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao dao;
	
	@Autowired
	HashMap<String, Object> datas;
	
	// spring boot에서 json을 사용하기 위함 gson이 사용이 안되기 때문
	@Autowired
	ObjectMapper om;
	
	/*** New Page Start ***/
	// new page product load
	@Override
	public List<Product> productView(HttpServletRequest request, int curPage, String headerCategory, String alignCategory) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		// 한 페이지에 몇개를 보여줄 것인가?
		int countPerPage = 12;
		// 한 블럭에 몇개의 블럭을 보여줄 것인가?
		
		// db에 limit의 시작점
		// ex) (1-1) * 5 = 0, (2-1) * 12 = 12, 
		int limitFrom = (curPage - 1) * countPerPage;
		
		if (headerCategory.equals("신상품")) {
			if (alignCategory.equals("신상품순")) {
				session.setAttribute("newBestProduct", dao.newBestProduct(limitFrom, countPerPage));
				return dao.newProductView(limitFrom, countPerPage);
			}
			else if (alignCategory.equals("낮은 가격순")) {
				session.setAttribute("newBestProduct", dao.newBestProduct(limitFrom, countPerPage));
				return dao.newProductAlignAscView(limitFrom, countPerPage);
			}
			else if (alignCategory.equals("높은 가격순")) {
				session.setAttribute("newBestProduct", dao.newBestProduct(limitFrom, countPerPage));
				return dao.newProductAlignDescView(limitFrom, countPerPage);
			}
		}
		else if (headerCategory.equals("베스트")) {
			if (alignCategory.equals("베스트순")) {
				return dao.bestProductView(limitFrom, countPerPage);
			}
			else if (alignCategory.equals("낮은 가격순")) {
				return dao.bestProductAlignAscView(limitFrom, countPerPage);
			}
			else if (alignCategory.equals("높은 가격순")) {
				return dao.bestProductAlignDescView(limitFrom, countPerPage);
			}
		}
		else if (headerCategory.equals("레시피")) {
			if (alignCategory.equals("레시피")) {
				return dao.recipeProductView(limitFrom, countPerPage);
			}
			else if (alignCategory.equals("낮은 가격순")) {
				return dao.recipeProductAlignAscView(limitFrom, countPerPage);
				
			}
			else if (alignCategory.equals("높은 가격순")) {
				return dao.recipeProductAlignDescView(limitFrom, countPerPage);
			}
		}
		return null;
	}
	
	/*** Paging Start ***/
	@Override
	public HashMap<String, Object> productPageCount(HttpServletRequest request, HttpServletResponse response,
			String headerCategory, String alignCategory, String id, int curPage) throws Exception {
		HttpSession session = request.getSession();
		String href = null;
		int totalProductCount = 1;
//		int cartCount = 0;
		
		
		// 어딘가에서 id를 session으로 받아야한다. 그래야 로그인 했을 때만 카운트를 샌다.
		id = (String) session.getAttribute("id");
		
		// 장바구니 카운트 세기
//		if (id != null) {
//			cartCount = dao.cartCount(id);
//		}
		
		// href 변수를 간결하게 수정
	    if (headerCategory.equals("신상품")) {
	    	totalProductCount = dao.newProductPageCount();
	        
	        if (alignCategory.equals("신상품순")) {
	            href = "<a href='/main?curPage=";
	        }
	        else if (alignCategory.equals("낮은 가격순")) {
	            href = "<a href='/alignNewLowPrice?curPage=";
	        }
	        else if (alignCategory.equals("높은 가격순")) {
	        	href = "<a href='/alignNewHighPrice?curPage=";
	        }
	    }
	    
	    if (headerCategory.equals("베스트")) {
	    	totalProductCount = dao.bestProductPageCount();
	        
	        if (alignCategory.equals("베스트순")) {
	            href = "<a href='/bestProduct?curPage=";
	        }
	        else if (alignCategory.equals("낮은 가격순")) {
	            href = "<a href='/alignBestLowPrice?curPage=";
	        }
	        else if (alignCategory.equals("높은 가격순")) {
	            href = "<a href='/alignBestHighPrice?curPage=";
	        }
	    }
	    if (headerCategory.equals("레시피")) {
	    	totalProductCount = dao.recipeProductPageCount();
	    	
	    	if (alignCategory.equals("레시피")) {
	            href = "<a href='/recipeProduct?curPage=";
	        }
	    	else if (alignCategory.equals("낮은 가격순")) {
	            href = "<a href='/alignRecipeLowPrice?curPage=";
	        }
	    	else if (alignCategory.equals("높은 가격순")) {
	            href = "<a href='/alignRecipeHighPrice?curPage=";
	        }
	    }
	    
		// 한 페이지에 몇개를 보여줄 것인가?
		int countPerPage = 12;
		// 한 블럭에 몇개의 블럭을 보여줄 것인가?
		int countPerBlock = 5;
		
		// db에 limit의 시작점
		// ex) (1-1) * 5 = 0, (2-1) * 5 = 5, 
		int limitFrom = (curPage - 1) * countPerBlock;
		
		// 블록 페이지 1~5, 6~10
		// ex) 1~5까지 = 1, 6~10 = 2
		int blockPage = ((curPage-1) / countPerBlock) + 1;
		
		// bloackPage가 1이면 시작 페이지가 '1 2 3 4 5'  2이면 '6 7 8 9 10'
		int blockStart = (blockPage-1) * countPerBlock + 1;
		
		// 마지막 페이지 정하기
		int endPage = (totalProductCount % countPerPage) == 0 ? totalProductCount / countPerPage : ((totalProductCount / countPerPage) + 1);
		
//	    session.setAttribute("cartCount", cartCount);
		
		System.out.println("chceck inside implementation curPage :" + curPage);
		
		datas.put("curPage", curPage);
		datas.put("endPage", endPage);
		datas.put("blockStart", blockStart);
		datas.put("endBlock", limitFrom + 5);
		datas.put("href", href);
		
		return datas;
	}
	/*** Paging End ***/


	// cart count
	@Override
	public void cartCount(HttpServletRequest request, String id) throws Exception {
		HttpSession session = request.getSession();
		try { 
			if(!id.equals(null)) {
		
			dao.cartCount(id);
			session.setAttribute("cartCount", dao.cartCount(id));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Cart
	@Override
	public void getCart(String id, int productid) throws Exception {
		dao.getProductCart(id, productid);
		
	}
	
	@Override
	public void updateCart(String id, int productid, int qty) throws Exception {
		dao.updateProductCart(id, productid, qty);
	}
	
	@Override
	public int searchCart(String id, int producitd) throws Exception {
		// TODO Auto-generated method stub
		
		return dao.searchCart(id, producitd);
	}
	
	// Cart
	
	
	// Images
	// get new page image
	@Override
	public String newAdImg() throws Exception {
		// TODO Auto-generated method stub
		
		return dao.newAdImg();
	}

	// get best page images
	@Override
	public List<Product> bestAdImgs() throws Exception {
		// TODO Auto-generated method stub
		return dao.bestAdImgs();
	}
	// Images
	
	// order
	@Override
	public List<Product> orderList(String id, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		// for문을 돌리기 위한 카운트 : 선택한 cartid 만큼
		Integer[] checkOrderCount = dao.clickOrderBtn();
		List<Product> result = new ArrayList<>();
		
		// 합계를 구해서 jsp로 보내기 위한
		int discountSum = 0;
		int discount = 0;
		int sum = 0;
		// deliveryFee
		int deliveryFee = 0;
		int finalResult = 0;
		
		// List가 아닌 하나 씩 받아서 길이만큼 result에 값을 넣어준다.
		for (int i=0; i<checkOrderCount.length; i++) {
			result.add(dao.orderList(id, checkOrderCount[i]));
		}
		
		for (Product list : result) {
			discountSum += list.getPriceGetDiscount(); 
			discount = list.getDiscount(); 
			sum = list.getPriceNotDiscount(); 
		}
		
		// 처음에 deliveryFee가 포함 안된 가격 만약 30000원 이상이라면 딜리버리피 추가
		finalResult = discountSum;
		
		if (discountSum <= 30000) {
			deliveryFee = 3000;
			finalResult = discountSum + deliveryFee;
		}
		
		session.setAttribute("discountSum", String.format("%,d",discountSum));
		session.setAttribute("discount", String.format("%,d", discount));
		session.setAttribute("sum", String.format("%,d", sum));
		session.setAttribute("deliveryFee", String.format("%,d", deliveryFee));
		session.setAttribute("finalResult", String.format("%,d", finalResult));
		
		return result;
	}
	
//	// 구매할 때 고객 정보
	@Override
	public Product userInfo(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.userInfo(id);
	}
	// insert purchase and delete cart
	@Override
	public void finalOrderBtn(int qty, String id, int cartid, int paymethod, String address, int purchaseid) throws Exception {
		dao.finalOrderBtn(qty, id, cartid, paymethod, address, purchaseid);
		dao.updateCartStatus(cartid);
	}
	
	@Override
	public Integer[] checkPurchaseid() throws Exception {
		// TODO Auto-generated method stub
		return dao.checkPurchaseid();
	}
	// order

//	@Override
//	public String firstBestEventImage() throws Exception {
//		// TODO Auto-generated method stub
//		return dao.firstBestEventImage();
//	}

}
