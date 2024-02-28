package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.PurchaseDto;

public interface PurchaseDao {
	public List<PurchaseDto> purchaseDao(String userId) throws Exception;
	public List<PurchaseDto> searchInsideDao(String searchText) throws Exception;
	public List<PurchaseDto> searchOutsideDao(String searchText) throws Exception;
	public List<PurchaseDto> detailDao(String purchaseId) throws Exception;
}
