package com.springlec.base.service;

import java.io.PrintWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Product> productView(HttpServletRequest request, String id, int curPage, String headerCategory, String alignCategory) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		int cartCount = 0;
		
		// 장바구니 카운트 세기
		if (id != null) {
			cartCount = dao.cartCount(id);
		}
		
		session.setAttribute("cartCount", cartCount);
		// 한 페이지에 몇개를 보여줄 것인가?
		int countPerPage = 12;
		// 한 블럭에 몇개의 블럭을 보여줄 것인가?
		int countPerBlock = 5;
		
		// db에 limit의 시작점
		// ex) (1-1) * 5 = 0, (2-1) * 5 = 5, 
		int limitFrom = (curPage - 1) * countPerBlock;
		
		if (headerCategory.equals("신상품")) {
			if (alignCategory.equals("신상품순")) {
				return dao.newProductView(limitFrom, countPerPage, id, curPage);
			}
			else if (alignCategory.equals("낮은 가격순")) {
				return dao.newProductAlignAscView(limitFrom, countPerPage, id, curPage);
			}
			else if (alignCategory.equals("높은 가격순")) {
				return dao.newProductAlignDescView(limitFrom, countPerPage, id, curPage);
			}
		}
		else if (headerCategory.equals("베스트")) {
			if (alignCategory.equals("베스트순")) {
				return dao.bestProductView(limitFrom, countPerPage, id, curPage);
			}
			else if (alignCategory.equals("낮은 가격순")) {
				return dao.bestProductAlignAscView(limitFrom, countPerPage, id, curPage);
			}
			else if (alignCategory.equals("높은 가격순")) {
				return dao.bestProductAlignDescView(limitFrom, countPerPage, id, curPage);
			}
		}
		else if (headerCategory.equals("레시피")) {
			if (alignCategory.equals("레시피")) {
				return dao.recipeProductView(limitFrom, countPerPage, id, curPage);
			}
			else if (alignCategory.equals("낮은 가격순")) {
				return dao.recipeProductAlignAscView(limitFrom, countPerPage, id, curPage);
			}
			else if (alignCategory.equals("높은 가격순")) {
				return dao.recipeProductAlignDescView(limitFrom, countPerPage, id, curPage);
			}
		}
		
		return null;
		
	}
	
//	// new page product load align asc
//	@Override
//	public List<Product> newProductAlignAscView(int limitFrom, int countPerPage, String id, int curPage) throws Exception {
//		// TODO Auto-generated method stub
//		
//		int cartCount = 0;
//		
//		// 장바구니 카운트 세기
//		if (id != null) {
//			cartCount = dao.cartCount(id);
//		}
//		
//		// 한 페이지에 몇개를 보여줄 것인가?
//		countPerPage = 12;
//		// 한 블럭에 몇개의 블럭을 보여줄 것인가?
//		int countPerBlock = 5;
//		
//		// db에 limit의 시작점
//		// ex) (1-1) * 5 = 0, (2-1) * 5 = 5, 
//		limitFrom = (curPage - 1) * countPerBlock;
//		
//		return dao.newProductAlignAscView(limitFrom, countPerPage, id, curPage);
//	}
//
//	// new page product load align desc
//	@Override
//	public List<Product> newProductAlignDescView(int limitFrom, int countPerPage, String id, int curPage) throws Exception {
//		// TODO Auto-generated method stub
//		
//		int cartCount = 0;
//		
//		// 장바구니 카운트 세기
//		if (id != null) {
//			cartCount = dao.cartCount(id);
//		}
//		
//		// 한 페이지에 몇개를 보여줄 것인가?
//		countPerPage = 12;
//		// 한 블럭에 몇개의 블럭을 보여줄 것인가?
//		int countPerBlock = 5;
//		
//		// db에 limit의 시작점
//		// ex) (1-1) * 5 = 0, (2-1) * 5 = 5, 
//		limitFrom = (curPage - 1) * countPerBlock;
//		
//		return dao.newProductAlignDescView(limitFrom, countPerPage, id, curPage);
//	}
	
	
	/*** New Page End ***/
	
	
	
	/*** Best Page Start ***/
