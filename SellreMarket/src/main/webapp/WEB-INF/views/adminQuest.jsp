<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="stylesheet" href="css/adminQuest.css" />
<!-- <script src="js/adminQuest.js"></script> -->
</head>
<body>
	<main>
	<jsp:include page="adminHeader.jsp" flush="false" />
		<div class="main">
			<div class="title" style="display : inline-block">고객문의</div>
			<div class="btnGroup" style="display : inline-block">
				<form action="qusetListQuery" method="post">
					<select name="query" class="query">
						<option value="intitle">문의제목</option>
						<option value="insertdate">문의일자</option>
					</select>
					<input type="text" id="search" name="search">
					<input type="submit" value="검색" class="searchBtn">
				</form>
			</div>
			<div class="main_content">
				<div id="result" class="tableContainer">
					<table style="text-align:center;">
						<tr>
							<th>행번호</th>
							<th>문의제목</th>
							<th>문의일자</th>
							<th>상태</th>
						</tr>
						<c:set var="cnt" value="${rowNum }" />
						<c:forEach items="${list}" var="dto">
							<tr>
								<td><a href="adminQuestDetail?inquiryid=${dto.inquiryid }">${rowNum}</a></td>
								<td><a href="adminQuestDetail?inquiryid=${dto.inquiryid }">${dto.intitle }</a></td>
								<td><a href="adminQuestDetail?inquiryid=${dto.inquiryid }">${dto.insertdate }</a></td>
								<td><a href="adminQuestDetail?inquiryid=${dto.inquiryid }">${dto.status }</a></td>
							</tr>
							  <c:if test="${rowNum > 1}">
		                        <c:set var="cnt" value="${rowNum = rowNum-1 }" />
		                    </c:if>
						</c:forEach>
					</table>
				</div> <!-- 테이블 조회 위치 -->
			</div>
			
			<!-- 페이징 시작 -->
			<div id="paging">
				  <!-- 이전버튼 시작 -->
				  <c:choose>
				    <c:when test="${paging.page <= 1}">
				      <button disabled>&lt;</button>
				    </c:when>	
				    <c:otherwise>
				      <a href="/adminQuest?page=${paging.page - 1}" class="button">&lt;</a>
				    </c:otherwise>				
				  </c:choose>
				  <!-- 이전버튼 끝 -->
				  
				  <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
				    <c:choose>
				      <c:when test="${i eq paging.page}">
				        <button class="current">${i}</button>
				      </c:when>
				      <c:otherwise>
				        <a href="/adminQuest?page=${i}" class="button">${i}</a>
				      </c:otherwise>
				    </c:choose>
				  </c:forEach>
				  
				  <!-- 다음버튼 시작 -->
				  <c:choose>
				    <c:when test="${paging.page >= paging.maxPage}">
				      <button disabled>&gt;</button>
				    </c:when>	
				    <c:otherwise>
				      <a href="/adminQuest?page=${paging.page + 1}" class="button">&gt;</a>
				    </c:otherwise>				
				  </c:choose>
				  <!-- 다음버튼 끝 -->
			</div>

		</div>
		
		<div id="ddd"></div>
	</main>
	</body>
</html>