<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송지 추가 - 셀리마켓</title>
</head>
<link rel="stylesheet" href="css/findid.css" />
<script src="js/address.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function() {
		
		let checkbox = document.getElementById("defaultsetbox");
		let defaultset = document.getElementById("defaultset");
		
	    checkbox.addEventListener("change", function() {
	        if (checkbox.checked) {
	            defaultset.value = "1"; // 체크 되어있을 때 "1"로 설정
	            console.log("value : 1");
	        } else {
	            defaultset.value = "0"; // 체크 해제 되어있을 때 "0"으로 설정
	            console.log("value : 0");
	        }
	    });
	});
		
	function check() {
		let form = document.getElementById("addressForm");
		
		if(form.address.value === "") {
			alert("주소를 검색해 주세요.")
			return;
		}
		
		if(form.detailAddress.value === "") {
			alert("상세주소를 입력해 주세요")
			form.detailaddress.selecte();
			return;
		}
	
		form.submit();
	}
	
</script>
<body>
	<jsp:include page="header.jsp" />
	<div class="css-140915z e13dlrpy2">
		<div class="css-7500ra e13dlrpy0">배송지 추가</div>
		<div class="css-u3y03b e13dlrpy1">
			<form id="addressForm" class="css-s3iz85 e1h5g482" action="addresslistInsert" method="POST">
			<input type="hidden" name="addressid" value="">
				<div class="css-1blp8ou e1h5g481">
					<div class="css-1yjqrpx e1uzxhvi6">
						<div class="css-176lya2 e1uzxhvi3">
							<input type="hidden" name="defaultset" id="defaultset" value="0">
							<input type="checkbox" name="defaultsetbox" id="defaultsetbox">
							<label for="defaultset" class="css-c3g9of e1uzxhvi4">기본 배송지 설정</label>
						</div>
					</div>
				</div>
				<div class="css-1blp8ou e1h5g481">
					<div class="css-1yjqrpx e1uzxhvi6">
						<label for="address" class="css-c3g9of e1uzxhvi4">주소</label>
						<div class="css-176lya2 e1uzxhvi3">
							<input data-testid="input-box" id="address" name="address"
								placeholder="주소" type="text" class="css-u52dqk e1uzxhvi2"
								value="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="css-1blp8ou e1h5g481">
					<input type="hidden" id="postcode">
					<div class="css-1yjqrpx e1uzxhvi6">
						<label for="email" class="css-c3g9of e1uzxhvi4">상세주소</label>
						<div class="css-176lya2 e1uzxhvi3">
							<input data-testid="input-box" id="detailAddress"
								name="detailAddress" placeholder="상세주소를 입력해 주세요." type="text"
								class="css-u52dqk e1uzxhvi2" value="">
						</div>
					</div>
					<button class="css-1s9rhb5 e4nu7ef3" type="button" height="44"
						radius="4" onclick="execDaumPostcode()"
						style="padding-right: 0px;">
						<span class="css-nytqmgq e4nu7ef1" style="margin-top: 5px;">주소 검색</span>
					</button>
				</div>
				<div class="css-3vxi16 e1h5g480">
					<button class="css-1s9rhb5 e4nu7ef3" type="button" radius="4" onclick="check()">
						<span class="css-nytqmg e4nu7ef1">확인</span>
					</button>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>