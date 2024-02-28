package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.AdminProductDto;
import com.springlec.base.model.AdminQuestDto;

public interface AdminQuestDao {

	//게시글 리스트 조회
	public List<AdminQuestDto> questList(int pageStart) throws Exception;
	
	//게시글 수
	public int listCount() throws Exception;
	
	//페이징 처리
	public AdminPageDto pagingParam(int page) throws Exception;
	
	//게시글 상세조회
	public List<AdminQuestDto> detail(int inquiryid) throws Exception;
	
	//게시글 답변 등록
	public int updateAnswer(String answer, int inquiryid) throws Exception; 

	//제품명 검색
	public List<AdminQuestDto> listQuery(String search, String query, int pageStart) throws Exception;
	
	//게시글 수 검색 
	public int searchCount(String search, String query) throws Exception;

	//페이징
	public AdminPageDto pagingParam2(int page, String search, String query) throws Exception;
}
