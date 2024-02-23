<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>브랜드 상세 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="css/adminBrandDetail.css" />
<script src="js/adminBrandDetail.js"></script>
</head>
<body id="body">
	<jsp:include page="adminHeader.jsp" flush="false" />
		<div class="main">
			<div class="title">브랜드 상세</div>
		
			<form name="categoryForm" method="post">
			    <div class="form-group">
			        <label for="bname">브랜드명</label>
			        <c:forEach items="${list}" var="dto">
			            <c:if test="${dto.status == 0}">
			                <input type="text" id="bname" name="bname" value="${dto.bname}" readonly="readonly" style="background-color:#efefef;">
			                <input type="text" id="oldBname" name="oldBname" value="${dto.bname}" hidden="true" style="background-color:#efefef;">
			                <input type="submit" class="deleteBtn" onclick="ReDelete()" value="상태변경" >
			            </c:if>
			            <c:if test="${dto.status == 1}">
			                <input type="text" id="bname" name="bname" value="${dto.bname}">
			                <input type="text" id="oldBname" name="oldBname" value="${dto.bname}" hidden="true">
			                <input type="submit" class="updateBtn" onclick="updateBrand()" value="수정">
			                <input type="submit" class="deleteBtn" onclick="deleteBrand()" value="삭제">
			                
			            </c:if>
			            <span id="reg" style="color:red; display:none; margin-top:10px;"></span>
			        </c:forEach>
			    </div>
			</form>
			
	</div>
</body>
</html>
		
