package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.DetailDto;

public interface DetailDao {
	public List<DetailDto> list() throws Exception;
}
