/**
 * 
 */

function payMethod(method) {
	var kakao = document.getElementById('kakao');
	var credit = document.getElementById('credit');
	var phone = document.getElementById('phone');
	var payMethod = document.getElementById('payMethod');
	
	
	if (method == kakao) {
		var list = [credit, phone];
	  	method.style.backgroundColor = 'rgb(249, 249, 228)';
	  	method.style.borderTopColor = 'rgb(249, 249, 228)';
	  	method.style.borderRightColor = 'rgb(249, 249, 228)';
	  	method.style.borderBottomColor = 'rgb(249, 249, 228)';
	  	method.style.borderLeftColor = 'rgb(249, 249, 228)';
	  	payMethod.value = "1";
	  	
	  	for(var i=0; i<list.length; i++) {
			 list[i].style.backgroundColor = 'rgb(255, 255, 255)';
			 list[i].style.borderTopColor = 'rgb(249, 249, 228)';
			 list[i].style.borderRightColor = 'rgb(249, 249, 228)';
			 list[i].style.borderBottomColor = 'rgb(249, 249, 228)';
			 list[i].style.borderLeftColor = 'rgb(249, 249, 228)';
		  }
  	}
  	if (method == credit) {
		var list = [kakao, phone];
	  	method.style.backgroundColor = 'rgb(249, 249, 228)';
	  	method.style.borderTopColor = 'rgb(249, 249, 228)';
	  	method.style.borderRightColor = 'rgb(249, 249, 228)';
	  	method.style.borderBottomColor = 'rgb(249, 249, 228)';
	  	method.style.borderLeftColor = 'rgb(249, 249, 228)';
	  	
	  	for(var i=0; i<list.length; i++) {
			 list[i].style.backgroundColor = 'rgb(255, 255, 255)';
			 list[i].style.borderTopColor = 'rgb(249, 249, 228)';
			 list[i].style.borderRightColor = 'rgb(249, 249, 228)';
			 list[i].style.borderBottomColor = 'rgb(249, 249, 228)';
			 list[i].style.borderLeftColor = 'rgb(249, 249, 228)';
		  }
	    payMethod.value = "2";
  	}
  	
  	if (method == phone) {
		var list = [kakao, credit];
	  	method.style.backgroundColor = 'rgb(249, 249, 228)';
	  	method.style.borderTopColor = 'rgb(249, 249, 228)';
	  	method.style.borderRightColor = 'rgb(249, 249, 228)';
	  	method.style.borderBottomColor = 'rgb(249, 249, 228)';
	  	method.style.borderLeftColor = 'rgb(249, 249, 228)';
	  	
	  	for(var i=0; i<list.length; i++) {
			 list[i].style.backgroundColor = 'rgb(255, 255, 255)';
			 list[i].style.borderTopColor = 'rgb(249, 249, 228)';
			 list[i].style.borderRightColor = 'rgb(249, 249, 228)';
			 list[i].style.borderBottomColor = 'rgb(249, 249, 228)';
			 list[i].style.borderLeftColor = 'rgb(249, 249, 228)';
		  }
		
		payMethod.value = "3";
  	}
}


function updateCharacterCount(textarea) {
    var characterCount = textarea.value.length;
    document.getElementById('character-count').innerText = characterCount;
}

function changeAddress() {
	var check = confirm("장바구니로 이동하여 다른 배송지로 변경하시겠습니까?");
	var changeAddressElement = document.getElementById('changeAddress');
	
	if (check == true) {
		
		// Change font size after redirection
        if (changeAddressElement) {
            changeAddressElement.style.fontSize = "16px";
        }
		window.location.href = "/cart";
	}
	else window.close();
}

function confirmPurchase() {
	var form = document.getElementById('orderForm');
	var con = confirm("구매를 완료하시겠습니까?");
	var payMethod = document.getElementById('payMethod');
			
	
	// Check if a payment method is selected
    if (payMethod.value === "") {
        alert("결제 수단을 선택하세요."); // Display an alert if no payment method is selected
        
        // get focus 
        var elementWithFocus = document.querySelector(".css-ln1csn");
	    if (elementWithFocus) {
	        elementWithFocus.focus();
	    }
        return;
    }
    else{
		if(con) {
			form.submit();
		}
		else window.close();
	}
}
 
function deliveryMessage(uname, tel_no) {
	 
    var width = 500;
    var height = 650;
    var left = (screen.width - width) / 2;
    var top = (screen.height - height) / 2;
    var options = 'width=' + width + ',height=' + height + ',top=' + top + ',left=' + left + ',location=no';
    var url = "/popup?uname=" + uname + "&tel_no=" + tel_no;
    window.open(url, '_blank', options);
}
	 
function toggleCheckbox(uname, tel_no) {
    var checkbox = document.getElementById("checkBox");
    var receiverName = document.getElementById("receiver-name");
    var receiverPhone = document.getElementById("receiver-phone");
    
    console.log(checkbox);
    console.log(receiverName + " receiverName");
    console.log(receiverPhone + " receiverPhone");
    console.log(uname);
    console.log(tel_no);
    if (!checkbox.checked) {
        receiverName.value = ""; // checkbox가 체크되었을 때
        receiverPhone.value = "";
    } else {
        receiverName.value = uname; // checkbox가 해제되었을 때
        receiverPhone.value = tel_no;
    }
}

