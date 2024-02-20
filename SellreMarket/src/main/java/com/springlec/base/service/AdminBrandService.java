package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.BrandDto;

public interface AdminBrandService {

	//브랜드 리스트 개수 가져오기
	public int brandCnt() throws Exception; 
	
	//브랜드 리스트 조회
	public List<BrandDto> list(int indexNO) throws Exception;
}
