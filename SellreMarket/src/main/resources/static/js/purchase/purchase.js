// 페이지가 로드될 때 실행되는 함수 등록
document.addEventListener('DOMContentLoaded', function() {

    // purchaseDetailGoContainer 클래스를 가진 모든 요소를 선택하여 가져옵니다.
    var purchaseDetailGoContainers = document.querySelectorAll('.purchaseDetailGoContainer');

    // forEach 메서드를 사용하여 각 요소에 대해 반복합니다.
    purchaseDetailGoContainers.forEach(function(container) {

        // 각 요소에 클릭 이벤트 리스너를 추가합니다.
        container.addEventListener('click', function(event) {

            // 클릭된 요소의 부모 요소에서 purchaseId 값을 가져옵니다.
            var purchaseId = container.dataset.purchaseId;

            // purchaseId 값이 존재하는지 확인합니다.
            if (purchaseId) {
                // 클릭된 요소의 purchaseId 값을 이용하여 URL을 생성합니다.
                var url = 'purchaseListDetailPage?purchaseId=' + purchaseId;
                // 예: '/purchaseDetail?purchaseId=' + purchaseId;

                // 생성된 URL로 이동합니다.
                window.location.href = url;
            } else {
                console.log('purchaseId를 찾을 수 없습니다.');
            }
        });
    });
});

// 페이지가 완전히 로드 되었을 때
$(document).ready(function(){
	
    // 검색창에서 입력 후 엔터 키를 눌렀을 때
    $('.searchBoxContent').keypress(function(event) {
        // 엔터 키의 keyCode는 13입니다.
        if (event.keyCode === 13) {
            // 검색 버튼을 클릭한 것과 동일한 동작 수행
            $('.magnifierBox').click();
        }
    });
	
	// 검색창에서 입력 후 검색 버튼을 누를 때
	$('.magnifierBox').click(function(){
	    // 입력된 값을 가져옵니다.
	    var searchText = $('.searchBoxContent').val();
	    
        // 정규식을 사용하여 검색어 형식을 확인합니다.
        var regex = /^[a-zA-Z0-9가-힣]+( [a-zA-Z0-9가-힣]+)*$/;
        
        // 만약 검색어가 비어있거나 정규식에 부합하지 않는다면 알람창을 띄웁니다.
        if(searchText.trim() === '' || !regex.test(searchText)) {
            alert('검색어를 올바르게 입력해주세요.');
            return; // 검색어가 올바르지 않을 경우 함수 종료
        }
        // Controller에 검색 기능으로 검색어 보내기
        window.location.href="purchaseSearch?searchText=" + searchText;
        	    
	});
});