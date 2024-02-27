package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.AdminProductDto;
import com.springlec.base.model.BrandDto;

public interface AdminBrandDao {

	//브랜드 상세 조회하기
	public List<BrandDto> detail(String bname) throws Exception;
	
	//브랜드 수정하기
	public void update(String bname, String oldBname) throws Exception; 

	//브랜드 삭제하기
	public void delete(String bname) throws Exception;
	
	//브랜드 등록하기
	public void insert(String bname) throws Exception;
	
	//브랜드 상태 되돌리기
	public void updateStatus(String bname) throws Exception;

	//게시글 리스트 조회
	public List<BrandDto> pageList(int pageStart) throws Exception;
	
	//게시글 수
	public int boardCount() throws Exception;
	
	//페이징 처리
	public AdminPageDto pagingParam(int page) throws Exception;
	
	//등록, 수정 시 브랜드 중복 체크
	public int checkBrand(String bname) throws Exception;
	
	//제품명 검색
	public List<BrandDto> listQuery(String search, int pageStart) throws Exception;
	
	//게시글 수 검색 
	public int searchCount(String search) throws Exception;

	//페이징
	public AdminPageDto pagingParam2(int page, String search) throws Exception;
	
}
