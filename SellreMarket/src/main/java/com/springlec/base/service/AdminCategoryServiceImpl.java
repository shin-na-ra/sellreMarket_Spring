package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.AdminCategoryDao;
import com.springlec.base.model.Category;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService{

	@Autowired
	AdminCategoryDao dao;
	
	@Override
	public List<Category> list() throws Exception {
		return dao.list();
	}

}
