<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 상세 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="css/adminCategoryDetail.css" />
<script src="js/adminCategoryDetail.js"></script>
</head>
<body id="body">
	<jsp:include page="adminHeader.jsp" flush="false" />
		<div class="main">
			<div class="title">카테고리 상세</div>
		
			<form name="categoryForm" method="post">
				<c:forEach items="${list}" var="dto">
				
					<c:if test="${dto.status==0}">
						<label for="type">대분류 *</label>
						<input type="text" id="type" name="type" value="${dto.type }" readonly="readonly" style="background-color: #efefef;">
						
						<label for="subtype">중분류 *</label>
						<input type="text" id="subtype" name="subtype" value="${dto.subtype }"  readonly="readonly" style="background-color: #efefef;">
					 	<span id="reg" style="color:red; display:none; margin-top:10px;"></span>
					 	
						<input type="text" id="catetoryid" name="catetoryid" value="${dto.catetoryid }" hidden="true">
						
						<input type="submit" class="deleteBtn" onclick="ChangeStatus()" value="상태변경">	
					</c:if>
					
					<c:if test="${dto.status==1}">
						<label for="type">대분류 *</label>
						<input type="text" id="type" name="type" value="${dto.type }">
						
						<label for="subtype">중분류 *</label>
						<input type="text" id="subtype" name="subtype" value="${dto.subtype }">
					 	<span id="reg" style="color:red; display:none; margin-top:10px;"></span>
					 	
						<input type="text" id="catetoryid" name="catetoryid" value="${dto.catetoryid }" hidden="true">
						
						<input type="submit" class="updateBtn" onclick="updateCategory()" value="수정">
						<input type="submit" class="deleteBtn" onclick="deleteCategory()" value="삭제">	
					</c:if>
				
				</c:forEach>	
			</form>
		
	</div>
</body>
</html>
		
