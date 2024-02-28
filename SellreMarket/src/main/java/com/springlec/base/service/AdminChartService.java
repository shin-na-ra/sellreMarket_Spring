package com.springlec.base.service;

import java.util.List;

import com.springlec.base.model.AdminChartDto;

public interface AdminChartService {

	public List<AdminChartDto> list() throws Exception;
	
	public List<AdminChartDto> popular() throws Exception;
	
	public List<AdminChartDto> gender() throws Exception;
	
	public List<AdminChartDto> user() throws Exception;
}
