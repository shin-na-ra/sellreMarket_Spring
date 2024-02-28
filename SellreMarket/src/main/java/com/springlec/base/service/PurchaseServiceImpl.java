package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.PurchaseDao;
import com.springlec.base.model.PurchaseDto;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	PurchaseDao dao;

	@Override
	public List<PurchaseDto> purchaseDao() throws Exception {
		// TODO Auto-generated method stub
		return dao.purchaseDao();
	}
	
	@Override
	public List<PurchaseDto> searchInsideDao(String searchText) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchInsideDao("%" + searchText + "%");
	}

	@Override
	public List<PurchaseDto> searchOutsideDao(String searchText) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchOutsideDao("%" + searchText + "%");
	}

	@Override
	public List<PurchaseDto> detailDao(String purchaseId) throws Exception {
		// TODO Auto-generated method stub
		return dao.detailDao(purchaseId);
	}


}
