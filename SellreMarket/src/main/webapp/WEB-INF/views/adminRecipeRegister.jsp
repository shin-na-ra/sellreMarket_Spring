<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 등록 - 셀리</title>
<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- <link rel="stylesheet" href="css/adminProductRegister.css" /> -->
<!-- <script src="js/adminProductRegister.js"></script> -->
<style>
 @font-face {
    font-family: 'SCoreDream';
    font-weight: 200; 
    font-style: normal; 
    src: url(https://cdn.jsdelivr.net/gh/webfontworld/SCoreDream/SCoreDream1.woff2) format('woff2'),
         url(https://cdn.jsdelivr.net/gh/webfontworld/SCoreDream/SCoreDream1.woff) format('woff');
    font-display: swap;
}

@font-face {
    font-family: 'SCoreDream';
    font-weight: 300; 
    font-style: normal; 
    src: url(https://cdn.jsdelivr.net/gh/webfontworld/SCoreDream/SCoreDream3.woff2) format('woff2'),
         url(https://cdn.jsdelivr.net/gh/webfontworld/SCoreDream/SCoreDream3.woff) format('woff');
    font-display: swap;
}

* {
	font-family: 'SCoreDream';
	
}
 
 body {
 	overflow-x: hidden;
 }
 

.title {
	width:80%;
	margin-left:20px;
	align-items: left;
	font-size: 27px; /* 제목의 글꼴 크기 조정 */
	font-weight: 700; /* 제목의 글꼴 굵기 조정 */
	color: #333333; /* 제목의 글꼴 색상 조정 */
	margin-top: 100px; /* 제목의 상단 여백 조정 */
	padding-left: 20px; /* 제목의 왼쪽 여백 조정 */
	border-left: 2px solid #333333; /* 왼쪽 테두리 설정 */
	margin-bottom: 50px;
	
}
	
	
body {
    margin: 0;
    padding: 0;
    overflow-x: hidden;
}

	
	
.main {
  display: flex;
  /* justify-content: center; */
  height: 1700px;
  flex-direction: column;
  align-items: center;
  background-color: #fff;
  padding: 20px;
  border-radius: 5px;
  margin-top : 100px;
  margin-bottom : 50px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
	
form {
  width: 80%;
  max-width: 700px; 
}
   
    .form-group {
      margin-bottom: 25px;
    }
    
    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }
    
    input[type="text"],
    input[type="file"],
    textarea {
      width: 100%;
      padding: 8px;
      border-radius: 3px;
      border: 1px solid #ccc;
    }
    
    input[type="checkbox"] {
      margin-right: 5px;
    }
    
    .form-group input[type="date"] {
		padding: 5px;
		border: 1px solid #ccc;
		border-radius: 4px;
		font-size: 14px;
	}
    
    
    .registerBtn {
      padding: 10px 20px;
      background-color: #E5E5D1;
      color: #6F6F67;
      border: none;
      border-radius: 3px;
      font-size: 16px;
      cursor: pointer;
      margin-top: 50px;
      margin-bottom: 200px;
      width: 100%;
    }
    
    .registerBtn:hover {
      background-color: #DADAC8;
      color : black;
    }
    
    
    
    .form-group1 {
	  display: flex;
	  flex-direction: column;
	  margin-bottom: 25px;
	}
	
	.form-group1 label {
	  font-weight: bold;
	}
	
	.form-group1 input,
	.form-group1 select {
	  padding: 5px;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  font-size: 14px;
	}
	
	.form-group1 select {
	  height: 30px;
	}
	
	
	.form-group2 {
	  display: flex;
	  flex-direction: row;
	  align-items: center;
	  margin-bottom: 25px;
	}
	
	.form-group2 label {
	  font-weight: bold;
	  margin-right: 15px;
	}
	
	.form-group2 select {
	  padding: 5px;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  font-size: 14px;
	  height: 30px;
	  width: 150px; /* 원하는 너비로 조정해주세요 */
	  margin-right: 5px;
	}
	
   

</style>
<script>
document.addEventListener("DOMContentLoaded", function() {
    let form = document.querySelector("form");

    form.addEventListener("keydown", function(event) {
        if (event.key === "Enter") {
            event.preventDefault();
            return false;
        }
    });
});
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
				option += "<option value='"+data[i].subtype+"' id='" + data[i].subtype + "'>" + data[i].subtype + "</option>";
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
	
	let ysrc = form.ysrc.value;
	let yname = form.yname.value;
	let ytitle = form.ytitle.value;
	let rcontent = form.rcontent.value;
	let product = $("#addedProduct").val();
	
	if(ysrc == ""){
		alert("이미지를 등록하세요.");
		num++;
		return
	}
	
	if(yname == ""){
		alert("유튜브명을 등록하세요.");
		form.yname.select()
		num++;
		return
	}
	
	if(ytitle == ""){
		alert("제목을 등록하세요.");
		form.ytitle.select()
		num++;
		return
	}
	
	if(rcontent == ""){
		alert("설명을 등록하세요.");
		form.rcontent.select()
		num++;
		return
	}

	alert('등록이 되었습니다.');
	form.method = 'post';
	form.action = "adminRecipeInsert";
	form.submit();
}

 /************************************************************************************************
  * Function : 대분류, 중분류 카테고리 가지고 제품 전부 가져오기 
  *			  가져온 중분류 카테고리를 <option>태그에 넣고 <select>태그에 집어넣기 
  * @param 	: null
  * @return 	: null
 ************************************************************************************************/
 
 
function searchProduct() {
		
	let selectElement = document.getElementById("type"); 						// HTML에서 <select> 요소 가져오기
	let selectedText = selectElement.options[selectElement.selectedIndex].text;	// <select>요소의 selected된 텍스트 가져오기 
	
	let selectSubElement = document.getElementById("subtype"); 						// HTML에서 <select> 요소 가져오기
	let selectedSubText = selectSubElement.options[selectSubElement.selectedIndex].text;	// <select>요소의 selected된 텍스트 가져오기 
	
	$.ajax({
		
		type : "Post",
		url : "searchForProduct",
		data : {
					type : selectedText,
					subtype : selectedSubText
				},
				
		success : function(data){
		
			$("#product").html("");
			
			let label = "<label>";
			

			for (var i = 0; i < data.length; i++) {
			    if (i == 0) {
			        label += "<label><input type='checkbox' name='selectedProducts' checked='checked' value='" + data[i].productid + "'> " + data[i].pname + "</label>";
			    } else {
			        label += "<label><input type='checkbox' name='selectedProducts' value='" + data[i].productid + "'> " + data[i].pname + "</label>";
			    }
			}
			
			  $("#product").html(label); 
			  
			  $("#product input[type='checkbox']").change(function() {
				  $("#desc").css("display", "block");
	                if ($(this).is(":checked")) {
	                    var productId = $(this).val();
	                    var productName = $(this).parent().text().trim();
	                    var addedProductHtml = "<label><input type='checkbox' name='selectedProducts' value='" + productId + "' checked='checked'> " + productName + "</label>";
	                    $("#addedProduct").append(addedProductHtml);
	                } else {
	                    var value = $(this).val();
	                    $("#addedProduct input[value='" + value + "']").parent().remove();
	                }
	            });


			
			console.log("test");
			  //event.preventDefault(); // 페이지 새로고침을 막기 위해 preventDefault() 메서드 사용
		},
		 error:function(request, status, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
		
	});
	
}

</script>
</head>
<body>
	<jsp:include page="adminHeader.jsp" flush="false" />
	<div class="main">
		<div class="title">레시피 등록</div>
			
		<form id="productForm" name="productForm" enctype="multipart/form-data">
		
			
			<!-- product_image -->				
			<div class="form-group">
				<label for="image">유튜브썸네일 *</label>
				<img id="preview" src="" style="max-width: 100%; max-height: 200px;">
				<input type="file" id="ysrc" name="ysrc" onchange="readURL(this);" accept="*" multiple="multiple" />
			</div>
				
			<!-- product_image -->
			<!-- product -->
			<div class="form-group1">
				<label for="bname">유튜버명 *</label>
				<input type="text" id="yname" name="yname" /> 
			</div>
					
			<div class="form-group">
				<label for="pname">유튜브 제목 *</label>
				<input type="text" id="ytitle" name="ytitle">
			</div>
					
			<div class="form-group">
				<label for="pname">설명 *</label>
				<input type="text" id="rcontent" name="rcontent">
			</div>
					
			<div class="form-group2">
				<label for="pname" style="margin-top:10px;">레시피 제품선택 *</label> <br>
			</div>	
					
			<div class="form-group2">
				<label for="category">카테고리 선택 :</label> <br>
				<select id="type" name="type">
					<c:forEach items="${categoryList}" var="dto">
						<option value="${dto.type}" id="${dto.type}">${dto.type}</option>
					</c:forEach>
				</select>
				<select id="subtype" name="subtype">
					<c:forEach items="${subCategoryList}" var="dto">
						<option value="${dto.subtype}" id="${dto.subtype}">${dto.subtype}</option>
					</c:forEach>
				</select>
				<input type="button" class="searchBtn" onclick="searchProduct()" value="검색">
			</div>
					
			<div id="product"></div>
					
			<!-- <label for="add" style="margin-top:20px;">선택한 제품</label> -->
			<div id="addedProduct" style="background-color: #f9f9e4">
				<label for="add"  id="desc" style="margin-top:20px; display:none;">선택한 제품</label>
			</div>	
			<input type="submit" class="registerBtn" onclick="insertProduct()" value="레시피 등록">		
			</form>
		</div>
</body>
</html>
		
