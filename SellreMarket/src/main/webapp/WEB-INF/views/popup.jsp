<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link rel="stylesheet" href="css/popup.css" />

<style>
.number-selector {
	display: flex;
	align-items: center;
	justify-content: center;
}

.decrement, .increment {
	cursor: pointer;
	font-size: 20px;
	margin: 0 10px;
}

.number {
	font-size: 16px;
	font-weight: bold;
}

.total {
	font-size: 20px;
	font-weight: bold;
	padding-left: 20px;
	padding-top: 6px;
}
</style>


<!-- // js 따로 관리한다. -->
<script src="js/purchaseProduct.js"></script>

</head>

<body>
	<div id="__next" data-reactroot="">
		<div class="css-129cqpp e12ad82f3">
			<h2 class="css-17mphey e12ad82f2">배송 요청사항</h2>
			<label class="css-1ugk09k e1dcessg3"> 
			<!-- <input type="checkbox" class="css-agvwxo e1dcessg2" checked="" id="checkBox" onclick="click()"> -->
			<input type="checkbox" class="css-agvwxo e1dcessg2" checked="" id="checkBox" onclick="toggleCheckbox(${uname}, ${tel_no})">
				<div class="css-79hxr7 e1dcessg1">
					<svg width="24" height="24" viewBox="0 0 24 24" fill="none"
						xmlns="http://www.w3.org/2000/svg">
						<path
								d="M12 24C18.6274 24 24 18.6274 24 12C24 5.37258 18.6274 0 12 0C5.37258 0 0 5.37258 0 12C0 18.6274 5.37258 24 12 24Z"
								fill="#5f0080"></path>
						<path d="M7 12.6667L10.3846 16L18 8.5" stroke="#fff" stroke-width="1.5"
								stroke-linecap="round" stroke-linejoin="round"></path>
					</svg>
				</div> <span>주문자 정보와 동일</span>
			</label>
		</div>
		<div class="css-lgy2fd e12ad82f1">
			<div class="css-1ahk2qk e1uzxhvi6">
				<label for="receiver-name" class="css-c3g9of e1uzxhvi4">받으실
					분</label> <span class="css-19lkxd2 e1uzxhvi5">*</span>
				<div height="44" class="css-t7kbxx e1uzxhvi3">
					<input data-testid="input-box" id="receiver-name" name="name"
						placeholder="이름을 입력해 주세요" type="text" required="" height="44"
						class="css-1quw3ub e1uzxhvi2" value="${uname}">
				</div>
			</div>
			<div class="css-acvisw e1uzxhvi6">
				<label for="receiver-phone" class="css-c3g9of e1uzxhvi4">휴대폰</label>
				<span class="css-19lkxd2 e1uzxhvi5">*</span>
				<div height="44" class="css-t7kbxx e1uzxhvi3">
					<input data-testid="input-box" id="receiver-phone" name="phone"
						placeholder="숫자만 입력해 주세요" type="tel" required="" height="44"
						class="css-1quw3ub e1uzxhvi2" value="${tel_no}">
				</div>
			</div>
			<!-- <div class="css-1j0h5fa e1tjt2bn7">
				<label for="receiver-delivery-request" class="css-3nsxl0 e1tjt2bn4">배송기사
					요청사항</label>
				<div class="css-1ftcmgd e1tjt2bn5">
					<textarea id="receiver-delivery-request"
						placeholder="예) 벨 누르지 말고 전화주세요" inputmode="text"
						aria-label="textarea-message" class="css-5etceh e1tjt2bn1" value="">
					</textarea>
					<div class="placeholder css-1ofzfyp e1tjt2bn6"></div>
					<span class="content-length-counter css-dbwxb9 e1tjt2bn0"> <span>
							<span class="css-14kcwq8 e1tjt2bn2">0 </span> <span
							class="css-14kcwq8 e1tjt2bn3">/ 50</span>
					</span>
					</span>
				</div>
			</div> -->
			
			<div class="css-1j0h5fa e1tjt2bn7">
			    <label for="receiver-delivery-request" class="css-3nsxl0 e1tjt2bn4">배송기사 요청사항</label>
			    <div class="css-1ftcmgd e1tjt2bn5">
			        <textarea id="receiver-delivery-request"
			                  placeholder="예) 벨 누르지 말고 전화주세요"
			                  inputmode="text"
			                  aria-label="textarea-message"
			                  class="css-5etceh e1tjt2bn1"
			                  oninput="updateCharacterCount(this)"
			                  maxlength="50"
			                  value="">
			        </textarea>
			        <div class="placeholder css-1ofzfyp e1tjt2bn6"></div>
			        <span class="content-length-counter css-dbwxb9 e1tjt2bn0">
			            <span>
			                <span id="character-count" class="css-14kcwq8 e1tjt2bn2">0 </span>
			                <span class="css-14kcwq8 e1tjt2bn3">/ 50</span>
			            </span>
			        </span>
			    </div>
			</div>
			<div class="css-oticys e12ad82f0">
				<button class="css-1t93ala e4nu7ef3" type="button" height="56"
					radius="3" onclick="window.close()">
					<span class="css-nytqmg e4nu7ef1">취소</span>
				</button>
				<button class="css-1kuswgm e4nu7ef3" type="submit" height="56"
					radius="3">
					<span class="css-nytqmg e4nu7ef1">저장</span>
				</button>
			</div>
		</div>
	</div>

</body>
</html>

