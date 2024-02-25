package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.AdminCategoryDao;
import com.springlec.base.dao.AdminEventDao;
import com.springlec.base.model.AdminEventDto;
import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.Category;

@Service
public class AdminEventServiceImpl implements AdminEventService {

	int pageLimit = 15;
	int blockLimit = 5;
	
	@Autowired
	AdminEventDao dao;
	
	@Autowired
	AdminPageDto dto;

	@Override
	public List<AdminEventDto> list(int page) throws Exception {
		
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
	public void insert(String image, String ename, String econtent, String startdate, String enddate, int salerate)
			throws Exception {
		dao.insert(image, ename, econtent, startdate, enddate, salerate);
	}

	@Override
	public List<AdminEventDto> detail(int eventid) throws Exception {
		return dao.detail(eventid);
	}

	@Override
	public void update(int eventid, String ename, String econtent, String startdate, String enddate, int salerate)
			throws Exception {
		dao.update(eventid, ename, econtent, startdate, enddate, salerate);
	}

	@Override
	public void delete(int eventid) throws Exception {
		dao.delete(eventid);
	}

}
