package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Notice;

public interface NoticeDao {
	
	public List<Notice> noticeList(int startIndex, String keyword) throws Exception;
	
	Notice noticeDetail(String eventid) throws Exception;
	
	public int totalRowCount(String keyword) throws Exception;
	
}
