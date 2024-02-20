package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.BrandDto;

public interface AdminBrandDao {

	public List<BrandDto> list() throws Exception;
}
