document.addEventListener("DOMContentLoaded", function() {
    let form = document.querySelector("form");

    form.addEventListener("keydown", function(event) {
        if (event.key === "Enter") {
            event.preventDefault();
            return false;
        }
    });
});


function registerEvent() {
	
	let form = document.categoryForm;
	let regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;
	let num = 0;
	
	let nullMsg = "답변내용을 입력하세요.";
	let checkMsg = "특수문자가 포함되어있습니다. 특수문자를 제거해주세요.";
	let regSpan = document.getElementById("reg");
	
	let answer = form.answer.value
	
	if(answer == ""){
		regSpan.style.display = "block";
		regSpan.innerText = nullMsg;
		form.answer.select()
		num++;
		return
	}
	
	if(num == 0 ) {
		let form = document.categoryForm;
		alert('답변이 등록되었습니다.');
		form.method="post";
		form.action = "adminQuestUpdate";
		form.submit();
	}
}