//	@Override
//	public List<Product> bestProductView(HttpServletRequest request, int limitFrom, int countPerPage, String id, int curPage, String alignCategory) throws Exception {
//		// TODO Auto-generated method stub
//		
//		HttpSession session = request.getSession();
//		
//		int cartCount = 0;
//		
//		// 장바구니 카운트 세기
//		if (id != null) {
//			cartCount = dao.cartCount(id);
//		}
//		
//		session.setAttribute("cartCount", cartCount);
//		// 한 페이지에 몇개를 보여줄 것인가?
//		countPerPage = 12;
//		// 한 블럭에 몇개의 블럭을 보여줄 것인가?
//		int countPerBlock = 5;
//		
//		// db에 limit의 시작점
//		// ex) (1-1) * 5 = 0, (2-1) * 5 = 5, 
//		limitFrom = (curPage - 1) * countPerBlock;
//		if (alignCategory.equals("베스트순")) {
//			return dao.bestProductView(limitFrom, countPerPage, id, curPage);
//		}
//		else if (alignCategory.equals("낮은 가격순")) {
//			return dao.bestProductAlignAscView(limitFrom, countPerPage, id, curPage);
//		}
//		else if (alignCategory.equals("높은 가격순")) {
//			return dao.bestProductAlignDescView(limitFrom, countPerPage, id, curPage);
//		}
//		else return null;
//	}

//	@Override
//	public List<Product> bestProductAlignAscView(int limitFrom, int countPerPage, String id, int curPage)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Product> bestProductAlignDescView(int limitFrom, int countPerPage, String id, int curPage)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
	/*** Best Page End ***/
	
	
	
	/*** Recipe Page Start ***/
//	@Override
//	public List<Product> recipeProductView(HttpServletRequest request, int limitFrom, int countPerPage, String id, int curPage, String alignCategory) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<Product> recipeProductAlignAscView(int limitFrom, int countPerPage, String id, int curPage)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Product> recipeProductAlignDescView(int limitFrom, int countPerPage, String id, int curPage)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
	/*** Recipe Page End ***/
	
	
	/*** Paging Start ***/
	@Override
	public HashMap<String, Object> productPageCount(HttpServletRequest request, HttpServletResponse response,
			String headerCategory, String alignCategory, String id, int curPage) throws Exception {
		HttpSession session = request.getSession();
		String href = null;
		int totalProductCount = 1;
		int cartCount = 0;
		
		
		// 어딘가에서 id를 session으로 받아야한다. 그래야 로그인 했을 때만 카운트를 샌다.
		id = (String) session.getAttribute("id");
		
		// 장바구니 카운트 세기
		if (id != null) {
			cartCount = dao.cartCount(id);
		}
		
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
		
	    session.setAttribute("cartCount", cartCount);
		
		System.out.println("chceck inside implementation curPage :" + curPage);
		
		datas.put("curPage", curPage);
		datas.put("endPage", endPage);
		datas.put("blockStart", blockStart);
		datas.put("endBlock", limitFrom + 5);
		datas.put("href", href);
		
		return datas;
	}
	
	
	// 조건에 맞게 페이지 조건을 통해 비교 후 count
