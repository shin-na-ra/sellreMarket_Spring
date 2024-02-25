package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.AdminOrderDto;
import com.springlec.base.model.AdminPageDto;

public interface AdminOrderService {

	//게시글 리스트 조회
	public List<AdminOrderDto> questList(int pageStart) throws Exception;
	
	//게시글 수
	public int listCount() throws Exception;
	
	//페이징 처리
	public AdminPageDto pagingParam(int page) throws Exception;
	
	//게시글 상세조회
	public List<AdminOrderDto> detail(int inquiryid) throws Exception;

	//입고 요청하기
	public void insertOrder(int rcount, String rcomment, int productid) throws Exception;
	
}
