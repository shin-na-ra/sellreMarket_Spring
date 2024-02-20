package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.BrandDto;

public interface AdminBrandDao {

	//브랜드 리스트 개수 가져오기
	public int brandCnt() throws Exception; 
	
	//브랜드 리스트 조회하기
	public List<BrandDto> list(int indexNo) throws Exception;
}
