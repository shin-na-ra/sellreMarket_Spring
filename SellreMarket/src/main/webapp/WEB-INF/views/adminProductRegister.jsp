<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품등록 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="css/adminProductRegister.css" />
<!-- <script src="js/adminProductRegister.js"></script> -->

<script>

/************************************************************************************************
 * Function : 이미지 선택했을 때 preview에 이미지 넣기 이벤트 
 * @param 	: null
 * @return 	: null
*********************************************************/
$("#image").on("change", function(event) {

    var file = event.target.files[0];

    var reader = new FileReader(); 
    reader.onload = function(e) {

        $("#preview").attr("src", e.target.result);
    }

    reader.readAsDataURL(file);
});

/************************************************************************************************
 * Function : 파일명 체크 함수
 * @param 	: 선택한 파일
 * @return 	: null
************************************************************************************************/
function isImageFile(file) {
    var ext = file.name.split(".").pop().toLowerCase(); // 파일명에서 확장자를 가져온다. 

    return ($.inArray(ext, ["jpg", "jpeg", "gif", "png"]) === -1) ? false : true;
}

/************************************************************************************************
 * Function : 이미지 선택했을 때 preview에 이미지 넣기 함수 
 * @param 	: null
 * @return 	: null
************************************************************************************************/
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('preview').src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	} else {
		document.getElementById('preview').src = "";
	}
}
/************************************************************************************************
 * Function : 대분류 카테고리가 변경 될 떼, 중분류 카테고리가 변경되도록 
 * @param 	: null
 * @return 	: null
************************************************************************************************/
document.addEventListener("DOMContentLoaded", function() {
	  var typeSelect = document.getElementById("type");
	  typeSelect.addEventListener("change", selectSubCategory);
});



