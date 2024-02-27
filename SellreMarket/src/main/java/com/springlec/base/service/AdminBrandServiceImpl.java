package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.AdminBrandDao;
import com.springlec.base.model.AdminPageDto;
import com.springlec.base.model.BrandDto;

@Service
public class AdminBrandServiceImpl implements AdminBrandService {

	int pageLimit = 15;
	int blockLimit = 5;
	
	@Autowired
	AdminBrandDao dao;
	
	@Autowired
	AdminPageDto dto;
	
	

	//브랜드 상세 조회하기
	@Override
	public List<BrandDto> detail(String bname) throws Exception {
		return dao.detail(bname);
	}

	//브랜드 수정하기
	@Override
	public void update(String bname, String oldBname) throws Exception {
		dao.update(bname, oldBname);
	}

	//브랜드 삭제하기
	@Override
	public void delete(String bname) throws Exception {
		dao.delete(bname);
	}
	
	//브랜드 상태 되돌리기
	@Override
	public void updateStatus(String bname) throws Exception {
		dao.updateStatus(bname);
	}

	//브랜드 등록하기
	@Override
	public void insert(String bname) throws Exception {
		dao.insert(bname);
	}

//	@Override
//	public List<BrandDto> pageList(int page, int index_no) throws Exception {
//		
//		int pageStart = (page - 1) * pageLimit + 1;
//		System.out.println("[service] pageList :  "+pageStart);
//		return dao.pageList(pageStart);
//	}
	
	@Override
	public List<BrandDto> pageList(int page) throws Exception {
		
		int pageStart = (page - 1) * pageLimit + 1;
		return dao.pageList(pageStart);
	}

	@Override
	public AdminPageDto pagingParam(int page) throws Exception {
		int boardCount = dao.boardCount();
		System.out.println("boardCount :" + boardCount);
		
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
	public int boardCount() throws Exception {
		return dao.boardCount();

	}

	@Override
	public int checkBrand(String bname) throws Exception {
		return dao.checkBrand(bname);
	}

	@Override
	public List<BrandDto> listQuery(String search, int page) throws Exception {
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

}
