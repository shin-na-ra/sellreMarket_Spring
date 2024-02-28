package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.AdminCategoryDao;
import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.Category;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

	int pageLimit = 15;
	int blockLimit = 5;
	
	@Autowired
	AdminCategoryDao dao;
	
	@Autowired
	AdminPageDto dto;

	@Override
	public List<Category> list(int page) throws Exception {
		
		int pageStart = (page - 1) * pageLimit + 1;
		return dao.list(pageStart);
	}
	
	@Override
	public AdminPageDto pagingParam(int page) throws Exception {
		int boardCount = dao.boardCount();
		
		int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
		
		//시작페이지 계산
		int startPage = (int)(Math.ceil((double) page / blockLimit) - 1) * blockLimit + 1;
		
		int endPage = startPage + blockLimit -1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		dto.setPage(page);
		dto.setStartPage(startPage);
		dto.setMaxPage(maxPage);
		dto.setEndPage(endPage);
		
		return dto;
 	}

	@Override
	public int boardCount() throws Exception {
		return dao.boardCount();

	}

	@Override
	public void insertCategory(String type, String subtype) throws Exception {
		dao.insertCategory(type, subtype);
	}

	@Override
	public List<Category> detail(String type, String subtype) throws Exception {
		return dao.detail(type, subtype);
	}

	@Override
	 public void update(String type, String subtype, String oldtype, String oldsubtype) throws Exception {
		dao.update(type, subtype, oldtype, oldsubtype);
	}

	@Override
	public void delete(String type, String subtype) throws Exception {
		dao.delete(type, subtype);
	}

	@Override
	public void changeStatus(String type, String subtype) throws Exception {
		dao.changeStatus(type, subtype);
	}



	@Override
	public List<Category> listQuery(String search, String query, int page) throws Exception {
		search = '%'+search+'%';
		int pageStart = (page - 1) * pageLimit + 1;
		return dao.listQuery(search, query, pageStart);
	}

	@Override
	public int searchCount(String search, String query) throws Exception {
		search = '%'+search+'%';
		return dao.searchCount(search, query);
	}

	@Override
	public AdminPageDto pagingParam2(int page, String search, String query) throws Exception {
		search = '%'+search+'%';
		int boardCount = dao.searchCount(search, query);
		
		int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
		
		//시작페이지 계산
		int startPage = (int)(Math.ceil((double) page / blockLimit) - 1) * blockLimit + 1;
		
		int endPage = startPage + blockLimit -1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		dto.setPage(page);
		dto.setStartPage(startPage);
		dto.setMaxPage(maxPage);
		dto.setEndPage(endPage);
		
		return dto;
	}

}
