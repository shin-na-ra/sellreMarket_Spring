<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 등록 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="css/adminEventRegister.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/adminEventRegister.js"></script>
</head>
<body id="body">
	<jsp:include page="adminHeader.jsp" flush="false" />
		<div class="main">
			<div class="title">이벤트 등록</div>
			
			<form id="eventForm" action="adminEventInsert" method="post" enctype="multipart/form-data">
				<!-- product_image -->				
					<div class="form-group">
						<label for="image">이미지 *</label>
						 <img id="preview" src="" style="max-width: 100%; max-height: 200px;">
						 <input type="file" id="image" name="image" onchange="readURL(this);" accept="*" multiple="multiple" />
					</div>
					
				<div class="form-group">
					<label for="ename">이벤트 명 *</label>
					<input type="text" id="ename" name="ename">
					<span id="reg1" style="color:red; display:none; margin-top:10px;"></span>
				</div>
				
				<div class="form-group">
					<label for="econtent">이벤트 내용 *</label>
					<input type="text" id="econtent" name="econtent">
					<span id="reg2" style="color:red; display:none; margin-top:10px;"></span>
				</div>
				
				<div class="form-group">
					<label for="startdate">이벤트 시작일 *</label>
					<input type="date" id="startdate" name="startdate">
					<span id="reg3" style="color:red; display:none; margin-top:10px;"></span>
				</div>
				
				<div class="form-group">
					<label for="enddate">이벤트 종료일 *</label>
					<input type="date" id="enddate" name="enddate">
					<span id="reg3" style="color:red; display:none; margin-top:10px;"></span>
				</div>
				
				<div class="form-group">
					<label for="salerate">할인율(%) *</label>
					<input type="text" id="salerate" name="salerate" style="text-align:right">
					<span id="reg4" style="color:red; display:none; margin-top:10px;"></span>
				</div>
				
				<div class="form-group">
					<label for="salerate">이벤트 제품 *</label>
						<select id="pname" name="pname">
							<c:forEach items="${list}" var="dto">
								<option value="${dto.productid }" id="${dto.productid }">${dto.pname }</option>
							</c:forEach>
						</select>
					<span id="reg4" style="color:red; display:none; margin-top:10px;"></span>
				</div>
			<input type="submit" class="registerBtn" value="등록">
		</form>
	</div>
</body>
</html>