<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		<title>구매목록 페이지</title>
		
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
			<div class="searchAndTimelineContainer">
				<div class="searchContainer">
					<div class="searchBox">
						<input placeholder="주문한 상품을 검색할 수 있어요!" class="searchBoxContent" value="">
					</div>
					<div class="magnifierBox">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" style="fill: rgb(52, 106, 255);">
							<g fill="none" fill-rule="evenodd">
								<path fill="#000" fill-opacity="0" d="M0 24L24 24 24 0 0 0z"></path>
								<path fill="#346AFF" fill-rule="nonzero" d="M11 19.5c4.694 0 8.5-3.806 8.5-8.5S15.694 2.5 11 2.5 2.5 6.306 2.5 11s3.806 8.5 8.5 8.5zm0 1c-5.247 0-9.5-4.253-9.5-9.5S5.753 1.5 11 1.5s9.5 4.253 9.5 9.5-4.253 9.5-9.5 9.5zm6.854-3.354l4.5 4.5c.471.472-.236 1.179-.708.708l-4.5-4.5c-.471-.472.236-1.179.708-.708z"></path>
							</g>
						</svg>
					</div>
				</div>
			</div>
<!-- 			<div class="sc-1lv04u3-1 ihglTs"> -->
<!-- 				<div class="sc-py7v18-0 ghaYID"> -->
<!-- 					<div width="72px" class="sc-py7v18-1 dLgQrg">최근 6개월</div> -->
<!-- 					<div class="sc-py7v18-1 krUtDN">2024</div> -->
<!-- 					<div class="sc-py7v18-1 krUtDN">2023</div> -->
<!-- 					<div class="sc-py7v18-1 krUtDN">2022</div> -->
<!-- 					<div class="sc-py7v18-1 krUtDN">2021</div> -->
<!-- 					<div class="sc-py7v18-1 krUtDN">2020</div> -->
<!-- 					<div class="sc-py7v18-1 krUtDN">2019</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="sc-17hglig-0 lddMdG"> -->
<!-- 				<div class="sc-1po2a27-0 bRxIbf"> -->
<!-- 					<div class="sc-1po2a27-1 sc-1po2a27-2 ebMaZa jekmPy">전체</div> -->
<!-- 					<div class="sc-1po2a27-1 ebMaZa">배송상품</div> -->
<!-- 					<div class="sc-1po2a27-1 ebMaZa">여행상품</div> -->
<!-- 					<div class="sc-1po2a27-1 ebMaZa">티켓상품</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

			<div class="fullListContainer">
				<div class="fullList">
					<c:set var="previousPurchaseId" value="" />
					<c:forEach items="${purchase}" var="pur">
					<c:if test="${pur.purchaseId ne previousPurchaseId}">
					<div class="purchaseNumListContainer">
						<div class="purchaseNumListHeadContainer">						
							<div class="purchaseDate">
								<!-- 결제 날짜 DAO에서 불러오기 -->
								
								    <!-- 이 구매의 purchaseId를 이전 구매의 purchaseId로 설정 -->
	        						<c:set var="previousPurchaseId" value="${pur.purchaseId}" />
								    <fmt:formatDate value="${pur.purchaseDate}" pattern="yy.MM.dd" /> 주문
        						
							</div>
							<div class="purchaseDetailGoContainer" data-purchase-id="${pur.purchaseId}">
								<span class="purchaseDetailGoText">주문 상세보기</span>
								<svg width="16" height="16" focusable="false" viewBox="0 0 16 16" aria-hidden="true" 
										 role="presentation" style="fill: rgb(52, 106, 255); vertical-align: middle; height: 100%;">
									<path fill="#346aff" fill-rule="nonzero" 
											   d="M11.057 8L5.53 13.529c-.26.26-.26.682 0 .942.26.26.682.26.942 0l6-6c.26-.26.26-.682 0-.942l-6-6c-.26-.26-.682-.26-.942 0-.26.26-.26.682 0 .942L11.057 8z">
									</path>
								</svg>
							</div>
						</div>
						<!-- 반복문 실행 -->
						<c:forEach items="${purchase}" var="info">
							<c:if test="${pur.purchaseId eq info.purchaseId}">
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
				</c:if>	
				</c:forEach>
				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>				
		<!-- 풋터  -->
		<jsp:include page="../footer.jsp" flush="false" />
		
	    <!-- 외부 JavaScript 파일 -->
    	<script src="js/purchase/purchase.js"></script>    
	</body>
</html>