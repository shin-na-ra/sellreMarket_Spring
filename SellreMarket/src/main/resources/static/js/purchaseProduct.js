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
*/



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
	var con = confirm("구매를 완료하시겠습니까?");
	
	if(con) {
		window.location.href = "";
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

