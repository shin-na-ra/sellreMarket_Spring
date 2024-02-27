package com.springlec.base.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springlec.base.dao.AdminEventDao;
import com.springlec.base.model.AdminEventDto;
import com.springlec.base.model.AdminOrderDto;
import com.springlec.base.model.AdminPageDto;

@Service
public class AdminEventServiceImpl implements AdminEventService {

	int pageLimit = 15;
	int blockLimit = 5;
	
	@Autowired
	AdminEventDao dao;
	
	@Autowired
	AdminPageDto dto;

	@Override
	public List<AdminEventDto> list(int page) throws Exception {
		
		int pageStart = (page - 1) * pageLimit + 1;
		return dao.list(pageStart);
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
	public int boardCount() throws Exception {
		return dao.boardCount();

	}

	@Override
	public void insert(String image, String ename, String econtent, String startdate, String enddate, int salerate, int produdctid, int catetoryid)
			throws Exception {
		dao.insert(image, ename, econtent, startdate, enddate, salerate, produdctid, catetoryid);
		
	}

	@Override
	public List<AdminEventDto> detail(int eventid) throws Exception {
		return dao.detail(eventid);
	}

	@Override
	public void update(int eventid, String ename, String econtent, String startdate, String enddate, int salerate, String image)
			throws Exception {
		dao.update(eventid, ename, econtent, startdate, enddate, salerate, image);
	}

	@Override
	public void delete(int eventid) throws Exception {
		dao.delete(eventid);
	}

	@Override
	public List<AdminOrderDto> productSelect() throws Exception {
		return dao.productSelect();
	}

	@Override
	public int selectCategoryId(int productid) throws Exception {
		return dao.selectCategoryId(productid);
	}

	@Override
	public List<AdminEventDto> listQuery(String search, String query, int page) throws Exception {
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

	@Override
	public void updateNoImage(int eventid, String ename, String econtent, String startdate, String enddate,
			int salerate) throws Exception {
		dao.updateNoImage(eventid, ename, econtent, startdate, enddate, salerate);
	}
}
