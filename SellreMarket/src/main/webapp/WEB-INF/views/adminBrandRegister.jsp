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
<link rel="stylesheet" href="css/adminBrandRegister.css" />
<script src="js/adminBrandRegister.js"></script>
</head>
<style>

    
</style>
<script>

</script>
<body id="body">
	<jsp:include page="adminHeader.jsp" flush="false" />
		<div class="main">
			<div class="title">브랜드 등록</div>
		
			<form name="categoryForm">
					
				<div class="form-group">
					<label for="bname">브랜드명 * </label>
					<input type="text" id="bname" name="bname">
				</div>
			</form>
			<input type="submit" class="registerBtn" onclick="insertBrand()" value="등록">
	</div>
</body>
</html>
		
