package com.springlec.base.service;

import java.util.List;

import com.springlec.base.dao.PurchaseDao;
import com.springlec.base.model.PurchaseDto;

public interface PurchaseService {
	public List<PurchaseDto> purchaseDao() throws Exception;
	public List<PurchaseDto> searchInsideDao(String searchText) throws Exception;
	public List<PurchaseDto> searchOutsideDao(String searchText) throws Exception;
	public List<PurchaseDto> detailDao(String purchaseId) throws Exception;
}
