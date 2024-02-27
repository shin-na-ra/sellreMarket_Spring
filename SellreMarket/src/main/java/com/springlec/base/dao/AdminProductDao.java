package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.AdminDeliveryDto;
import com.springlec.base.model.AdminPackDto;
import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.AdminProductDto;
import com.springlec.base.model.AdminQuestDto;
import com.springlec.base.model.BrandDto;
import com.springlec.base.model.Category;

public interface AdminProductDao {

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
	
	//제품등록
	public void productInsert(String pname, String pEngname, String allery, String nutrition, int pstock, String origin, String description) throws Exception;
	
	//insert한 productid 가져오기
	public int getProductId(String pname, String pEngname, String allery) throws Exception;
	
	//insert 가격
	public void insertPrice(int price, int productid) throws Exception;
	
	//insert brand
	public void insertBrand(int productid, String bname) throws Exception;
	
	//inset category
	public void insertCategory(int productid, String type, String subtype) throws Exception;

	//insert pack
	public void insertPack(int productid, String packtype, String packkind) throws Exception;
	
	//insert unit
	public void insertUnit(int productid, String utype, String ugram) throws Exception;
	
	//insert delivery
	public void insertDelivery(int productid, String dname) throws Exception;
	
	//초기 subtype 가져오기
	public List<Category> selectSubCategory() throws Exception;
	
	//제품명 검색
	public List<AdminProductDto> listQuery(String search, int pageStart) throws Exception;
	
	//게시글 수 검색 
	public int searchCount(String search) throws Exception;

	//페이징 처리
	public AdminPageDto pagingParam2(int page, String search) throws Exception;
	
	//상세보기
	public List<AdminProductDto> detail(int productid) throws Exception;
	
	//제품 수정
	public void productUpdate(String pname, String pEngname, String allery, String nutrition, int pstock, String origin, String description, int productid) throws Exception;
	
	//가격 수정
	public void updatePrice(int price, int productid) throws Exception;
	
	//브랜드 수정
	public void updateBrand(int productid, String bname) throws Exception;
	
	//카테고리 수정
	public void updateCategory(int productid, String type, String subtype) throws Exception;
	
	//포장타입, 종류 수정
	public void updatePack(int productid, String packtype, String packkind) throws Exception;
	
	//단위 수정
	public void updateUnit(int productid, String utype, String ugram) throws Exception;
	
	//배달형식 수정
	public void updateDelivery(int productid, String dname) throws Exception;
	
	//제품 삭제
	public void delete(int productid) throws Exception;
	
	//제품 이미지 insert
	public void insertImage(int productid, String image) throws Exception;
	
	//제품 이미지 update
	public void updateImage(int productid, String image) throws Exception;
	
}

