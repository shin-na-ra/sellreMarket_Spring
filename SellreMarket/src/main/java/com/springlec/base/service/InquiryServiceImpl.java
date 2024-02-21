package com.springlec.base.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
	
	@Override
	public List<Inquiry> inquiryList(String userid) throws Exception {
		return inquiryDao.inquiryList(userid);
	}

	@Override
	public void inquiryInsert(String intitle, String incontent, String inimage, String questid, String userid) throws Exception {
		inquiryDao.inquiryInsert(intitle, incontent, inimage, questid, userid);
	}

	@Override
	public String uploadFile(HttpServletRequest request, MultipartFile file) {
		// 파일의 이름
		String inimage = file.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		inimage += uuid;
		// 파일 업로드 처리
		if (inimage != null) {
			try {
				// 파일 업로드
				// 저장 경로
				String path = System.getProperty("user.dir") + "/src/main/resources/static/images/inquiry";
				file.transferTo(new File(path + "/" + inimage)); // 파일을 저장할 경로 지정
			} catch (IOException i) {
				i.printStackTrace();
			}
		}

		return inimage;
	}
	
}
