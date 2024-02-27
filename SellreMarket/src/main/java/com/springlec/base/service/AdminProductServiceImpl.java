package com.springlec.base.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.dao.AdminProductDao;
import com.springlec.base.model.AdminDeliveryDto;
import com.springlec.base.model.AdminPackDto;
import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.AdminProductDto;
import com.springlec.base.model.BrandDto;
import com.springlec.base.model.Category;

@Service
@Transactional(rollbackFor = Exception.class)
public class AdminProductServiceImpl implements AdminProductService {

	int pageLimit = 15;
	int blockLimit = 5;
	
	@Autowired
	AdminProductDao dao;
	
	@Autowired
	AdminPageDto dto;

	@Override
	public List<AdminProductDto> list(int page) throws Exception {
		int pageStart = (page - 1) * pageLimit + 1;
		return dao.list(pageStart);
	}

	@Override
	public AdminPageDto pagingParam(int page) throws Exception {
		int boardCount = dao.listCount();
		
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
	public int listCount() throws Exception {
		return dao.listCount();
	}

	@Override
	public List<BrandDto> brandList() throws Exception {
		return dao.brandList();
	}

	@Override
	public List<Category> categoryList() throws Exception {
		return dao.categoryList();
	}

	@Override
	public List<Category> subCategoryList(String type) throws Exception {
		return dao.subCategoryList(type);
	}

	@Override
	public List<AdminPackDto> selectPackType() throws Exception {
		return dao.selectPackType();
	}

	@Override
	public List<AdminPackDto> selectPackKind() throws Exception {
		return dao.selectPackKind();
	}

	@Override
	public List<AdminDeliveryDto> selectDelivery() throws Exception {
		return dao.selectDelivery();
	}

	@Override
	public void insertInfo(String pname, String pEngname, String allery, String nutrition, int pstock, String origin,
			String description, int price, String bname, String subtype, String type, String packkind, String packtype,
			String utype, String ugram, String dname, String image) throws Exception {
		
		
		//제품 등록하기
		dao.productInsert(pname, pEngname, allery, nutrition, pstock, origin, description);
		
		//등록된 제품 가져오기
		int productid = dao.getProductId(pname, pEngname, allery);
		
		//가격 등록
		dao.insertPrice(price, productid);
		
		//브랜드 등록
		dao.insertBrand(productid, bname);
		
		//카테고리 등록
		dao.insertCategory(productid, type, subtype);
		
		//포장타입, 종류 등록
		dao.insertPack(productid, packtype, packkind);
		
		//단위 등록
		dao.insertUnit(productid, utype, ugram);
		
		dao.insertDelivery(productid, dname);
		
		dao.insertImage(productid, image);
		System.out.println("image2 : "+image);
	}

	@Override
	public List<Category> selectSubCategory() throws Exception {
		return dao.selectSubCategory();
	}

	@Override
	public List<AdminProductDto> listQuery(String search, int page) throws Exception {
		search = '%'+search+'%';
		int pageStart = (page - 1) * pageLimit + 1;
		return dao.listQuery(search, pageStart);
	}

	@Override
	public int searchCount(String search) throws Exception {
		search = '%'+search+'%';
		return dao.searchCount(search);
	}
	
	@Override
	public AdminPageDto pagingParam2(int page, String search) throws Exception {
		search = '%'+search+'%';
		int boardCount = dao.searchCount(search);
		
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
	public List<AdminProductDto> detail(int productid) throws Exception {
		return dao.detail(productid);
	}

	@Override
	public void updateInfo(String pname, String pEngname, String allery, String nutrition, int pstock, String origin,
			String description, int price, String bname, String subtype, String type, String packkind, String packtype,
			String utype, String ugram, String dname, int productid, String image) throws Exception {
		
		//제품 등록하기
		dao.productUpdate(pname, pEngname, allery, nutrition, pstock, origin, description, productid);
		
		//가격 등록
		dao.updatePrice(price, productid);
		
		//브랜드 등록
		dao.updateBrand(productid, bname);
		
		//카테고리 등록
		dao.updateCategory(productid, type, subtype);
		
		//포장타입, 종류 등록
		dao.updatePack(productid, packtype, packkind);
		
		//단위 등록
		dao.updateUnit(productid, utype, ugram);
		
		dao.updateDelivery(productid, dname);
		
		//이미지 수정 - 이미지 변경이 있을 때만 update처리
		if(image != null ) {
			dao.updateImage(productid, image);
		}
		
	}

	@Override
	public void delete(int productid) throws Exception {
		dao.delete(productid);
	}

	@Override
	public String uploadFile(MultipartFile file) throws Exception {
		// 파일이름 :  랜덤 + 파일이름
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
}
