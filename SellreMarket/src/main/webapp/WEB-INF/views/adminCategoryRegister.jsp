<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 등록 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="css/adminCategoryRegister.css" />
<!-- <script src="js/adminCategoryRegister.js"></script> -->
</head>
<script>
	function insertCategory() {
		let form = document.categoryForm;
		let regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;
		let num = 0;
		
		let nullMsg1 = "대분류를 입력하세요.";
		let nullMsg2 = "중분류를 입력하세요.";
		let checkMsg = "특수문자가 포함되어있습니다. 특수문자를 제거해주세요.";
		let regSpan = document.getElementById("reg");
		
		let type = form.type.value;
		let subtype= form.subtype.value;
		
		if(type == "") {
			regSpan.style.display = "block";
			regSpan.innerText = nullMsg1;
			form.type.select()
			num++;
			return
		} 
		
		if(subtype == "") {
			regSpan.style.display = "block";
			regSpan.innerText = nullMsg2;
			form.subtype.select()
			num++;
			return
		} 
		
		if(regExp.test(type)) {
			regSpan.style.display = "block";
			regSpan.innerText = checkMsg;
			num++;
			return;
		}
		
		if(regExp.test(subtype)) {
			regSpan.style.display = "block";
			regSpan.innerText = checkMsg;
			num++;
			return;
		}
		
		if(num == 0) {
			let form = document.categoryForm;
			alert('등록이 되었습니다.');
			form.method="post";
			form.action = "adminCategoryInsert";
			form.submit();
		}	
	}
</script>
<body id="body">
	<jsp:include page="adminHeader.jsp" flush="false" />
		<div class="main">
			<div class="title">카테고리 등록</div>
		
			<form name="categoryForm" method="post">
					
				<div class="form-group">
					<label for="type">대분류 *</label>
					<input type="text" id="type" name="type">
				</div>
				
				<div class="form-group">
					<label for="subtype">중분류 *</label>
					<input type="text" id="subtype" name="subtype">
				</div>
				<input type="submit" class="registerBtn" onclick="insertCategory()" value="등록">
			</form>
				
	</div>
</body>
</html>
		
