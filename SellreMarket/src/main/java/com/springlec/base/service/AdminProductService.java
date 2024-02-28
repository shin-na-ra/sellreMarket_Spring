package com.springlec.base.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.AdminDeliveryDto;
import com.springlec.base.model.AdminPackDto;
import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.AdminProductDto;
import com.springlec.base.model.BrandDto;
import com.springlec.base.model.Category;
import com.springlec.base.model.UserInfo;

public interface AdminProductService {

	//게시글 리스트 조회
	public List<AdminProductDto> list(int pageStart) throws Exception;
	
	//게시글 수
	public int listCount() throws Exception;
	
	//페이징 처리
	public AdminPageDto pagingParam(int page) throws Exception;
	
	//브랜드 가져오기
	public List<BrandDto> brandList() throws Exception;
	
	//카테고리 가져오기
	public List<Category> categoryList() throws Exception;
	
	//중분류 가져오기
	public List<Category> subCategoryList(String type) throws Exception;
	
	//포장 타입 가져오기
	public List<AdminPackDto> selectPackType() throws Exception;
	
	//포장 종류 가져오기
	public List<AdminPackDto> selectPackKind() throws Exception;
	
	//배달 타입 가져오기
	public List<AdminDeliveryDto> selectDelivery() throws Exception;

	public void insertInfo(String pname, String pEngname, String allery, String nutrition, int pstock, String origin, String description
			,int price, String bname, String subtype, String type, String packkind, String packtype, String utype, String ugram, String dname, String image) throws Exception;
	
	//초기 subtype 가져오기
	public List<Category> selectSubCategory() throws Exception;
	
	//제품명 검색
	public List<AdminProductDto> listQuery(String search, int page) throws Exception;
	
	//게시글 수 검색 
	public int searchCount(String search) throws Exception;
	
	public AdminPageDto pagingParam2(int page, String search) throws Exception;
	
	//상세보기
	public List<AdminProductDto> detail(int productid) throws Exception;
	
	//제품수정
	public void updateInfo(String pname, String pEngname, String allery, String nutrition, int pstock, String origin, String description
			,int price, String bname, String subtype, String type, String packkind, String packtype, String utype, String ugram, String dname, int productid, String image) throws Exception;
	
	//제품 삭제
	public void delete(int productid) throws Exception;	
	
	//파일 등록
	public String uploadFile(MultipartFile file) throws Exception;
	
	//adminLogin Check
	public List<UserInfo> checkID(String userid, String password) throws Exception;
	
	//제품 다시 진행중으로 변경
	public void changeStatus(int productid) throws Exception;
	
}
