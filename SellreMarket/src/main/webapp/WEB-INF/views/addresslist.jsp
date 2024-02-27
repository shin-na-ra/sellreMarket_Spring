<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송지 관리 - 셀리마켓</title>
</head>
<link rel="stylesheet" href="css/individualInquiry.css" />
<link rel="stylesheet" href="css/notice.css" />
<link rel="stylesheet" href="css/addresslist.css" />
<body>
	<jsp:include page="header.jsp" />
	<div class="css-luwwab eug5r8l1">
		<jsp:include page="mypagemenubar.jsp" />
		<div class="css-171zbec eug5r8l0">
			<div class="css-171zbec e1nlszg00">
				<div class="css-jdmlr9 e1af7ryb7">
					<div class="css-tq074a e1af7ryb6">
						<div class="css-fhxb3m e1af7ryb4">
							<span class="css-1268zpe e1af7ryb5">배송지 관리</span><span
								class="css-a3vgo2 e1af7ryb3">배송지에 따라 상품정보 및 배송유형이 달라질 수
								있습니다.</span>
						</div>
						<div>
							<div class="css-1es6ihh e1af7ryb2">
								<div class="css-1xhquvz e1a9f8h00"
									style="margin-top: 20px; margin-bottom: 20px;">
									<button class="css-1bqw8am e4nu7ef3" type="button" height="60" onclick="window.location.href='addresslistAdd'">
										<span class="css-nytqmg e4nu7ef1"><img
											src="https://res.kurly.com/pc/ico/2006/ico_add_16x16.svg"
											alt="" class="css-1m3kac1 e4nu7ef0">새 배송지 추가</span>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="css-1jdq78j e1cucsfi1">
					<div class="css-wru9pk e1cucsfi0"></div>
					<div class="css-3fr0n1 e1cucsfi0">주소</div>
					<div class="css-1aqlhfo e1cucsfi0">연락처</div>
					<div class="css-gtglzf e1cucsfi0"></div>
					<div class="css-wru9pk e1cucsfi0">수정</div>
				</div>
				<ul class="css-1fttcpj erme1rh2">
					<c:forEach items="${addresslist}" var="address">
						<li class="css-d35zkp erme1rh1"><div
								style="margin-bottom: 20px;">
								<c:choose>
									<c:when
										test="${address.defaultset ne null and address.defaultset eq 1}">
										<div class="eeocvzp4 css-8xfsdg e19svclq0">
											<div style="margin-left: 10px;">
												<div class="css-1b3iimx eeocvzp0">기본 배송지</div>
												${address.address} ${address.detailaddress}
											</div>
										</div>
									</c:when>
									<c:otherwise>
										<div class="eeocvzp4 css-8xfsdg e19svclq0">
											<div style="margin-left: 10px;">${address.address}
												${address.detailaddress}</div>
										</div>
									</c:otherwise>
								</c:choose>
								<div class="eeocvzp3 css-xkreku e19svclq0">${address.tel}</div>
								<div class="eeocvzp2 css-1o9d8vk e19svclq0"></div>
								<div class="eeocvzp1 css-1bs5q0a e19svclq0">
								<form action="addresslistUpdatePage" method="POST">
								<input type="hidden" name="addressid" id="addressid" value="${address.addressid}">
									<button type="submit">
										<svg width="24" height="24" viewBox="0 0 24 24"
											xmlns="http://www.w3.org/2000/svg">
										<g fill="none" fill-rule="evenodd">
										<path fill="none" d="M0 0h24v24H0z"></path>
										<path
												d="m13.83 5.777 4.393 4.393-10.58 10.58H3.25v-4.394l10.58-10.58zm3.204-2.527c.418 0 .837.16 1.157.48l2.08 2.08a1.63 1.63 0 0 1 0 2.314l-2.157 2.156-4.394-4.394 2.157-2.156c.32-.32.738-.48 1.157-.48z"
												stroke="#ccc" stroke-width="1.5"></path></g></svg>
									</button>
								</form>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>