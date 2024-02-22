package com.springlec.base.service;

import java.util.Map;

import com.springlec.base.model.Notice;

public interface NoticeService {
	
	public Map<String, Object> noticeList(String curPage, String keyword) throws Exception;
	
	public int totalRowCount(String keyword) throws Exception;
	
	public Notice noticeDetail(String eventid) throws Exception;
}
