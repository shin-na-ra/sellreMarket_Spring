function updateEvent() {
	let form = document.eventForm;
	let regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;
	let num = 0;
	
	let regSpan1 = document.getElementById("reg1");
	let regSpan2 = document.getElementById("reg2");
	let regSpan3 = document.getElementById("reg3");
	let regSpan4 = document.getElementById("reg4");
	
	let nullMsg1 = "이벤트명을 입력하세요.";
	let nullMsg2 = "이벤트 내용을 입력하세요.";
	let nullMsg3 = "날짜를 입력하세요.";
	let nullMsg4 = "할인율을 입력하세요.";
	
	let checkMsg = "특수문자가 포함되어있습니다. 특수문자를 제거해주세요.";
	
	
	
	let ename = form.ename.value;
	let econtent = form.econtent.value;
	let startdate = form.startdate.value;
	let enddate = form.enddate.value;
	let salerate = form.salerate.value;
	
	if(ename == "") {
		regSpan1.style.display = "block";
		regSpan1.innerText = nullMsg1;
		form.ename.select()
		num++;
		return
	} 
	
	if(regExp.test(ename)) {
		regSpan1.style.display = "block";
		regSpan1.innerText = checkMsg;
		num++;
		return;
	}
	
	if(econtent == "") {
		regSpan2.style.display = "block";
		regSpan2.innerText = nullMsg2;
		form.econtent.select()
		num++;
		return
	} 
	
	if(startdate == "" || enddate == "") {
		regSpan3.style.display = "block";
		regSpan3.innerText = nullMsg3;
		num++;
		return
	} 
	
	if(regExp.test(econtent)) {
		regSpan2.style.display = "block";
		regSpan2.innerText = checkMsg;
		num++;
		return;
	}
	
	
	if(salerate == "") {
		regSpan4.style.display = "block";
		regSpan4.innerText = nullMsg4;
		form.salerate.select()
		num++;
		return
	} 
	
	if(regExp.test(salerate)) {
		regSpan4.style.display = "block";
		regSpan4.innerText = checkMsg;
		num++;
		return;
	}
	
	if(num == 0) {
		let form = document.eventForm;
		alert('수정되었습니다.');
		form.method="post";
		form.action = "adminEventUpdate";
		form.submit();
	}
}
		
function deleteEvent() {
	alert('삭제되었습니다.')
	let form = document.eventForm;
	form.method="post";
	form.action = "adminEventDelete";
	form.submit();
}