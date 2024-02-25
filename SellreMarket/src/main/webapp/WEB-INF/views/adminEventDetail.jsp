<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="css/adminEventDetail.css" />
<script src="js/adminEventDetail.js"></script>
</head>
<body id="body">
	<jsp:include page="adminHeader.jsp" flush="false" />
		<div class="main">
			<div class="title">이벤트 상세</div>
		
			<form name="eventForm">
				<c:forEach items="${list}" var="dto">
				
					<c:if test="${dto.status == 0 }">
						<div class="form-group">
							<label for="image">이미지 *</label>
							<img id="preview" src="${dto.img }" style="max-width: 100%; max-height: 200px;">
						</div>
							
						<div class="form-group">
							<label for="ename">이벤트 명 *</label>
							<input type="text" id="ename" name="ename" value="${dto.ename }" readonly="readonly" style="background-color: #efefef">
						</div>
						
						<div class="form-group">
							<label for="econtent">이벤트 내용 *</label>
							<input type="text" id="econtent" name="econtent" value="${dto.econtent }" readonly="readonly" style="background-color: #efefef">
						</div>
						
						<div class="form-group">
							<label for="startdate">이벤트 시작일 *</label>
							<input type="text" id="startdate" name="startdate" value="${dto.startdate }" readonly="readonly" style="background-color: #efefef">
						</div>
						
						<div class="form-group">
							<label for="enddate">이벤트 종료일 *</label>
							<input type="text" id="enddate" name="enddate" value="${dto.enddate }" readonly="readonly" style="background-color: #efefef">
						</div>
						
						<div class="form-group">
							<label for="salerate">할인율(%) *</label>
							<input type="text" id="salerate" name="salerate" style="text-align:right" value="${dto.salerate }" readonly="readonly" style="background-color: #efefef">
						</div>
						<input type="text" id="eventid" name="eventid" hidden="true" value="${dto.eventid }">	
				
					</c:if>
					
					<c:if test="${dto.status == 1 }">
						<div class="form-group">
							<label for="image">이미지 *</label>
							<img id="preview" src="${dto.img }" style="max-width: 100%; max-height: 200px;">
						</div>
							
						<div class="form-group">
							<label for="ename">이벤트 명 *</label>
							<input type="text" id="ename" name="ename" value="${dto.ename }">
							<span id="reg1" style="color:red; display:none; margin-top:10px;"></span>
						</div>
						
						<div class="form-group">
							<label for="econtent">이벤트 내용 *</label>
							<input type="text" id="econtent" name="econtent" value="${dto.econtent }">
							<span id="reg2" style="color:red; display:none; margin-top:10px;"></span>
						</div>
						
						<div class="form-group">
							<label for="startdate">이벤트 시작일 *</label>
							<input type="text" id="startdate" name="startdate" value="${dto.startdate }">
							<span id="reg3" style="color:red; display:none; margin-top:10px;"></span>
						</div>
						
						<div class="form-group">
							<label for="enddate">이벤트 종료일 *</label>
							<input type="text" id="enddate" name="enddate" value="${dto.enddate }">
							<span id="reg3" style="color:red; display:none; margin-top:10px;"></span>
						</div>
						
						<div class="form-group">
							<label for="salerate">할인율(%) *</label>
							<input type="text" id="salerate" name="salerate" style="text-align:right" value="${dto.salerate }">
							<span id="reg4" style="color:red; display:none; margin-top:10px;"></span>
						</div>
						<input type="text" id="eventid" name="eventid" hidden="true" value="${dto.eventid }">	
						<input type="submit" class="updateBtn" onclick="updateEvent()" value="수정">
						<input type="submit" class="deleteBtn" onclick="deleteEvent()" value="삭제">
					</c:if>
			</form>
		</c:forEach>		
	</div>
</body>
</html>
		
