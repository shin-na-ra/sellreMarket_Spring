package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.AdminChartDto;

public interface AdminChartDao {
	
	public List<AdminChartDto> list() throws Exception;
	
	public List<AdminChartDto> popular() throws Exception;
	
	public List<AdminChartDto> gender() throws Exception;
	
	public List<AdminChartDto> user() throws Exception;
}
