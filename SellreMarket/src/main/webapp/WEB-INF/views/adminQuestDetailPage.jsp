<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의답변 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="stylesheet" href="css/adminQuestDetail.css" />
<script src="js/adminQuestDetail.js"></script>
</head>
<body id="body">
	<jsp:include page="adminHeader.jsp" flush="false" />
		<div class="main">
			<div class="title">문의 답변</div>
		
			<form name="categoryForm" method="post">
				<div class="form-group">	
					<c:forEach items="${list}" var="dto">
						
						<!-- 답변이 완료되었을 때 -->
						<c:if test="${dto.status.equals('답변완료')}">
							
							<c:if test="${not empty dto.inimage}">
							    <label for="inimage">첨부이미지</label>
							    <img id="preview" src="${dto.inimage}" style="max-width: 100%; max-height: 200px;">
							</c:if>
							
							<label for="intitle">문의 제목</label>
							<input type="text" id="intitle" name="intitle" value="${dto.intitle }" readonly="readonly" style="background-color: #efefef;">
					
							<label for="incontent">문의 내용</label>
							<textarea id="incontent" name="incontent" rows="8" cols="96" readonly="readonly" style="background-color: #efefef;">${dto.incontent }</textarea>
						
							<label for="insertdate">문의 작성일</label>
							<input type="text" id="insertdate" name="insertdate" value="${dto.insertdate }" readonly="readonly" style=" background-color: #efefef;">
							
							<label for="answer">답변내용 *</label>
							<textarea id="answer" name="answer" rows="8" cols="96" >${dto.answer }</textarea>
							<input type="text" id="inquiryid" name="inquiryid" value="${dto.inquiryid }" hidden="true">
							<input type="submit" class="registerBtn" onclick="registerEvent()" value="답변수정">
						</c:if>
						
						<c:if test="${dto.status.equals('진행중')}">
						
							<c:if test="${not empty dto.inimage}">
							    <label for="inimage">첨부이미지</label>
							    <img id="preview" src="${dto.inimage}" style="max-width: 100%; max-height: 200px;">
							</c:if>

							<label for="intitle">문의 제목</label>
							<input type="text" id="intitle" name="intitle" value="${dto.intitle }" readonly="readonly" style="background-color: #efefef;">
					
							<label for="incontent">문의 내용</label>
							<textarea id="incontent" name="incontent" rows="8" cols="96" readonly="readonly" style="background-color: #efefef;">${dto.incontent }</textarea>
						
							<label for="insertdate">문의 작성일</label>
							<input type="text" id="insertdate" name="insertdate" value="${dto.insertdate }" readonly="readonly"  style="background-color: #efefef;">
							
							<label for="answer">답변내용 *</label>
							<textarea id="answer" name="answer" rows="8" cols="96" >${dto.answer }</textarea>
							<span id="reg" style="color:red; display:none; margin-top:10px;"></span>
							
							<input type="text" id="inquiryid" name="inquiryid" value="${dto.inquiryid }" hidden="true">
							<input type="submit" class="registerBtn" onclick="registerEvent()" value="답변등록">
						</c:if>
					</c:forEach>
					
						
					
				</div>
			</form>
			
	</div>
</body>
</html>