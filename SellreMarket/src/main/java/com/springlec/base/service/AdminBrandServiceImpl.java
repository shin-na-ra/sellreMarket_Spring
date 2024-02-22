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
	public List<BrandDto> list() throws Exception {
		return dao.list();
	}

	//브랜드 상세 조회하기
	@Override
	public List<BrandDto> detail(String bname) throws Exception {
		return dao.detail(bname);
	}

	//브랜드 수정하기
	@Override
	public void update(String bname, String oldBname) throws Exception {
		dao.update(bname, oldBname);
	}

	//브랜드 삭제하기
	@Override
	public void delete(String bname) throws Exception {
		dao.delete(bname);
	}
	
	//브랜드 상태 되돌리기
	@Override
	public void updateStatus(String bname) throws Exception {
		dao.updateStatus(bname);
	}

	//브랜드 등록하기
	@Override
	public void insert(String bname) throws Exception {
		dao.insert(bname);
	}

	

	

}