/************************************************************************************************
 * Function : 중분류 카테고리 ajax로 조회
 *			  가져온 중분류 카테고리를 <option>태그에 넣고 <select>태그에 집어넣기 
 * @param 	: null
 * @return 	: null
************************************************************************************************/
function selectSubCategory() {
	
	let selectElement = document.getElementById("type"); 						// HTML에서 <select> 요소 가져오기
	let selectedText = selectElement.options[selectElement.selectedIndex].text;	// <select>요소의 selected된 텍스트 가져오기 
	
	$.ajax({
		
		type : "POST",
		url : "selectSubCategory",
		data : {categoryType: selectedText},
		success : function(data){
			
			$("#subtype").val("");

			let option = "";
			
			for (var i = 0; i < data.length; i++) {
				if(i == 0){
					option += "<option value='"+data[i].subtype+"' selected='selected' id='" + data[i].subtype + "'>" + data[i].subtype + "</option>";

				} else {
					option += "<option value='"+data[i].subtype+"'  id='" + data[i].subtype + "'>" + data[i].subtype + "</option>";

				}
			}
			$("#subtype").html(option);
		},
		 error:function(request, status, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
		
	});
}
 
function insertProduct() {
	let form = document.productForm;
	let num = 0;
	
	let file = form.image.value;
	let bname = form.bname.value;
	let pname = form.pname.value;
	let pEngname = form.pEngname.value;
	let pstock = form.pstock.value;
	let origin = form.origin.value;
	let description = form.description.value;
	let price = form.price.value;
	
	if(file == ""){
		alert("이미지를 등록하세요.");
		num++;
		return
	}
	
	if(bname == ""){
		alert("제조사명을 등록하세요.");
		form.bname.select()
		num++;
		return
	}
	
	if(pname == ""){
		alert("제품명을 등록하세요.");
		form.pname.select()
		num++;
		return
	}
	
	if(pEngname == ""){
		alert("영문명을 등록하세요.");
		form.pEngname.select()
		num++;
		return
	}
	
	if(pstock == ""){
		alert("수량을 등록하세요.");
		form.pstock.select()
		num++;
		return
	}
	
	if(origin == ""){
		alert("원산지를 등록하세요.");
		form.origin.select()
		num++;
		return
	}
	
	if(description == ""){
		alert("설명을 등록하세요.");
		form.description.select()
		num++;
		return
	}	
	
	if(price == ""){
		alert("가격을 등록하세요.");
		form.price.select();
		num++;
		return
	}	

	if(num == 0) {
		let form = document.productForm;
		alert('등록이 되었습니다.');
		//form.action = "adminProductInsert";
		form.submit();
	}
}


</script>

</head>
<body>
	<jsp:include page="adminHeader.jsp" flush="false" />
		<div class="main">
			<div class="title">제품 등록</div>
				
			<form id="productForm" action="adminProductInsert" method="post" enctype="multipart/form-data">
				<!-- product_image -->				
					<div class="form-group">
						<label for="image">이미지 *</label>
						 <img id="preview" src="" style="max-width: 100%; max-height: 200px;">
						 <input type="file" id="image" name="image" onchange="readURL(this);" accept="*" multiple="multiple" />
					</div>
					
				<!-- product_image -->
				<!-- product -->
					<div class="form-group1">
						<label for="bname">제조사명 *</label>
						<select id="bname" name="bname">
							<c:forEach items="${brandList}" var="dto">
								<option value="${dto.bname }" id="${dto.bname }">${dto.bname }</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label for="pname">제품명 *</label>
						<input type="text" id="pname" name="pname">
					</div>
					
					<div class="form-group">
						<label for="pEngname">영문명 *</label>
						<input type="text" id="pEngname" name="pEngname">
					</div>
					
					<div class="form-group">
						<label for="allery">알레르기</label>
						<input type="text" id="allery" name="allery">
					</div>
					
					<div class="form-group">
						<label for="nutrition">영양성분</label>
						<input type="text" id="nutrition" name="nutrition">
					</div>
					
					<div class="form-group">
						<label for="pstock">수량 *</label>
						<input type="text" id="pstock" name="pstock">
					</div>
					
					
					<div class="form-group">
						<label for="origin">원산지 *</label>
						<input type="text" id="origin" name="origin">
					</div>
					
					<div class="form-group"> 
						<label for="description">설명 *</label>
						<textarea id="description" name="description"></textarea>
					</div>
				<!-- product -->
				
				
				<!-- price -->				
					<div class="form-group">
						<label for="price">가격 *</label>
						<input type="text" id="price" name="price" oninput="formatNumber(this.value)">
					</div>
				<!-- price -->	
				
				
				<!-- category -->	
					<div class="form-group2">
						<label for="category">카테고리 *</label>
						<select id="type" name="type">
							<c:forEach items="${categoryList}" var="dto">
								<option value="${dto.type }" id="${dto.type }">${dto.type }</option>
							</c:forEach>
						</select>
						
						
						
						<select id="subtype" name="subtype">
							<c:forEach items="${subCategoryList}" var="dto">
								<option value="${dto.subtype }" id="${dto.subtype }">${dto.subtype }</option>
							</c:forEach>
						</select>
					</div>
				<!-- category -->	
				
				<!-- packing -->	
					<div class="form-group1">
						<label for="packtype">포장타입</label>
						<select id="packtype" name="packtype">
							<c:forEach items="${packList}" var="dto">
								<option value="${dto.packtype }" id="${dto.packtype }">${dto.packtype }</option>
							</c:forEach>
						</select>
					</div>
	
					<div class="form-group1">
						<label for="packkind">포장종류</label>
						<select id="packkind" name="packkind">
							<c:forEach items="${pakcKind}" var="dto">
								<option value="${dto.packkind }" id="${dto.packkind }">${dto.packkind }</option>
							</c:forEach>
						</select>
					</div>
				<!-- packing -->
				
				<!-- saleunit -->
					<div class="form-group">
						<label for="utype">판매단위</label>
						<input type="text" id="utype" name="utype">
					</div>
					
					<div class="form-group">
						<label for="ugram">중량</label>
						<input type="text" id="ugram" name="ugram">
					</div>
				<!-- saleunit -->
				
				<!-- delivertype -->
					<div class="form-group1">
						<label for="dname">배송종류</label>
						<select id="dname" name="dname">
							<c:forEach items="${deliveryList}" var="dto">
								<option value="${dto.dname }" id="${dto.dname }">${dto.dname }</option>
							</c:forEach>
						</select>
					</div>
				<!-- delivertype -->	

				<input type="submit" class="registerBtn" onclick="insertProduct()" value="등록">	
			</form>
			
</div>
</body>
</html>
		
