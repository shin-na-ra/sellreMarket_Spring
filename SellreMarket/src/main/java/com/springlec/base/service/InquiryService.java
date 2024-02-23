package com.springlec.base.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.Inquiry;

import jakarta.servlet.http.HttpServletRequest;

public interface InquiryService {
	
	public List<Inquiry> inquiryList(String userid) throws Exception;
	
	public void inquiryInsert(String intitle, String incontent, String inimage, String questid, String userid) throws Exception;

	public String uploadFile(MultipartFile file) throws Exception;
	
	public Inquiry inquiryDetail(String userid, String inquiryid) throws Exception;
}
