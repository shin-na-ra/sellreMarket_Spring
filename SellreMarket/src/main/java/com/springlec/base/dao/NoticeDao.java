package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Notice;

public interface NoticeDao {
	
	// 공지사항의 전체 목록
	public List<Notice> noticeList(int startIndex, String keyword) throws Exception;
	// 공지사항의 세부 내용
	public Notice noticeDetail(String eventid) throws Exception;
	// 공지사항의 총 갯수 파악
	public int totalRowCount(String keyword) throws Exception;
	
	
}
