
$(document).ready(function() {

	$("#checkinputbtn").click(function() {
		let userid = $("#userId").val();
		let password = $("#password").val();
		let code = "mypage";

		$.ajax({
			method: "POST",
			url: "mypage",
			data: {
				id: userid,
				password: password,
				code : code
			},
			success: function(response) {
				console.log(response)
				if (response === "false") {
					let message = "비밀번호가 일치하지 않습니다.";
					$("#pwmessage").text(message).css("color", "red");
				}
				else {
					document.checkForm.submit();
				}
			},
		})
		
	});
});