<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
	.parent-container {
	    position: relative;
	}
	
	#cartCount {
	    position: absolute;
	    margin-top: -10px;
	    left: 75.4%;
	    font-weight: bold;
	    background-color: #FFA500;
        text-align: center; /* 텍스트를 수평으로 중앙 정렬합니다 */
	    border-radius: 10px; /* 모서리의 반지름 크기를 조정합니다 */
	    z-index: 9999; /* 다른 요소보다 앞으로 보이도록 z-index 값을 설정합니다 */
	}
</style>


<script type="text/javascript">
//header.jsp
function updateCartCount(cartCount) {
    $("#cartCount").text(cartCount);
}

function inquirywrite() {
	if (document.getElementById("userid1").value === "") {
		var result = window.confirm("로그인 후 이용 가능합니다. 로그인 하시겠습니까?")
		if (result === true) {
			window.location.href = 'login';
		}
	} else {
		window.location.href = 'inquiry';
	}
}
</script>
</head>
<input type="hidden" id="userid1" value="${sessionScope.id}">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="js/category.js" ></script>
<link rel="preload"
	href="https://res.kurly.com/_next/static/css/d59287ec5b86dc49.css"
	as="style" />
<link rel="stylesheet"
	href="https://res.kurly.com/_next/static/css/d59287ec5b86dc49.css"
	data-n-g />
