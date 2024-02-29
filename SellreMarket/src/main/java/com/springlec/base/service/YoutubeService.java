package com.springlec.base.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.AdminProductDto;
import com.springlec.base.model.BrandDto;
import com.springlec.base.model.Category;
import com.springlec.base.model.YoutubeDto;

public interface YoutubeService {

	//카테고리 가져오기
	public List<Category> categoryList() throws Exception;
	
	//중분류 가져오기
	public List<Category> subCategoryList(String type) throws Exception;
	
	//초기 subtype 가져오기
	public List<Category> selectSubCategory() throws Exception;
	
	//카테고리에 해당하는 제품 가져오기
	public List<AdminProductDto> getProductlist(String type, String subtype) throws Exception;
	
	//파일 등록
	public String uploadFile(MultipartFile file) throws Exception;
	
	public void insertInfo(String yname, String image, String rcontent, String[] selectedProducts, String ytitle) throws Exception;

	//게시글 리스트 조회
	public List<YoutubeDto> pageList(int pageStart) throws Exception;
	
	//게시글 수
	public int boardCount() throws Exception;
	
	//페이징 처리
	public AdminPageDto pagingParam(int page) throws Exception;
	
	//제품명 검색
	public List<YoutubeDto> listQuery(String search, String query, int pageStart) throws Exception;
	
	//게시글 수 검색 
	public int searchCount(String search, String query) throws Exception;
	
	public AdminPageDto pagingParam2(int page, String search, String query) throws Exception;
}
