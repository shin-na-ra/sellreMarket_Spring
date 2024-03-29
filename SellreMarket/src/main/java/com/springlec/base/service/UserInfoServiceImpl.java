package com.springlec.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springlec.base.dao.UserInfoDao;
import com.springlec.base.model.DeliveryInfo;
import com.springlec.base.model.UserInfo;

import jakarta.servlet.http.HttpServletRequest;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	UserInfoDao dao;
	
	@Autowired
	HashMap<String, Object> data;
	
	@Override
	public HashMap<String, Object> checkDuplicatedId(String userid) throws Exception {
		// 아이디가 중복되었다면 1, 아니면 0
		if(dao.checkDuplicatedId(userid) == 1) { 
			data.put("result", "false");
		}
		else {
			data.put("result", "true");
		}
		return data;
	}

	@Override
	public HashMap<String,Object> checkDuplicatedEmail(String email, HttpServletRequest request) throws Exception {
		// 아이디가 중복되었다면 1, 아니면 0
		if(dao.checkDuplicatedEmail(email) != 0) {
			data.put("result", "false");
			return data;
		}
		else {
			return authentication(null, email, request);
		}
	}

	@Override
	public HashMap<String, Object> authentication(String name, String email, HttpServletRequest request) throws Exception {
		//mail server 설정
		String smtpEmail = "jsungj3@gmail.com"; 
		String password = "uliauyosxkhulgmg";

		//메일 받을 주소
		String to_email = email;
		/* Properties p = new Properties(); */
        Properties p = System.getProperties();	
		p.setProperty("mail.transport.protocol", "smtp");
		/* p.setProperty("mail.host", "smtp.gmail.com"); */
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.auth", "true");
	    p.put("mail.smtp.debug", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.ssl.protocols", "TLSv1.2");
        p.put("mail.smtp.socketFactory.port", "587");
        p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
       
        //인증 번호 생성기
		StringBuffer temp =new StringBuffer();
		Random rnd = new Random();
		for(int i=0;i<10;i++)
		{
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		String AuthenticationKey = temp.toString();
		System.out.println("AuthenticationKey : " + AuthenticationKey);

		javax.mail.Session session = javax.mail.Session.getInstance(p, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(smtpEmail,password);
			}
		});
		
		//email 전송
		try {
			javax.mail.internet.MimeMessage msg = new javax.mail.internet.MimeMessage(session);
	
			msg.addRecipient(javax.mail.Message.RecipientType.TO, new javax.mail.internet.InternetAddress(to_email));
			
			// 회원가입 시 이메일 전송
			if(name == null) {
				//메일 제목
				msg.setSubject("셀리마켓의 회원가입 인증번호");
				//메일 내용
				msg.setText("셀리마켓의 회원가입을 위한 인증 번호는 ["+temp +"] 입니다");
			}
			// 비밀번호 찾기 시 이메일 전송
			else {
				// 메일 제목
				msg.setSubject("셀리마켓 - 비밀번호 찾기 인증번호");
				// 메일 내용
				msg.setText(name + "님, 비밀번호 찾기 인증 번호는 [" + temp + "] 입니다");
			}
			
			javax.mail.Transport t = session.getTransport("smtp");
			t.connect(smtpEmail,password);
			t.sendMessage(msg, msg.getAllRecipients());
			t.close();
			
			jakarta.servlet.http.HttpSession session1 = request.getSession();
			
			session1.setAttribute("authentication", AuthenticationKey);
			data.put("authentication", AuthenticationKey);
			data.put("result", "true");

		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return data;
	}

	@Override
	public void customerSignUp(String userid, String password, String tel, String name, String email, String address,
			String detailAddress, String gender, String birthdate) throws Exception {
		
		// 회원가입 정보 입력
		dao.customerSignUp(userid, password, tel, name, email, address, detailAddress, gender, birthdate);
		
		// 배송지 정보 입력
		int defaultset = 1;
		dao.deliveryInfo(address, detailAddress, defaultset, userid);
	}

	@Override
	public void updateUserInfo(String userid, String password, String tel, String name, String email, String address,
			String detailAddress, String gender, String birthdate) throws Exception {
		// 회원정보 수정
		dao.updateUserInfo(userid, password, tel, name, email, address, detailAddress, gender, birthdate);
		dao.defaultAddressUpdate(address, detailAddress, userid);
	}

	@Override
	public String checkID(String userid, String password) throws Exception {
		// ID,PW correct : "name" return
		return dao.checkID(userid, password) != null ? dao.checkID(userid, password) : "false";
	}

	@Override
	public UserInfo userDetail(String userid) throws Exception {
		return dao.userDetail(userid);
	}

	@Override
	public void userDelete(String userid) throws Exception {
		dao.deleteUserInfo(userid);
	}

	@Override
	public String findUserID(String name, String email) throws Exception {
		return dao.findUserID(name, email);
	}

	@Override
	public String findPW(String userid, String name, String email) throws Exception {
		return (dao.findPW(userid, name, email) != 0 ? "true" : "false");
	}

	@Override
	public void updatePassword(String userid, String password) throws Exception {
		dao.updatePassword(userid, password);
	}

	@Override
	public List<DeliveryInfo> addresslist(String userid) throws Exception {
		return dao.addresslist(userid);
	}

	@Override
	public DeliveryInfo addresslistDetail(String addressid) throws Exception {
		return dao.addresslistDetail(addressid);
	}

	@Override
	public void addresslistUpdate(String userid, String addressid, String address, String detailaddress, String defaultset) throws Exception {
		// defaultset이 1, 즉 대표주소로 설정 될때마다 모든 주소의 대표주소 여부를 초기화 후 해당하는 주소를 대표주소로 설정
		if(defaultset.equals("1")) {
			dao.addresslistReset(userid);
			dao.customeraddressUpdate(address, detailaddress, userid);
		}
		
		dao.addresslistUpdate(addressid, address, detailaddress, defaultset);
	}

	// 배송지 추가
	@Override
	public void addresslistInsert(String userid, String address, String detailaddress, String defaultset) throws Exception {
		// String.valueOf : 객체를 문자열로 변환
		int intDefaultset = Integer.parseInt(defaultset);
		System.out.println("intDefaultset : " + intDefaultset);
		if(intDefaultset == 1) {
			dao.addresslistReset(userid);
			dao.customeraddressUpdate(address, detailaddress, userid);
		}
		dao.deliveryInfo(address, detailaddress, intDefaultset, userid);
	}

	@Override
	public void addresslistDelete(String addressid) throws Exception {
		dao.addresslistDelete(addressid);
	}

	
}
