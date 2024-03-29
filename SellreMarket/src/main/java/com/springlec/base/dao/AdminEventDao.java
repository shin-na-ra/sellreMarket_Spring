package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.AdminEventDto;
import com.springlec.base.model.AdminOrderDto;
import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.AdminQuestDto;

public interface AdminEventDao {

	//카테고리 조회하기 
	public List<AdminEventDto> list(int pageStart) throws Exception;
	
	//게시글 수
	public int boardCount() throws Exception;
	
	//페이징 처리
	public AdminPageDto pagingParam(int page) throws Exception;
	
	//등록
	public void insert(String image, String ename, String econtent, String startdate, String enddate, int salerate, int produdctid, int catetoryid) throws Exception;
	
	//상세조회
	public List<AdminEventDto> detail(int eventid) throws Exception;
	
	//수정
	public void update(int eventid, String ename, String econtent, String startdate, String enddate, int salerate, String image) throws Exception;
	
	//이미지 없이 수정
	public void updateNoImage (int eventid, String ename, String econtent, String startdate, String enddate, int salerate) throws Exception;
	
	//삭제
	public void delete(int eventid) throws Exception;
	
	//제품조회
	public List<AdminOrderDto> productSelect() throws Exception;
	
	//제품, 카테고리 select
	public int selectCategoryId(int productid) throws Exception;
	
	//제품명 검색
	public List<AdminEventDto> listQuery(String search, String query, int pageStart) throws Exception;
	
	//게시글 수 검색 
	public int searchCount(String search, String query) throws Exception;

	//페이징
	public AdminPageDto pagingParam2(int page, String search, String query) throws Exception;

	//제품 이미지 insert
	public void insertImage(int productid, String image) throws Exception;
	
	//제품 이미지 update
	public void updateImage(int productid, String image) throws Exception;
		
}
