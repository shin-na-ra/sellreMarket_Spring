package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.BrandDto;

public interface AdminBrandDao {

	//브랜드 리스트 개수 가져오기
	public int brandCnt() throws Exception; 
	
	//브랜드 리스트 조회하기
	public List<BrandDto> list() throws Exception;
	
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
	
}
