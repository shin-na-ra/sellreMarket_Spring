<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="css/adminProductDetail.css" />
<script src="js/adminProductDetail.js"></script>
</head>
<body id="body">
	<jsp:include page="adminHeader.jsp" flush="false" />
		<div class="main">
			<div class="title">제품 상세</div>
			
			
			<form name="productForm" enctype="multipart/form-data" action="adminProductUpdate" method="post">
				<c:forEach items="${list}" var="item">
				<!-- product_image -->				
					<div class="form-group">
						<label for="image">이미지 *</label>
						<img id="preview" src="" style="max-width: 100%; max-height: 200px;">
						<img class="img-fluid w-100" id="preview1" style="max-width: 100%; max-height: 200px;"
						src="${pageContext.request.contextPath}/image/${item.image}" >
						<input type="text" id="img" name="img" value=${item.image } readonly="readonly"  style="color:white; border:none">
						<input type="file" id="image" name="image" onchange="readURL(this)"; accept="*" multiple="multiple">
					</div>				

				<!-- product_image -->
					
					<!-- brand  start-->
					<div class="form-group2">
						<label for="bname">제조사명 *</label>
						<select id="bname" name="bname">
							<c:forEach items="${brandList}" var="dto">
					 		  <option value="${dto.bname}"<c:if test="${(dto.bname) == (item.bname)}">selected</c:if>>${dto.bname}</option>
							</c:forEach>    
						</select>
					</div>
					<!-- brand  end-->
					
					<!-- product -->
					<div class="form-group">
						<label for="pname">제품명 *</label>
						<input type="text" id="pname" name="pname" value="${item.pname }">
					</div>
					
					<div class="form-group">
						<label for="pEngname">영문명 *</label>
						<input type="text" id="pEngname" name="pEngname" value="${item.pEngname }">
					</div>
					
					<div class="form-group">
						<label for="allery">알레르기</label>
						<input type="text" id="allery" name="allery" value="${item.allery }">
					</div>
					
					<div class="form-group">
						<label for="nutrition">영양성분</label>
						<input type="text" id="nutrition" name="nutrition" value="${item.nutrition }">
					</div>
					
					<div class="form-group">
						<label for="pstock">수량 *</label>
						<input type="text" id="pstock" name="pstock" value="${item.pstock }">
					</div>
					
					
					<div class="form-group">
						<label for="origin">원산지 *</label>
						<input type="text" id="origin" name="origin" value="${item.origin }">
					</div>
					
					<div class="form-group"> 
						<label for="description">설명 *</label>
						<textarea id="description" name="description">${item.description }</textarea>
					</div>
				<!-- product end-->
				
				
				<!-- price -->				
					<div class="form-group">
						<label for="price">가격 *</label>
						<input type="text" id="price" name="price" value="${item.price}">
					</div>
				<!-- price -->	
				
				
				<!-- category -->	
					<div class="form-group2">
						<label for="category">카테고리 *</label>
						<select id="type" name="type">
							<c:forEach items="${categoryList}" var="dto">
								<option value="${dto.type}"<c:if test="${(dto.type) == (item.type)}">selected</c:if>>${dto.type}</option>
							</c:forEach>
						</select>
						
						
						<select id="subtype" name="subtype">
							<c:forEach items="${subCategoryList}" var="dto">
								<option value="${dto.subtype}"<c:if test="${(dto.subtype) == (item.subtype)}">selected</c:if>>${dto.subtype}</option>
							</c:forEach>
						</select>
					</div>
				<!-- category -->	
				
				<!-- packing -->	
					<div class="form-group2">
						<label for="packtype">포장타입</label>
						<select id="packtype" name="packtype">
							<c:forEach items="${packList}" var="dto">
								<option value="${dto.packtype}"<c:if test="${(dto.packtype) == (item.packtype)}">selected</c:if>>${dto.packtype}</option>
							</c:forEach>
						</select>
					</div>
	
					<div class="form-group2">
						<label for="packkind">포장종류</label>
						<select id="packkind" name="packkind">
							<c:forEach items="${pakcKind}" var="dto">
								<option value="${dto.packkind}"<c:if test="${(dto.packkind) == (item.packkind)}">selected</c:if>>${dto.packkind}</option>
							</c:forEach>
						</select>
					</div>
				<!-- packing -->
				
				<!-- saleunit -->
					<div class="form-group">
						<label for="utype">판매단위</label>
						<input type="text" id="utype" name="utype" value="${item.utype }">
					</div>
					
					<div class="form-group">
						<label for="ugram">중량</label>
						<input type="text" id="ugram" name="ugram" value="${item.ugram }">
					</div>
				<!-- saleunit -->
				
				<!-- delivertype -->
					<div class="form-group2">
						<label for="dname">배송종류</label>
						<select id="dname" name="dname">
							<c:forEach items="${deliveryList}" var="dto">
								<option value="${dto.dname}"<c:if test="${(dto.dname) == (item.dname)}">selected</c:if>>${dto.dname}</option>
							</c:forEach>
						</select>
					</div>
				<!-- delivertype -->
					
					<input type="text" id="productid" name="productid" hidden="true" value="${item.productid }">	
				</c:forEach>	
				
				<input type="submit" class="updateBtn" id="updateBtn" onclick="updateProduct()" value="수정">
				<input type="submit" class="deleteBtn" id="deleteBtn" onclick="deleteProduct()" value="삭제">
			</form>
				
	</div>
	
	<!-- <script src="js/adminProductDetail.js"></script> -->
</body>
</html>
		
