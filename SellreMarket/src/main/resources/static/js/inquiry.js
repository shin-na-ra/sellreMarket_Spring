

document.addEventListener("DOMContentLoaded", function() {
	// 해당하는 <li> 요소를 클릭했을 때 실행
	function getIdOfClickedLI() {
		// 클릭한 <li> 요소의 id
		var id = this.id;
	}

	// 모든 <li> 요소를 선택
	var listItems = document.querySelectorAll("#myList li");

	// <li> 요소에 클릭 이벤트 리스너 추가
	for (var i = 0; i < listItems.length; i++) {
		listItems[i].addEventListener("click", getIdOfClickedLI);
	}
	
});

function inquirywrite() {
	if(document.getElementById("userid").value === "") {
		var result = window.confirm("로그인 후 이용 가능합니다. 로그인 하시겠습니까?")
        if (result === true) {
            window.location.href = 'login';
        }
	}     
    else {
        window.location.href = 'inquiry';
    }
}