package com.springlec.base.service;

import java.util.HashMap;
import java.util.List;

import com.springlec.base.model.DeliveryInfo;
import com.springlec.base.model.UserInfo;

import jakarta.servlet.http.HttpServletRequest;

public interface UserInfoService {
	
	public HashMap<String, Object> checkDuplicatedId(String userid) throws Exception;
	
	public HashMap<String,Object> checkDuplicatedEmail(String email, HttpServletRequest request) throws Exception;
	
	public HashMap<String, Object> authentication(String name, String email, HttpServletRequest request) throws Exception;
	
	public void customerSignUp(String userid, String password, String tel, String name, String email, String address, String detailAddress, String gender, String birthdate) throws Exception;
	
	public void updateUserInfo(String userid, String password, String tel, String name, String email, String address, String detailAddress, String gender, String birthdate) throws Exception;

	public String checkID(String userid, String password) throws Exception;
	
	public UserInfo userDetail(String userid) throws Exception;
	
	public void userDelete(String userid) throws Exception;
	
	public String findUserID(String name, String email) throws Exception;
	
	public String findPW(String userid, String name, String email) throws Exception;
	
	public void updatePassword(String userid, String password) throws Exception;
	
	public List<DeliveryInfo> addresslist(String userid) throws Exception;
	
	public DeliveryInfo addresslistDetail(String addressid) throws Exception;
	
	public void addresslistUpdate(String userid, String addressid, String address, String detailaddress, String defaultset) throws Exception;

	public void addresslistInsert(String userid, String address, String detailaddress, String defaultset) throws Exception;

	public void addresslistDelete(String addressid) throws Exception;
	
	
}
