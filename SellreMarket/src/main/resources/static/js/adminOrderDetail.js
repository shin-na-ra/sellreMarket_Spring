document.addEventListener("DOMContentLoaded", function() {
    let form = document.querySelector("form");

    form.addEventListener("keydown", function(event) {
        if (event.key === "Enter") {
            event.preventDefault();
            return false;
        }
    });
});

function order() {
	
	let form = document.categoryForm;
	let regExp = /^\d+$/;
	let num = 0;
	
	let nullMsg = "수량을 입력하세요.";
	let checkMsg = "숫자만 입력하세요.";
	let regSpan = document.getElementById("reg");
	
	let rcount = form.rcount.value;
	
	if(rcount == "") {
		regSpan.style.display = "block";
		regSpan.innerText = nullMsg;
		form.rcount.select()
		num++;
		return
	} 
	
	if(!regExp.test(rcount)) {
		regSpan.style.display = "block";
		regSpan.innerText = checkMsg;
		num++;
		return;
	}
	
	
	if(num == 0 ) {
		let form = document.categoryForm;
		alert('입고요청 되었습니다.')
		form.method="get";
		form.action = "adminOrderInsert";
		form.submit();
		
	}
}