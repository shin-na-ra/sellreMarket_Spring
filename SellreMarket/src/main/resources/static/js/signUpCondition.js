/**
 * 
 */

 function signUpCondition(which) {
	 
	 var url = "";
	 
	 if (which == 1) {
		var url = "http://localhost:8080/signUpCondition1"; 
	 }
	 else if (which == 2) {
		 var url = "http://localhost:8080/signUpCondition2";
	 }
	
	var width = 400;  // 팝업 창의 가로 크기
	var height = 700; // 팝업 창의 세로 크기
	
	// 화면의 가로 중앙 위치 계산
	var left = (window.innerWidth - width) / 2;
	// 화면의 세로 중앙 위치 계산
	var top = (window.innerHeight - height) / 2;
	
	var features = "width=" + width + ", height=" + height + ", left=" + left + ", top=" + top + ", resizable=no, scrollbars=no, toolbar=no, menubar=no";
	window.open(url, "_blank", features);
	
}
 
