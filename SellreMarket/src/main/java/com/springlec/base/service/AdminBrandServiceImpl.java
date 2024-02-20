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
	
	@Override
	public List<BrandDto> list() throws Exception {
		return dao.list();
	}

}
