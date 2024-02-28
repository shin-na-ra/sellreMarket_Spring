/**
 * 
 */

 
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