<link rel="stylesheet" href="css/header.css" />
<body>
	<div class="css-16h7nba e1p13h9k3">
		<div class="css-pqw0uk e1p13h9k2">
		<c:choose>
		<c:when test="${sessionScope.id != null }">
			<a href="main" rel="noreferrer" target="_self"
				class="css-129c9b5 e1p13h9k1">
				<div>지금 바로, <b>셀리마켓</b> 가입하세요!</div>
			</a>
		</c:when>
		<c:otherwise>
			<a href="login" rel="noreferrer" target="_self"
				class="css-129c9b5 e1p13h9k1">
				<div>지금 바로, <b>셀리마켓</b> 가입하세요!</div>
			</a>
		</c:otherwise>
		</c:choose>
		</div>
	</div>
	<div>
		<div class="css-t79vuj e15sbxqa2">
			<div class="css-1xfyvd1 eo7pjfk4">
			<c:choose>
				<c:when test="${empty sessionScope.id}">
				<a class="css-xygizb eo7pjfk2" href="signup">회원가입</a>
				<div class="css-1qgm48u eo7pjfk0"></div>
				<a class="css-oyffzd eo7pjfk2" href="login">로그인</a>
				<div class="css-1qgm48u eo7pjfk0"></div>
				</c:when>
				<c:otherwise>
				<div class="css-1qolcqm eo7pjfk3">
					<a class="css-oyffzd eo7pjfk2">${sessionScope.userName} 님<span class="css-1lrerrk eo4j3y50"></span></a>
					<div class="menu css-1ho29iy ecncdj41">
						<div class="css-12olpw6 ecncdj40"><a href="mypageinfo">개인정보 수정</a></div>
						<div class="css-12olpw6 ecncdj40"><a href="#">장바구니</a></div>
						<div class="css-12olpw6 ecncdj40"><a href="#">주문내역</a></div>
						<div class="css-12olpw6 ecncdj40"><a href="#">찜한 상품</a></div>
						<div class="css-12olpw6 ecncdj40"><a href="#">찜한 레시피</a></div>
						<div class="css-12olpw6 ecncdj40"><a href="addresslist">배송지 관리</a></div>
						<div class="css-12olpw6 ecncdj40"><a href="inquiry">1:1 문의</a></div>
						<div class="css-12olpw6 ecncdj40"><a href="logout">로그아웃</a></div>
					</div>
				</div>
				<div class="css-1qgm48u eo7pjfk0"></div>
				</c:otherwise>
				</c:choose>
				<div class="css-1qolcqm eo7pjfk3">
					<a class="css-oyffzd eo7pjfk2">고객센터<span class="css-1lrerrk eo4j3y50"></span></a>
					<div class="menu css-1ho29iy ecncdj41">
						<div class="css-12olpw6 ecncdj40"><a href="notice">공지사항</a></div>
						<div class="css-12olpw6 ecncdj40"><a onclick='inquirywrite()'>1:1 문의</a></div>
						<div class="css-12olpw6 ecncdj40"><a href="user_guide">이용안내</a></div>
					</div>
				</div>
			</div>
			<div class="css-r7wmjj e15sbxqa3">
				<div class="css-boc80u ekdqe1a1">
					<div class="css-boc80u ekdqe1a1">
					<a href="/main"> <img src="image/Sellre.png"
						alt="셀리마켓 로고" class="css-17mnrrx e1s3pt0j0">
						<button class="active css-mxd3pm ekdqe1a0">셀리마켓</button>
					</a>
				</div>
				</div>
				<div class="css-pqw0uk e1493ofl4">
					<div class="css-w444a2 e1493ofl1">
						<input id="gnb_search" placeholder="검색어를 입력해주세요" required=""
							class="css-11ntk83 e1493ofl3" value="">
						<button id="submit" aria-label="submit"
							class="css-ywxmlw e1493ofl0"></button>
					</div>
				</div>
				<div class="css-pqw0uk e15sbxqa1">
					<div class="css-c4pbxv e15sbxqa0">
						<div class=" css-14vnom0 e1n3mt0d1"></div>
						<button class="css-231fw3 etxxzpc0" aria-label="찜하기" type="button"></button>
						<div class="css-ff2aah e14oy6dx2 parent-container">
							<!-- 장바구니 카운트 시작 -->
							<c:if test="${cartCount > 0}">
								<span id="cartCount" style="vertical-align: middle; padding-right: 5px;">${cartCount}</span>
							</c:if>
						    <input type="hidden" value="${cartCount}" id="hiddenCount">
						    <!-- 장바구니 카운트 끝 -->
						    <button class="css-g25h97 e14oy6dx1" aria-label="장바구니" type="button" id="cartButton"></button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="header" class="css-17tqugj e17w4cfr1">
			<div class="css-mlddcv e17w4cfr6">
				<div class="css-0 e17w4cfr3">
					<div id="categorySpan" class="css-axtlq9 eqn756m2">
						<span class="css-1k5gn9s eqn756m1"></span> <span
							class="css-t75x7c eqn756m0">카테고리</span>
						<div id="categoryBar" class="css-taug43 e7s0tnu0"></div>
					</div>
				</div>
				<ul class="css-1887xqd e17w4cfr5">
						<li class="css-59mmhh e17w4cfr4" style="margin-right: 15px;">
							<span class="css-1xyu7j9 e17w4cfr2">
								<c:if test="${headerCategory eq '신상품'}">
									<a href="/main" style="color: #c14a09; font-weight: bold;">신상품</a>
								</c:if>
								<c:if test="${headerCategory ne '신상품'}">
									<a href="/main">신상품</a>
								</c:if>
							</span>
						</li>
						
					<li class="css-59mmhh e17w4cfr4" style="margin-right: 15px;">
						<span class="css-1xyu7j9 e17w4cfr2">
							<c:if test="${headerCategory eq '베스트'}">
								<a href="/bestProduct" style="color: #c14a09; font-weight: bold;">베스트</a>
							</c:if>
							<c:if test="${headerCategory ne '베스트'}">
								<a href="/bestProduct">베스트</a>
							</c:if>
						</span>
					<li class="css-59mmhh e17w4cfr4">
						<span class="css-1xyu7j9 e17w4cfr2">
							<span class="css-1xyu7j9 e17w4cfr2">
							<c:if test="${headerCategory eq '레시피'}">
								<a href="/recipeProduct" style="color: #c14a09; font-weight: bold;">레시피</a>
							</c:if>
							<c:if test="${headerCategory ne '레시피'}">
								<a href="/recipeProduct">레시피</a>
							</c:if>
						</span>						
						</span>
					</li>
				</ul>
				<div class="css-s5xdrg e17w4cfr0">
					<div class="css-dnwaeo e1mmzaxa1">
						<span class="css-1s2o3jp e1mmzaxa0">셀리마켓 </span> 배송안내
					</div>
				</div>
			</div>
		</div>
		<div class="css-1px7x3s e1py5jsz0" hidden=""></div>
	</div>
</body>
</html>