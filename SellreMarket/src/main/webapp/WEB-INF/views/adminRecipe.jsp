<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 관리 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> <!-- 추가 -->
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="css/adminCategory.css" />
<!-- <script src="js/adminrecipe.js"></script> -->
</head>
<body>
	<main>
	<jsp:include page="adminHeader.jsp" flush="false" />
		<div class="main">
			<div class="title" style="display : inline-block">레시피 관리</div>
				<div class="btnGroup">
				<form action="recipeQuery" method="post">
					<select name="query" class="query">
						<option value="yname">유튜브명</option>
						<option value="ytitle">유튜브제목</option>
					</select>
					<input type="text" id="search" name="search">
					<input type="submit" value="검색" class="searchBtn">
				</form>
				<a href="adminrecipeRegister"><button class="registerBtn">등록</button></a>
			</div>
			<div class="main_content">
				<div id="result" class="tableContainer">
					<table style="text-align:center;">
						<tr>
							<th>행번호</th>
							<th>유튜버명</th>
							<th>유튜브제목</th>
						</tr>
						<c:set var="cnt" value="${rowNum }" />
						<c:forEach items="${list}" var="dto">
							<tr>
								<td>${rowNum}</td>
								<td>${dto.yname}</td>
								<td>${dto.ytitle}</td>
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
				      <a href="/adminRecipe?page=${paging.page - 1}" class="button">&lt;</a>
				    </c:otherwise>				
				  </c:choose>
				  <!-- 이전버튼 끝 -->
				  
				  <c:forEach begin="${paging.startPage}" end="${paging.endPage}1" var="i" step="1">
				    <c:choose>
				      <c:when test="${i eq paging.page}">
				        <button class="current">${i}</button>
				      </c:when>
				      <c:otherwise>
				        <a href="/adminRecipe?page=${i}" class="button">${i}</a>
				      </c:otherwise>
				    </c:choose>
				  </c:forEach>
				  
				  <!-- 다음버튼 시작 -->
				  <c:choose>
				    <c:when test="${paging.page >= paging.maxPage}">
				      <button disabled>&gt;</button>
				    </c:when>	
				    <c:otherwise>
				      <a href="/adminRecipe?page=${paging.page + 1}" class="button">&gt;</a>
				    </c:otherwise>				
				  </c:choose>
				  <!-- 다음버튼 끝 -->
			</div>

		</div>
		
		<div id="ddd"></div>
	</main>
	
</body>
</html>