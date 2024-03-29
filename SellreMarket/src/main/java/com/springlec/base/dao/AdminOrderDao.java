package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.AdminOrderDto;
import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.AdminProductDto;

public interface AdminOrderDao {

	//게시글 리스트 조회
	public List<AdminOrderDto> questList(int pageStart) throws Exception;
	
	//게시글 수
	public int listCount() throws Exception;
	
	//페이징 처리
	public AdminPageDto pagingParam(int page) throws Exception;
	
	//게시글 상세조회
	List<AdminOrderDto> detail(int productid) throws Exception;
	
	//입고 요청하기
	public int insertOrder(int rcount, String rcomment, int productid) throws Exception; 
	
	//제품 개수도 update
	public void insertProduct(int rcount, int productid) throws Exception;
	
	//제품명 검색
	public List<AdminOrderDto> listQuery(String search, int pageStart) throws Exception;
	
	//게시글 수 검색 
	public int searchCount(String search) throws Exception;

	//페이징
	public AdminPageDto pagingParam2(int page, String search) throws Exception;

	
}
