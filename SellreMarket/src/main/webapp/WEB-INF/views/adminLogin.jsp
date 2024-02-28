<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인 - 셀리</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/login.css" />
</head>
<!-- <script src="js/Login.js"></script> -->
<script>

//왜 form으로 데이터를 넘길 수 없는가? 그래서 ajax 사용
function checkId() {
	
	var id = document.getElementById('id').value;
	var password = document.getElementById('password').value;
	
	$.ajax({
		type:'POST',
		url: 'adminLoginCheck',
		data: {
			id:id,
			password:password
		},
		// 아이디 비밀번호가 일치하면 success로 받아와 이동한다.
		success: function(response) {
			if (response !== "false") {
				window.location.href = 'adminProduct';
			}
			else {
				$('#message').text("아이디와 비밀번호를 확인해주세요.").css('color', 'red');
			}
		}
	});
}

</script>

<body>
	<!-- footer start -->
		<jsp:include page="header.jsp"/>
	<!-- footer end -->
	<div class="css-1bb6q2p etkckst2">
		<div class="css-a7gihu etkckst1">관리자 로그인</div>
		<div class="css-1axolzg etkckst0">
			<form id="myForm" method="post">
				<div class="css-46b038 e18ap6t76">
					<div class="css-1accgqb e1uzxhvi6">
						<div class="css-176lya2 e1uzxhvi3">
							<input id="id"
								placeholder="아이디를 입력해주세요" type="text"
								class="css-u52dqk e1uzxhvi2">
						</div>
					</div>
					<div class="css-1accgqb e1uzxhvi6">
						<div class="css-176lya2 e1uzxhvi3">
							<input id="password"
								placeholder="비밀번호를 입력해주세요" type="password"
								class="css-u52dqk e1uzxhvi2">
						</div>
					</div>
					<span id="message"></span>
				</div>
				<div class="css-s4i9n2 e18ap6t71">
					<button class="css-qaxuc4 e4nu7ef3" type="button" height="54" radius="3" onclick="checkId()">
						<span class="css-nytqmg e4nu7ef1">로그인</span>
					</button>
				</div>
			</form>
		</div>
	</div>
	
	
	<!-- footer start -->
	<jsp:include page="footer.jsp"/>
	<!-- footer end -->
</body>
</html>