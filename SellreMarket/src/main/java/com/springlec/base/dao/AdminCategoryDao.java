package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.Category;

public interface AdminCategoryDao {

	//카테고리 조회하기 
	public List<Category> list(int pageStart) throws Exception;
	
	//게시글 수
	public int boardCount() throws Exception;
	
	//페이징 처리
	public AdminPageDto pagingParam(int page) throws Exception;
	
	//등록
	public void insertCategory(String type, String subtype) throws Exception; 
	
	//상세조회
	public List<Category> detail(int catetoryid) throws Exception;
	
	//수정
	public void update(int catetoryid, String type, String subtype) throws Exception;
	
	//삭제
	public void delete(int catetoryid) throws Exception;
	
	//상태변경
	public void changeStatus(int catetoryid) throws Exception;

}
