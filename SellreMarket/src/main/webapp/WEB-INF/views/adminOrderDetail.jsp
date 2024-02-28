<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입고요청 - 셀리</title>
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="stylesheet" href="css/adminOrderDetail.css" />
<script src="js/adminOrderDetail.js"></script>
</head>
<body id="body">
	<jsp:include page="adminHeader.jsp" flush="false" />
	<div class="main">
		<div class="title">입고요청</div>
		
			<form name="categoryForm" method="get">
			    <div class="form-group">
			        <c:forEach items="${list}" var="dto">
			        
						<!--  판매종료일 때 -->			        
			            <c:if test="${dto.status.equals('판매종료')}">
			            	<span id="reg" style="color:red; margin-top:10px;">판매종료된 상품입니다.</span>
			                <label for="type">제품명</label>
							<input type="text" id="pname" name="pname" readonly="readonly" value="${dto.pname }" style="background-color: #efefef;">
						
							<label for="subtype">수량 *</label>
							<input type="text" id="rcount" name="rcount" readonly="readonly" value="${dto.rcount }" style="background-color: #efefef;">
						
							<label for="subtype">내용</label>
							<input type="text" id="rcomment" name="rcomment" readonly="readonly" value="${dto.rcomment }"  style="background-color: #efefef;">
							<input type="text" id="productid" name="productid" hidden="true" value="${dto.productid }" >
							
			            </c:if>
			            
			            <!--  판매중일 때-->	
			            <c:if test="${dto.status.equals('판매중')}">
			                 <label for="type">제품명</label>
							<input type="text" id="pname" name="pname" readonly="readonly" value="${dto.pname }" style="background-color: #efefef;">
						
							<label for="subtype">수량 *</label>
							<input type="text" id="rcount" name="rcount" >
							<span id="reg" style="color:red; display:none; margin-top:10px;"></span>
						
							<label for="subtype">내용</label>
							<input type="text" id="rcomment" name="rcomment">
							<input type="text" id="productid" name="productid" hidden="true" value="${dto.productid }" >
							<input type="submit" class="orderBtn" onclick="order()" value="요청">
			            </c:if>
			        </c:forEach>
			    </div>
			</form>
			
	</div>
</body>
</html>