<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/purchaseProduct.css" />
<body>

	<!-- header Start -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- header End -->
	
	
	<div class="css-1ykiyus e146m4rf2" >
		<div class="css-1uom1od e146m4rf0">
			<h2 class="css-10owlr e146m4rf1">주문완료</h2>
			<hr/>
			<div class="sccessfulOrder" style="font-size: 24px; align-content: center; margin-top: 15px;">
				<p>${id }님의 주문이 완료 되었습니다.</p>
			</div>
			<div class="css-1rz7w0y epvroj91">
				  <div class="css-9i9om4 epvroj90">
					  <hr/>
					  <div class="css-hdnk73 e12lli9y0">
						  <div class="css-1hvttuk eahaaoi12">
						  	  <div class="css-1rmc3ba eahaaoi11">결제금액</div>
							  <div>
								  <span class="css-2pg1ps eahaaoi10" id="discountSum" style="font-weight: bold;">
									  ${finalSum}
								  </span>
								  <span class="css-158icaa eahaaoi8">원</span>
							  </div>
						  </div>
						  <div class="css-1hvttuk eahaaoi12">
						  	  <div class="css-1rmc3ba eahaaoi11">적립금</div>
							  <div>
								  <span class="css-2pg1ps eahaaoi10" id="discountSum" style="color: #808080;">
									  +530
								  </span>
								  <span class="css-158icaa eahaaoi8">원</span>
							  </div>
						  </div>
						</div>
					</div>
				</div>
				<form action="/sccessfulOrder" method="post" id="orderForm">
					<input type="hidden" value="${id}" name="id">
					<input type="hidden" value="${finalSum}" name="finalSum">
					<div class="css-1azakc el0c5j40" style="margin: 40px 20px 0px 0px;">
					  <button class="css-mp" type="button" width="240" height="56" radius="3" onclick="window.location.href='/test'" border="2">
					  	주문 상세보기
					  </button>
					  <button class="css-kesh" type="button" width="240" height="56" radius="3" onclick="window.location.href='/main'" border="2">
					 	쇼핑 계속하기
					  </button>
				  </div>
			  </form>
		</div>
	</div>
	
	<!-- footer Start -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- footer End -->
</body>
</html>