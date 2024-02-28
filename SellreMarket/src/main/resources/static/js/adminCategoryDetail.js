document.addEventListener("DOMContentLoaded", function() {
    let form = document.querySelector("form");

    form.addEventListener("keydown", function(event) {
        if (event.key === "Enter") {
            event.preventDefault();
            return false;
        }
    });
});
function updateCategory() {
	
	let form = document.categoryForm;
	let regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;
	
	let nullMsg = "브랜드명을 입력하세요.";
	let checkMsg = "특수문자가 포함되어있습니다. 특수문자를 제거해주세요.";
	let regSpan = document.getElementById("reg");
	
	let type = form.type.value;
	let subtype = form.subtype.value;
	
	alert('수정되었습니다.')
	form.method="post";
	form.action = "adminCategoryUpdate";
	form.submit();
		
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