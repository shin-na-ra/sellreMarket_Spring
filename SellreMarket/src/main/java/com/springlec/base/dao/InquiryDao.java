package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.Inquiry;


public interface InquiryDao {
	// 1:1 문의 전체내역
	public List<Inquiry> inquiryList(String userid) throws Exception;
	// 1:1 문의 입력
	public void inquiryInsert(String intitle, String incontent, String inimage, String questid, String userid) throws Exception;
		
}
