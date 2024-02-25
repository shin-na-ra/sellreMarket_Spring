package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.AdminEventDto;
import com.springlec.base.model.AdminPageDto;

public interface AdminEventService {

	//카테고리 조회하기 
	public List<AdminEventDto> list(int pageStart) throws Exception;
	
	//게시글 수
	public int boardCount() throws Exception;
	
	//페이징 처리
	public AdminPageDto pagingParam(int page) throws Exception;

	//등록
	public void insert(String image, String ename, String econtent, String startdate, String enddate, int salerate) throws Exception;
	
	//상세조회
	public List<AdminEventDto> detail(int eventid) throws Exception;
	
	//수정
	public void update(int eventid, String ename, String econtent, String startdate, String enddate, int salerate) throws Exception;
	
	//삭제
	public void delete(int eventid) throws Exception;
}
