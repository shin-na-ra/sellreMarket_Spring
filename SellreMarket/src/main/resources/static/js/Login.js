
// 왜 form으로 데이터를 넘길 수 없는가? 그래서 ajax 사용
function checkId() {
	
	var id = document.getElementById('id').value;
	var password = document.getElementById('password').value;
	
	$.ajax({
		type:'POST',
		url: 'loginCheck',
		data: {
			id:id,
			password:password
		},
		// 아이디 비밀번호가 일치하면 success로 받아와 이동한다.
		success: function(response) {
			if (response !== "false") {
				window.location.href = 'notice';
			}
			else {
				$('#message').text("아이디와 비밀번호를 확인해주세요.").css('color', 'red');
			}
		}
	});
}
