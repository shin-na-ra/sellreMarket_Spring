<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<script src="https://cdn.canvasjs.com/ga/canvasjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<link rel="stylesheet" href="css/adminSales.css" />
<script src="js/adminSales.js"></script>
</head>
<body>
	<main>
	<jsp:include page="adminHeader.jsp" flush="false" />
		<!--  매출현황 차트 시작 -->
		<div class="main">
			<div class="title" style="display : inline-block">매출현황<span class="alarm">오늘 날짜에서 일주일치 확인 가능합니다.</span></div>
			<div class="main_content">
				<canvas id="chartContainer" style="height:400px; width:700px;"></canvas>
			</div>
		</div><!--  매출현황 차트 끝 -->
		
		
		<!--  인기제품 top 5 차트 시작 -->
		<div class="main">
			<div class="title" style="display : inline-block">이 달 인기 제품 TOP5</div>
			<div class="main_content">
				<canvas id="donutContainer" style="height:400px; width:700px;"></canvas>
			</div>
		</div><!--  인기제품 top 5 차트 끝 -->
		
		
		<!--  가입 성비 차트 시작 -->
		<div class="main">
			<div class="title" style="display : inline-block">가입 성비</div>
			<div class="main_content">
				<canvas id="pieContainer" style="height:400px; width:700px;"></canvas>
			</div>
		</div><!--  가입 성비 차트 끝 -->
		
		
		<!-- VVIP 고객 차트 시작-->
		<div class="main">
			<div class="title" style="display : inline-block">많이 주문한 고객(누적)</div>
			<div class="main_content">
				<canvas id="horiContainer" style="height:400px; width:700px;"></canvas>
			</div>
		</div><!-- VVIP 고객 차트 끝 -->
		
	</main>
	
</body>
</html>