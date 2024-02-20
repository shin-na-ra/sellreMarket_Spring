package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.AdminBrandDao;
import com.springlec.base.model.BrandDto;

@Service
public class AdminBrandServiceImpl implements AdminBrandService {

	@Autowired
	AdminBrandDao dao;
	
	//브랜드 개수 가져오기
	@Override
	public int brandCnt() throws Exception {
		return dao.brandCnt();
	}
	
	//브랜드 리스트 조회
	@Override
	public List<BrandDto> list(int indexNO) throws Exception {
		return dao.list(indexNO);
	}

	

	

}
