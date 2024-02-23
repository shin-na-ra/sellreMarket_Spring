package com.springlec.base.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.dao.InquiryDao;
import com.springlec.base.model.Inquiry;

import jakarta.servlet.http.HttpServletRequest;


@Service
public class InquiryServiceImpl implements InquiryService {

	@Autowired
	InquiryDao inquiryDao;
	
	// 문의사항 목록
	@Override
	public List<Inquiry> inquiryList(String userid) throws Exception {
		List<Inquiry> inquiry = inquiryDao.inquiryList(userid);
		
		for (Inquiry currentInquiry : inquiry) {
		    // 날짜 형식 변경
		    if (currentInquiry.getInsertdate() != null) currentInquiry.setInsertdate(currentInquiry.getInsertdate().substring(0, 10));
		    if (currentInquiry.getAnswerdate() != null) currentInquiry.setAnswerdate(currentInquiry.getAnswerdate().substring(0, 10));
		}
		
		return inquiry;
	}
	
	// 문의사항 입력
	@Override
	public void inquiryInsert(String intitle, String incontent, String inimage, String questid, String userid) throws Exception {
		inquiryDao.inquiryInsert(intitle, incontent, inimage, questid, userid);
	}
	
	// 이미지 업로드
	@Override
	public String uploadFile(MultipartFile file) {
		// 파일의 이름
		String inimage = file.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		inimage = uuid + inimage;
		
		// 파일 업로드 처리
		if (inimage != null) {
			try {
				// 파일 업로드
				// 저장 경로
				String path = System.getProperty("user.dir") + "/src/main/resources/static/image/inquiry";
				file.transferTo(new File(path + "/" + inimage)); // 파일을 저장할 경로 지정
				System.out.println(path);
			} catch (IOException i) {
				i.printStackTrace();
			}
		}
		return inimage;
	}
	
	// 문의사항 상세내역
	@Override
	public Inquiry inquiryDetail(String userid, String inquiryid) throws Exception {
		Inquiry inquiry = inquiryDao.inquiryDetail(userid, inquiryid);
		
		// 날짜 형식 변경
		if(inquiry.getInsertdate() != null) inquiry.setInsertdate(inquiry.getInsertdate().substring(0,16));
		if(inquiry.getAnswerdate() != null) inquiry.setAnswerdate(inquiry.getAnswerdate().substring(0,16));
		
		return inquiry;
		
	}
	
}
