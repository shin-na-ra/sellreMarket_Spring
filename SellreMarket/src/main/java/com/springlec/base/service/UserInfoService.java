package com.springlec.base.service;

import java.util.HashMap;

import jakarta.servlet.http.HttpServletRequest;

public interface UserInfoService {
	
	public HashMap<String, Object> checkDuplicatedId(String userid) throws Exception;
	
	public HashMap<String,Object> checkDuplicatedEmail(String email, HttpServletRequest request) throws Exception;
	
	public HashMap<String, Object> authentication(String email, HttpServletRequest request) throws Exception;
	
	public void customerSignUp(String userid, String password, String tel, String name, String email, String address, String detailAddress, String gender, String birthdate) throws Exception;
	
	public void updateUserInfo(String userid, String password, String tel, String name, String email, String address, String detailAddress, String gender, String birthdate) throws Exception;

}
