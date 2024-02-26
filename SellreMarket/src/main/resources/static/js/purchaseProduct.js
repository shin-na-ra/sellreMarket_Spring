/**
 * 
 */

/*
window.onload = function() {
    var discountSum = parseFloat(document.getElementById("discountSum").innerText);
    var deliveryFee = parseFloat(document.getElementById("deliveryFee").innerText);
    var totalPrice = document.getElementById("totalPrice");

    // Assuming you want to display the result in totalPrice
    totalPrice.innerText = (discountSum + deliveryFee).toFixed(2); // Assuming you want to display with 2 decimal places
}
background-color: rgb(95, 0, 128);
    border-top-color: rgb(95, 0, 128);
    border-right-color: rgb(95, 0, 128);
    border-bottom-color: rgb(95, 0, 128);
    border-left-color: rgb(95, 0, 128);
*/

/* Default selected style for "카카오페이" button */

function payMethod(method) {
	var kakao = document.getElementById('kakao');
	var credit = document.getElementById('credit');
	var simple = document.getElementById('simple');
	var phone = document.getElementById('phone');
	var payMethod = document.getElementById('payMethod');
	
	
	if (method == kakao) {
		var list = [credit, simple, phone];
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
		var list = [kakao, simple, phone];
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
  	
  	if (method == simple) {
		var list = [kakao, credit, phone];
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
  	}
  	if (method == phone) {
		var list = [kakao, credit, simple];
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
	
	if(con) {
		form.submit();
	}
	else window.close();
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

