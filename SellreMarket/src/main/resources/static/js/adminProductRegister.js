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

