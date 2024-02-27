package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.AdminChartDao;
import com.springlec.base.model.AdminChartDto;

@Service
public class AdminChartServiceImpl implements AdminChartService{

	@Autowired
	AdminChartDao dao;

	@Override
	public List<AdminChartDto> list() throws Exception {
		return dao.list();
	}

	@Override
	public List<AdminChartDto> popular() throws Exception {
		return dao.popular();
	}

	@Override
	public List<AdminChartDto> gender() throws Exception {
		return dao.gender();
	}

	@Override
	public List<AdminChartDto> user() throws Exception {
		return dao.user();
	}
	
	
}
