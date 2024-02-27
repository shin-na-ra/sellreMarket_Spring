
	function insertCheck() {
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
			alert('등록이 되었습니다.');
			form.method="post";
			form.action = "adminEventInsert";
			form.submit();
		}
	}
	
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