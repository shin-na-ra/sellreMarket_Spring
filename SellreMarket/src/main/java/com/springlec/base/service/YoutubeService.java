package com.springlec.base.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.model.AdminProductDto;
import com.springlec.base.model.Category;

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
}
