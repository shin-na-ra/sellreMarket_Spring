function updateCategory() {
	
	let form = document.categoryForm;
	let regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;
	let num = 0;
	
	let nullMsg = "브랜드명을 입력하세요.";
	let checkMsg = "특수문자가 포함되어있습니다. 특수문자를 제거해주세요.";
	let regSpan = document.getElementById("reg");
	
	
	
	let type = form.type.value;
	let subtype = form.subtype.value;
	
	if(subtype == "") {
		regSpan.style.display = "block";
		regSpan.innerText = nullMsg;
		form.subtype.select()
		num++;
		return
	} 
	

	if(type == "") {
		regSpan.style.display = "block";
		regSpan.innerText = nullMsg;
		form.type.select()
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
	
	if(num == 0 ) {
		
		let form = document.categoryForm;
		alert('수정되었습니다.')
		form.method="post";
		form.action = "adminCategoryUpdate";
		form.submit();
		
	}
}
		
function deleteCategory() {
	alert('삭제되었습니다.')
	let form = document.categoryForm;
	form.method="post";
	form.action = "adminCategoryDelete";
	form.submit();
}

function ChangeStatus() {
	alert('상태변경 되었습니다.')
	let form = document.categoryForm;
	form.method="post";
	form.action = "adminCategoryChangeStatus";
	form.submit();
}