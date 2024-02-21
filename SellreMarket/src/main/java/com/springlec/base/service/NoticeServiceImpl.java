package com.springlec.base.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springlec.base.dao.NoticeDao;
import com.springlec.base.model.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao dao;
	
	@Override
	public Map<String, Object> noticeList(String curPage, String keyword) throws Exception {
		// keyword : 검색할 단어
		// curPage : 현재 페이지
		int newCurPage = Integer.parseInt(curPage);
		
		if(Integer.parseInt(curPage) == 0) {
			newCurPage = 1;
		}
		
		// 한 페이지에 몇 개의 ROW를 보여줄 것인지
		int pagePerCount = 10;

		// 총 데이터의 갯수
		int totalRowCount = 0;
		totalRowCount = totalRowCount(keyword);

		// 전체 페이지 수
		// 85개의 데이터 수 / 10 + 1 = 총 9p
		// 90개의 데이터 수 / 10 + 1 = 총 10p
		int totalPage = totalRowCount % pagePerCount == 0 ? (totalRowCount / pagePerCount)
				: (totalRowCount / pagePerCount) + 1;

		// 현재 페이지에 해당하는 시작 index
		// curPage = 1 이면, startIndex = 0 | curPage = 2 이면, startIndex = 10
		// 1p 에서는 limit 0 ~ 10, 2p 에서는 limit 10 ~ 10
		// np 에서는 limit startIndex ~ 10
		// 0 < row < 10 --- limit
		int startIndex = (newCurPage - 1) * pagePerCount;

		// 현재 페이지가 위치한 블럭
		// << [1,2,3,4,5] >> 이면, curBlockNo = 1
		// << [6,7,8,9,10] >> 이면, curBlockNo = 2
		// curPage가 5의 배수이면 참, 아니면 거짓 이므로,
		// curPage = 5 이면, 5 / 5 = 1이고,
		// curPage < 5 이면, (n / 5) + 1 = 1임.
		// 따라서 1 <= curPage <= 5 이면, curBlockNo = 1
		int curBlockNo = newCurPage % (pagePerCount / 2) == 0 ? (newCurPage / (pagePerCount / 2))
				: ((newCurPage / (pagePerCount / 2)) + 1);

		// 한 블럭의 시작 페이지와 끝 페이지
		// << [1,2,3,4,5] >> , curBlockNo = 1 이면, 1p 부터 시작, 5p까지
		// << [6,7,8,9,10] >> ,curBlockNo = 2 이면, 6p 부터 시작
		int blockStartPage = 1 + (curBlockNo - 1) * (pagePerCount / 2);
		int blockEndPage = blockStartPage + (pagePerCount / 2) - 1;

		List<Notice> eventList = dao.noticeList(startIndex, "%" + keyword + "%");

		Map<String, Object> data = new HashMap<String, Object>();

		data.put("eventList", eventList);
		data.put("totalPage", totalPage);
		data.put("blockStartPage", blockStartPage);
		data.put("blockEndPage", blockEndPage);
		data.put("curPage", curPage);

		return data;
	}

	@Override
	public int totalRowCount(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return dao.totalRowCount(keyword);
	}


}
