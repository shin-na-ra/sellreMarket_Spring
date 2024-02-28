<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>브랜드 관리 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> <!-- 추가 -->
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="css/adminBrand.css" />
<!-- <script src="js/adminBrand.js"></script> -->
</head>
<body>
	<main>
	<jsp:include page="adminHeader.jsp" flush="false" />
		<div class="main">
			<div class="title" style="display : inline-block">브랜드 관리</div>
			<div class="btnGroup">
				<form action="brandListQuery" method="post">
					브랜드명 : &nbsp;
					<input type="text" id="search" name="search">
					<input type="submit" value="검색" class="searchBtn">
				</form>
				<a href="adminBrandRegister"><button class="registerBtn">등록</button></a>
			</div>
			<div class="main_content">
				<div id="result" class="tableContainer">
					<table style="text-align:center;">
						<tr>
							<th>행번호</th>
							<th>브랜드명</th>
							<th>상태</th>
						</tr>
						<c:set var="cnt" value="${rowNum }" />
						<c:forEach items="${list}" var="dto">
							<tr>
								<td><a href="adminBrandDetail?bname=${dto.bname }">${rowNum}</a></td>
								<td><a href="adminBrandDetail?bname=${dto.bname }">${dto.bname }</a></td>
								<td><a href="adminBrandDetail?bname=${dto.bname }">${dto.status }</a></td>
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
				      <a href="/adminBrand?page=${paging.page - 1}" class="button">&lt;</a>
				    </c:otherwise>				
				  </c:choose>
				  <!-- 이전버튼 끝 -->
				  
				  <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
				    <c:choose>
				      <c:when test="${i eq paging.page}">
				        <button class="current">${i}</button>
				      </c:when>
				      <c:otherwise>
				        <a href="/adminBrand?page=${i}" class="button">${i}</a>
				      </c:otherwise>
				    </c:choose>
				  </c:forEach>
				  
				  <!-- 다음버튼 시작 -->
				  <c:choose>
				    <c:when test="${paging.page >= paging.maxPage}">
				      <button disabled>&gt;</button>
				    </c:when>	
				    <c:otherwise>
				      <a href="/adminBrand?page=${paging.page + 1}" class="button">&gt;</a>
				    </c:otherwise>				
				  </c:choose>
				  <!-- 다음버튼 끝 -->
			</div>

		</div>
		
		<div id="ddd"></div>
	</main>
	
</body>
</html>