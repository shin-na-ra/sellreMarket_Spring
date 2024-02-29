<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- Viewort 설정 부분 -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, viewport-fit=cover">
		
		<!-- 언어 감지 -->
		<meta charset="UTF-8">
		
		<!-- 제목 -->
		<title>구매목록 상세 페이지</title>
		
		<!-- Favicon 설정 부분  -->
		<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
		<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
		<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
		<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
		
		<!-- 외부 CSS -->
		<link rel="preload" href="https://res.kurly.com/_next/static/css/d59287ec5b86dc49.css" as="style"/>
		<link rel="stylesheet" href="https://res.kurly.com/_next/static/css/d59287ec5b86dc49.css" data-n-g=""/>
		<link rel="stylesheet" href="css/purchase/purchaseList.css" />
	</head>
	<body>
		<!-- 헤더 -->
		<jsp:include page="../header.jsp" />
		<div class="mainContent">
			<div class="titleContainer">
				<span class="titleMain">주문목록</span>
			</div>
			<div class="fullListContainer">
				<div class="fullList">
					<!-- 정의 실행 -->				
					<div class="purchaseNumListContainer">
						<div class="purchaseNumListHeadContainer">
							<div class="purchaseDate">
								<!-- 결제 날짜 DAO에서 불러오기 -->
								<fmt:formatDate value="${purchase[0].purchaseDate}" pattern="yy.MM.dd" /> 주문
							</div>
						</div>
						<!-- 반복문 실행 -->
						<c:forEach items="${purchase}" var="info">
							<c:if test="${purchase[0].purchaseId eq info.purchaseId}">
							<div class="purchaseNumListMainContainer">
								<div class="purchaseNumListMainTableCol">
									<div class="purchaseNumListMainContent">									
										<div class="purchaseProductImageArea">
											<div class="purchaseProductImageContainer">
												<!-- 이미지 DAO에서 불러오기 -->
												<img loading="lazy" width="64" height="64" src="image/product/${info.productImage}" alt="이미지.jpg">
											</div>
										</div>
										<div class="purchaseInformationArea">		
											<div class="purchaseNameArea">
												<span color="#111111" class="purchaseName">
													${info.productName}
												</span>
											</div>	
											<div class="purchaseDataSection">																					
												<div class="purchasePriceAndAmountArea">
													<span font-weight="normal" class="purchasePrice">
														<fmt:formatNumber value="${info.purchasePrice}" pattern="#,###" />
													</span>
													<span class="purchaseDataCenterMargin">
														<span class="purchaseDataCenterPoint"></span>
													</span>
													<span class="purchaseAmount">${info.purchaseAmount}개</span>
												</div>	
												<div class="cartButtonContainer">
													<button class="cartButton">장바구니 담기</button>
													<div class="cartButtonBottom"></div>
												</div>												
											</div>													
											<div class="purchaseDataAreaBottom"></div>										
										</div>										
									</div>
								</div>
							</div>
							</c:if>	
						</c:forEach>
						<div class="purchaseNumListBottom"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="contentContainer">
			<div class="contentCenter">
				<h1 class="contentTitle">
					<span>결제 정보</span>
				</h1>
				<table class="contentTable">
					<caption class="contentCaption">결제 정보</caption>
					<colgroup>
						<col width="105">
						<col>
						<col width="100">
					</colgroup>
					<tbody class="customerInformationTbody">
						<tr class="customerInformationTr">
							<th class="customerInformationTitle" style="color: rgb(85, 85, 85);">받는사람</th>
							<td class="customerInformationContent">레슨실</td>
							<td class="customerInformationMargin"></td>
						</tr>
						<tr class="customerInformationTr">
							<th class="customerInformationTitle" style="color: rgb(85, 85, 85);">연락처</th>
							<td class="customerInformationContent">010-9750-2723</td>
							<td class="customerInformationMargin"></td>
						</tr>
						<tr class="customerInformationTr">
							<th class="customerInformationTitle" style="color: rgb(85, 85, 85);">받는주소</th>
							<td class="customerInformationContent">(07025) 서울특별시 동작구 남부순환로271길 18 효준빌딩 옥탑 ( 사당동 )</td>
							<td class="customerInformationMargin"></td>
						</tr>
						<tr class="customerInformationTr">
							<th class="customerInformationTitle" style="color: rgb(85, 85, 85);">배송요청사항</th>
							<td class="customerInformationContent">문 앞</td>
							<td class="customerInformationMargin"></td>
						</tr>
						<tr class="customerInformationTr">
							<th class="customerInformationTitle" style="color: rgb(85, 85, 85);">결제 수단</th>
							<td class="customerInformationContent">BC 카드</td>
							<td class="customerInformationMargin"></td>
						</tr>
						<tr class="customerInformationTr">
							<th class="customerInformationTitle"><strong>총 금액</strong></th>
							<td class="customerInformationContent"><strong>39,800원</strong></td>
							<td class="customerInformationMargin"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>				
		<!-- 풋터  -->
		<jsp:include page="../footer.jsp" flush="false" />
	</body>
</html>