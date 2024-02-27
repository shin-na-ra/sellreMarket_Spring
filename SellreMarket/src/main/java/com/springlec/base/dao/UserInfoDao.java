package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.DeliveryInfo;
import com.springlec.base.model.UserInfo;

public interface UserInfoDao {
	
	public Integer checkDuplicatedId(String userid) throws Exception;

	public Integer checkDuplicatedEmail(String email) throws Exception;
	
	public void deliveryInfo(String address, String detailAddress, int defaultset, String userid) throws Exception;
	
	public void customerSignUp(String userid, String password, String tel, String name, String email, String address, String detailAddress, String gender, String birthdate) throws Exception;
	
	public void updateUserInfo(String userid, String password, String tel, String name, String email, String address, String detailAddress, String gender, String birthdate) throws Exception;

	
	public void deleteUserInfo(String userid) throws Exception;
	
	public void updatePassword(String userid, String password) throws Exception;
	
	public String checkID(String userid, String password) throws Exception;
	
	public UserInfo userDetail(String userid) throws Exception;
	
	public String findUserID(String name, String email) throws Exception;
	
	public int findPW(String userid, String name, String email) throws Exception;
	
	public List<DeliveryInfo> addresslist(String userid) throws Exception;
	
	public DeliveryInfo addresslistDetail(String addressid) throws Exception;
	
	public void addresslistReset(String userid) throws Exception;
	
	public void addresslistUpdate(String addressid, String address, String detailaddress, String defaultset) throws Exception;
	
	public void addresslistDelete(String addressid) throws Exception;
	
}
