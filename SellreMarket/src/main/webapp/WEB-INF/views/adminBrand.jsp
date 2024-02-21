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
			<div class="btnGroup" style="display : inline-block">
				<a href="adminBrandRegister.do"><button class="registerBtn">등록</button></a>
			</div>
			<div class="main_content">
				<div id="result" class="tableContainer">
					<table style="text-align:center;">
						<tr>
							<th>행번호</th>
							<th>브랜드명</th>
						</tr>
						<c:set var="cnt" value="1" />
						<c:forEach items="${list}" var="dto">
							<tr>
								<td><a href="adminBrandDetail?bname=${dto.bname }">${cnt}</a></td>
								<td><a href="adminBrandDetail?bname=${dto.bname }">${dto.bname }</a></td>
							</tr>
							<c:set var="cnt" value="${cnt=cnt+1 }" />
						</c:forEach>
					</table>
				</div> <!-- 테이블 조회 위치 -->
			</div>
			<div id="paging"></div>	<!-- 페이징 조회 위치 -->
		</div>
		
		<div id="ddd"></div>
	</main>
	
</body>
</html>