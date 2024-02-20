package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Category;

public interface AdminCategoryDao {

	public List<Category> list() throws Exception;
}
