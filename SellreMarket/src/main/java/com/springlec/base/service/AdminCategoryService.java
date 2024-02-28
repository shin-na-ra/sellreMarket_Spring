package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.AdminOrderDto;
import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.Category;

public interface AdminCategoryService {

	//카테고리 조회하기 
	public List<Category> list(int pageStart) throws Exception;
	
	//게시글 수
	public int boardCount() throws Exception;
	
	//페이징 처리
	public AdminPageDto pagingParam(int page) throws Exception;

	//등록
	public void insertCategory(String type, String subtype) throws Exception; 
	
	//상세조회
	public List<Category> detail(String type, String subtype) throws Exception;
	
	//수정
	public void update(String type, String subtype, String oldtype, String oldsubtype) throws Exception;
	
	//삭제
	public void delete(String type, String subtype) throws Exception;
	
	//상태변경
	public void changeStatus(String type, String subtype) throws Exception;
	
	//제품명 검색
	public List<Category> listQuery(String search, String query, int pageStart) throws Exception;
	
	//게시글 수 검색 
	public int searchCount(String search, String query) throws Exception;
	
	public AdminPageDto pagingParam2(int page, String search, String query) throws Exception;

}
