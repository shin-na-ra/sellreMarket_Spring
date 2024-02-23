package com.springlec.base.model;

import org.springframework.stereotype.Component;

@Component
public class AdminPageDto {

	int page;			//현재 페이지 번호
	int maxPage;		//페이지당 출력할 데이터 개수
	int startPage;		//화면 하단에 출력할 페이지 사이즈
	int endPage;
	
	public AdminPageDto() {
		// TODO Auto-generated constructor stub
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	
}
