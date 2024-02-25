package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.AdminQuestDto;

public interface AdminQuestService {

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
}
