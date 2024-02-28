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
	 * Function : 정규식 체크 
	 * @param 	: null
	 * @return 	: null
	************************************************************************************************/
	function insertBrand(){
		
		let form = document.categoryForm;
		let regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;
		let num = 0;
		
		let nullMsg = "브랜드명을 입력하세요.";
		let checkMsg = "특수문자가 포함되어있습니다. 특수문자를 제거해주세요.";
		let dupplicateMsg = "이미 존재하는 브랜드입니다.";
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
		
		if(num == 0) {
			let bname = $("#bname").val();
			
			$.ajax({
				
				type : "POST",
				url : "insertBrand",
				data : {
					bname: bname
				},
				success : function(response){
					 if (response == "1") {
						 	alert("브랜드 ["+bname+"]이/가 등록되었습니다.")
						 	window.location.href="adminBrand";
			         } 
			         
			         if(response == "0"){
						regSpan.style.display = "block";
						regSpan.innerText = dupplicateMsg;
						form.bname.select()
					 }
			     },
				 error:function(request, status, error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					console.log(error);
				}
				
			});
		}
	}

