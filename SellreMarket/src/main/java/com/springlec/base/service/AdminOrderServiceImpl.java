package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.AdminOrderDao;
import com.springlec.base.model.AdminOrderDto;
import com.springlec.base.model.AdminPageDto;

@Service
@Transactional(rollbackFor = Exception.class)
public class AdminOrderServiceImpl implements AdminOrderService {

	int pageLimit = 15;
	int blockLimit = 5;
	
	@Autowired
	AdminOrderDao dao;
	
	@Autowired
	AdminPageDto dto;
	
	@Override
	public List<AdminOrderDto> questList(int page) throws Exception {
		
		int pageStart = (page - 1) * pageLimit + 1;
		return dao.questList(pageStart);
	}

	@Override
	public AdminPageDto pagingParam(int page) throws Exception {
		int boardCount = dao.listCount();
		
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
	public int listCount() throws Exception {
		return dao.listCount();
	}

	@Override
	public List<AdminOrderDto> detail(int inquiryid) throws Exception {
		return dao.detail(inquiryid);
	}

	@Override
	public void insertOrder(int rcount, String rcomment, int productid) throws Exception {
		dao.insertOrder(rcount, rcomment, productid);
		dao.insertProduct(rcount, productid);
	}


}
