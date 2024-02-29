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
		<title>상품 상세페이지</title>
		
		<!-- Favicon 설정 부분  -->
		<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
		<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
		<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
		<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
		
		<!-- 외부 CSS -->
		<link rel="preload" href="https://res.kurly.com/_next/static/css/d59287ec5b86dc49.css" as="style"/>
		<link rel="stylesheet" href="https://res.kurly.com/_next/static/css/d59287ec5b86dc49.css" data-n-g=""/>
		<link rel="stylesheet" href="css/detail/detailPage.css" />
	</head>
<body>
	<!--  
	<script src="js/detailPage.js" />-->
	<jsp:include page="../header.jsp" />
	<c:set var="dto" value="${product[0]}"/>
	<div class="css-n48rgu ex9g78v0">
		<div class="css-16c0d81 e1brqtzw0">
			<main id="product-atf" class="css-1eoy87d e17iylht5">
				<div class="css-5v50l3 e17iylht4">
				<c:forEach items="${product}" var="image">
					<img class="product-image" alt="꼴기.jpg" src="image/${image.productImage}">
				</c:forEach>
				</div>
				<section class="css-1ua1wyk e17iylht3">
					<div class="css-1qy9c46 ezpe9l12">
						<h1 class="css-79gmk3 ezpe9l11">${dto.productName}</h1>
					</div>
					<h2 class="css-abwjr2 e1q8tigr4">
<%-- 						<span class="css-5nirzt e1q8tigr3">${dto.salerate}<!-- -->%</span> --%>
						<span class="css-9pf1ze e1q8tigr2">
						<fmt:formatNumber value="${dto.productPrice}" pattern="#,###" />
						</span>
						<span class="css-1x9cx9j e1q8tigr1">원</span>
					</h2>
<!-- 					<span class="css-1e1rd4p e1q8tigr0"> -->
<!-- 						<span> -->
<%-- 							<fmt:formatNumber value="${dto.productPrice}" pattern="#,###" /> --%>
<!-- 						원 -->
<!-- 						</span> -->
<!-- 					</span> -->
						<ul class="css-iqoq9n e6qx2kx2">
							<li class="css-e6zlnr epzddad2">
								<dt class="css-lytdfk epzddad1">배송</dt>
								<dd class="css-1k8t52o epzddad0">
									<p class="css-c02hqi e6qx2kx1">${dto.deliveryName}</p>
								</dd>
							</li>
							<li class="css-e6zlnr epzddad2">
								<dt class="css-lytdfk epzddad1">판매자</dt>
								<dd class="css-1k8t52o epzddad0">
									<p class="css-c02hqi e6qx2kx1">셀리마켓</p>
								</dd>
							</li>
							<li class="css-e6zlnr epzddad2">
								<dt class="css-lytdfk epzddad1">포장방법</dt>
								<dd class="css-1k8t52o epzddad0">
									<p class="css-c02hqi e6qx2kx1">${dto.productPackType}(${dto.productPackKind} 포장)</p>
									<p class="css-uy94b2 e6qx2kx0">택배배송은 에코 포장이 스티로폼으로 대체됩니다.</p>
								</dd>
							</li>
							<li class="css-e6zlnr epzddad2">
								<dt class="css-lytdfk epzddad1">판매단위</dt>
								<dd class="css-1k8t52o epzddad0">
									<p class="css-c02hqi e6qx2kx1">${dto.productUnitType}</p>	
								</dd>
							</li>
							<li class="css-e6zlnr epzddad2">
								<dt class="css-lytdfk epzddad1">중량/용량</dt>
								<dd class="css-1k8t52o epzddad0">
									<p class="css-c02hqi e6qx2kx1">${dto.productUnitGram}내외 / ${dto.productUnitType}</p>
								</dd>
							</li>
							<li class="css-e6zlnr epzddad2">
								<dt class="css-lytdfk epzddad1">유통기한</dt>
								<dd class="css-1k8t52o epzddad0">
									<p class="css-c02hqi e6qx2kx1">농산물로 별도의 소비기한은 없으나 가급적 빠르게 드시기 바랍니다.</p>
								</dd>
							</li>
							<li class="css-e6zlnr epzddad2">
								<dt class="css-lytdfk epzddad1">안내사항</dt>
								<dd class="css-1k8t52o epzddad0">
									<p class="css-c02hqi e6qx2kx1">${dto.productDescription}
									</p>
								</dd>
							</li>
						</ul>
					    <div class="css-9y0nwt e17iylht0">
							<div class="css-ixlb9s eebc7rx8">									
								<div class="css-yhijln eebc7rx7">
									<span class="css-w1is7v eebc7rx6">총 상품금액 :</span>
									<span class="css-x4cdgl eebc7rx5"></span>
									<span class="css-1jb8hmu eebc7rx4">
										<fmt:formatNumber value="${dto.productPrice}" pattern="#,###" />원
									</span>
								</div>
							</div>			                
						</div>
						<div class="css-1bp09d0 e17iylht1">
							<div class="css-gnxbjx e10vtr1i2">
								<div class="css-14jnwd7 e10vtr1i0">
									<button class="cart-button css-1qirdbn e4nu7ef3" type="button" radius="3">
<%-- 									<c:set var="productName" value="${dto.productName}" /> --%>
									<input type="hidden" value="${dto.productId}" id="productId">
										<span class="css-nytqmg e4nu7ef1">장바구니 담기</span>
									</button>
								</div>
							</div>
						</div>
				</section>
			</main>
		</div>
	</div>
	<jsp:include page="../footer.jsp" flush="false" />
	    <!-- 외부 JavaScript 파일 -->
    <script src="js/detail/productDetailPage.js"></script>    

</body>
</html>