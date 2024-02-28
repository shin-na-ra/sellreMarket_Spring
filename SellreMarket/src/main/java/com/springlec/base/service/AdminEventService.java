package com.springlec.base.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.AdminEventDto;
import com.springlec.base.model.AdminOrderDto;
import com.springlec.base.model.AdminPageDto;

public interface AdminEventService {

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

	//파일 등록
	public String uploadFile(MultipartFile file) throws Exception;
	
	//이미지 수정 없이 update
	public void updateNoImage (int eventid, String ename, String econtent, String startdate, String enddate, int salerate) throws Exception;
	
}