//	@Override
//	public void productPageCount(HttpServletRequest request, HttpServletResponse response, String headerCategory,
//			String alignCategory, String id, int curPage) throws Exception {
//		
//		System.out.println("**********inside implementation service paging**********");
////		Map<String, Object> datas = new HashMap<>();
//		HttpSession session = request.getSession();
//		String href = null;
//		int totalProductCount = 1;
//		int cartCount = 0;
//		
//		
//		// 어딘가에서 id를 session으로 받아야한다. 그래야 로그인 했을 때만 카운트를 샌다.
//		id = (String) session.getAttribute("id");
//		
//		// 장바구니 카운트 세기
//		if (id != null) {
//			cartCount = dao.cartCount(id);
//		}
//		
//		// href 변수를 간결하게 수정
//	    if (headerCategory.equals("신상품")) {
//	    	totalProductCount = dao.newProductPageCount();
//	        
//	        if (alignCategory.equals("신상품순")) {
//	            href = "/main?curPage=";
//	            session.setAttribute("returnPage", "newProduct");
//	        }
//	        else if (alignCategory.equals("낮은 가격순")) {
//	            href = "/alignNewHighPrice?curPage=";
//	            session.setAttribute("returnPage", "newProduct");
//	        }
//	        else if (alignCategory.equals("높은 가격순")) {
//	        	href = "/alignNewHighPrice?curPage=";
//	        	session.setAttribute("returnPage", "newProduct");
//	        }
//	    }
//	    
//	    else if (headerCategory.equals("베스트")) {
//	    	totalProductCount = dao.bestProductPageCount();
//	        
//	        if (alignCategory.equals("베스트순")) {
//	            href = "/bestProduct?curPage=";
//	            session.setAttribute("returnPage", "bestProduct");
//	        }
//	        else if (alignCategory.equals("낮은 가격순")) {
//	            href = "/alignBestLowPrice?curPage=";
//	            session.setAttribute("returnPage", "bestProduct");
//	        }
//	        else if (alignCategory.equals("높은 가격순")) {
//	            href = "/alignBestHighPrice?curPage=";
//	            session.setAttribute("returnPage", "bestProduct");
//	        }
//	    }
//	    else if (headerCategory.equals("레시피")) {
//	    	totalProductCount = dao.recipeProductPageCount();
//	    	if (alignCategory.equals("레시피")) {
//	            href = "/recipePage?curPage=";
//	            session.setAttribute("returnPage", "recipeList");
//	        }
//	    	else if (alignCategory.equals("낮은 가격순")) {
//	            href = "/alignRecipeLowPrice?curPage=";
//	            session.setAttribute("returnPage", "recipeList");
//	        } else if (alignCategory.equals("높은 가격순")) {
//	            href = "/alignRecipeHighPrice?curPage=";
//	            session.setAttribute("returnPage", "recipeList");
//	        }
//	    }
//		
//		// 한 페이지에 몇개를 보여줄 것인가?
//		int countPerPage = 12;
//		// 한 블럭에 몇개의 블럭을 보여줄 것인가?
//		int countPerBlock = 5;
//		
//		// db에 limit의 시작점
//		// ex) (1-1) * 5 = 0, (2-1) * 5 = 5, 
//		int limitFrom = (curPage - 1) * countPerBlock;
//		
//		// 블록 페이지 1~5, 6~10
//		// ex) 1~5까지 = 1, 6~10 = 2
//		int blockPage = ((curPage-1) / countPerBlock) + 1;
//		
//		// bloackPage가 1이면 시작 페이지가 '1 2 3 4 5'  2이면 '6 7 8 9 10'
//		int blockStart = (blockPage-1) * countPerBlock + 1;
//		
//		// 마지막 페이지 정하기
//		int endPage = (totalProductCount % countPerPage) == 0 ? totalProductCount / countPerPage : ((totalProductCount / countPerPage) + 1);
//		
//	    System.out.println(cartCount + " : cartCount");
//	    System.out.println(href + " : href");
//	    System.out.println(curPage + " : curPage");
//	    System.out.println(blockStart + " : blockStart");
//		
//	    session.setAttribute("cartCount", cartCount);
//		session.setAttribute("curPage", curPage);
//		
//		datas.put("curPage", curPage);
//		datas.put("endPage", endPage);
//		datas.put("blockStart", blockStart);
//		datas.put("endBlock", limitFrom + 5);
//		datas.put("href", href);
//		
//		try {
//			// ObjectMapper를 사용하여 JSON 문자열로 반환
//			String jsonData = om.writeValueAsString(datas);
//			
//			response.setContentType("application/json");
//			response.setCharacterEncoding("utf-8");
//			PrintWriter out = response.getWriter();
//			out.print(jsonData);
//			out.flush();
//			System.out.println("right???????");
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			
//			System.out.println("errorrrr");
//		}
//	}
	/*** Paging End ***/


	// cart count
	@Override
	public int cartCount(String id) throws Exception {
		return dao.cartCount(id);
	}
	
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

	@Override
	public void getCart(String id, int productid, String headerCategory) throws Exception {
		if (headerCategory.equals("레시피")) {
			dao.getRecipeCart(id, productid);
		}
		else dao.getProductCart(id, productid);
		
	}

	
	// Purchase
	@Override
	public List<Product> purchaseList() throws Exception {
		return dao.purchaseList();
	}

	
	@Override
	public Product userInfo(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.userInfo(id);
	}
	// Purchase

}
