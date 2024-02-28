document.addEventListener("DOMContentLoaded", function() {
    let form = document.querySelector("form");

    form.addEventListener("keydown", function(event) {
        if (event.key === "Enter") {
            event.preventDefault();
            return false;
        }
    });
});


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
