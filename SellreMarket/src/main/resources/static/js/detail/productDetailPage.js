	// 검색창에서 입력 후 검색 버튼을 누를 때
	$('.cart-button').click(function(){
    var sendValue = $("#productId").val(); // JavaScript 변수에 할당됩니다.
      
	if (document.getElementById("userid1").value === "") {
		var result = window.confirm("로그인 후 이용 가능합니다. 로그인 하시겠습니까?")
		if (result === true) {
			window.location.href = 'login';
		}		
		return			
	}
      
    // 가져온 값이 올바르게 할당되었는지 확인하기 위해 콘솔에 출력합니다.
    console.log('서버에서 가져온 값: ' + sendValue);
    
    // sendValue가 null이거나 빈 문자열인 경우 실패 알람을 띄웁니다.
    if (sendValue === null || sendValue.trim() === '') {
        alert('장바구니 담기에 실패했습니다.');
    } else {
        // sendValue가 유효한 경우 다른 주소로 이동합니다.
        alert('장바구니에 담겼습니다.');
        var firstUrl = "cartProductInput?sendValue=" + sendValue; // 첫 번째 주소를 지정합니다.
        console.log('첫 번째 주소: ' + firstUrl);
        window.location.href = firstUrl;
        }
        	    
	});