
		function updateBrand() {
			
			let form = document.categoryForm;
			let regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;
			let num = 0;
			
			let nullMsg = "브랜드명을 입력하세요.";
			let checkMsg = "특수문자가 포함되어있습니다. 특수문자를 제거해주세요.";
			let regSpan = document.getElementById("reg");
			
			
			
			let bname = form.bname.value;
			
			if(bname == "") {
				regSpan.style.display = "block";
				regSpan.innerText = nullMsg;
				form.bname.select()
				num++;
				return
			} 
			
			if(regExp.test(bname)) {
				regSpan.style.display = "block";
				regSpan.innerText = checkMsg;
				num++;
				return;
			}
			
			if(num == 0 ) {
				
				let form = document.categoryForm;
				form.method="post";
				form.action = "adminBrandUpdate";
				form.submit();
				alert('수정되었습니다.')
			}
		}
				
		function deleteBrand() {
			let form = document.categoryForm;
			form.method="post";
			form.action = "adminBrandDelete";
			form.submit();
		}
		
		function ReDelete(){
			
			if(confirm("계약중으로 상태를 변경하시겠습니까?") == true) {
				let form = document.categoryForm;
				let bname = form.bname.value;
				
				form.method="post";
				form.action = "adminBrandReDelete";
				form.submit();
			} else {
				event.preventDefault(); // 새로고침을 막는 코드
			}
			
		}