package com.springlec.base.service;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.dao.YoutubeDao;
import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.AdminProductDto;
import com.springlec.base.model.Category;
import com.springlec.base.model.YoutubeDto;

@Service
@Transactional(rollbackFor = Exception.class)
public class YoutubeServiceImpl implements YoutubeService{

	int pageLimit = 15;
	int blockLimit = 5;
	
	@Autowired
	YoutubeDao dao;
	
	@Autowired
	AdminPageDto dto;

	@Override
	public List<Category> categoryList() throws Exception {
		return dao.categoryList();
	}

	@Override
	public List<Category> subCategoryList(String type) throws Exception {
		return dao.subCategoryList(type);
	}

	@Override
	public List<Category> selectSubCategory() throws Exception {
		return dao.selectSubCategory();
	}

	@Override
	public List<AdminProductDto> getProductlist(String type, String subtype) throws Exception {
		return dao.getProductlist(type, subtype);
	}

	@Override
	public String uploadFile(MultipartFile file) throws Exception {
		String image = file.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		image = uuid + image;
		
		//업로드 처리
		if(image != null) {
			String path = System.getProperty("user.dir") + "//src/main/resources/static/image";
			file.transferTo(new File(path + "/" + image));
		}
		return image;
	}

	@Override
	public void insertInfo(String yname, String image, String rcontent, String[] selectedProducts , String ytitle) throws Exception {
		
		dao.insertYoutubeInfo(yname,image,ytitle);
	    int youtubeid = dao.selectYoutubeId(yname, image);
	    System.out.println("dfdf : "+youtubeid);
	    dao.insertRecipeInfo(youtubeid, rcontent);
		
	    int recipeid = dao.selectRecipeId(youtubeid, rcontent);
	    System.out.println("recipeid : "+recipeid);
		
	    if(selectedProducts != null) {
	    	//중복된 값 제거 후 for문 돌리며 insert
	    	Set<String> uniqueProducts = new HashSet<>(Arrays.asList(selectedProducts));
	    	for (String productid : uniqueProducts) {
	    	    System.out.println("선택한 제품 id: " + productid);
	    	    dao.insertProductToRecipe(recipeid, productid);
	    	}

	    }
		
	}

	@Override
	public List<YoutubeDto> pageList(int page) throws Exception {
		int pageStart = (page - 1) * pageLimit + 1;
		return dao.pageList(pageStart);
	}

	@Override
	public int boardCount() throws Exception {
		return dao.boardCount();
	}

	@Override
	public AdminPageDto pagingParam(int page) throws Exception {
		int boardCount = dao.boardCount();
		
		int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
		
		//시작페이지 계산
		int startPage = (int)(Math.ceil((double) page / blockLimit) - 1) * blockLimit + 1;
		
		int endPage = startPage + blockLimit -1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		dto.setPage(page);
		dto.setStartPage(startPage);
		dto.setMaxPage(maxPage);
		dto.setEndPage(endPage);
		
		return dto;
	}

	@Override
	public List<YoutubeDto> listQuery(String search, String query, int page) throws Exception {
		search = '%'+search+'%';
		int pageStart = (page - 1) * pageLimit + 1;
		return dao.listQuery(search, query, pageStart);
	}

	@Override
	public int searchCount(String search, String query) throws Exception {
		search = '%'+search+'%';
		return dao.searchCount(search, query);
	}

	@Override
	public AdminPageDto pagingParam2(int page, String search, String query) throws Exception {
		search = '%'+search+'%';
		int boardCount = dao.searchCount(search, query);
		
		int maxPage = (int) (Math.ceil((double) boardCount / pageLimit));
		
		//시작페이지 계산
		int startPage = (int)(Math.ceil((double) page / blockLimit) - 1) * blockLimit + 1;
		
		int endPage = startPage + blockLimit -1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		dto.setPage(page);
		dto.setStartPage(startPage);
		dto.setMaxPage(maxPage);
		dto.setEndPage(endPage);
		
		return dto;
	}
	
}
