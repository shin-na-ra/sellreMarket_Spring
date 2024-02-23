<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- Viewort 설정 부분 -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, viewport-fit=cover">
		
		<!-- 언어 감지 -->
		<meta charset="UTF-8">
		
		<!-- 제목 -->
		<title>상품 상세페이지</title>
		
		<!-- Favicon 설정 부분  -->
		<link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
		<link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
		<link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
		<link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
		
		<!-- 외부 CSS -->
		<link rel="preload" href="https://res.kurly.com/_next/static/css/d59287ec5b86dc49.css" as="style"/>
		<link rel="stylesheet" href="https://res.kurly.com/_next/static/css/d59287ec5b86dc49.css" data-n-g=""/>
		<link rel="stylesheet" href="css/detail/detailPage.css" />
	</head>
<body>

	<h2>TEST</h2>
	
	
	
    <!-- 상품 선택 옵션 -->
    <div class="css-1k8t52o epzddad0">
        <!-- 드롭다운 메뉴 -->
        <div class="dropdown-container">
            <!-- 드롭다운 선택 영역 -->
            <div class="MuiFormControl-root css-tzsjye">
                <!-- 드롭다운 선택 영역 -->
                <div variant="outlined" class="MuiOutlinedInput-root MuiInputBase-root MuiInputBase-colorPrimary MuiInputBase-formControl jss1 css-xald09" onclick="toggleDropdown()">
                    <!-- 드롭다운 아이콘 -->
                    <svg class="MuiSvgIcon-root MuiSvgIcon-fontSizeMedium MuiSelect-icon MuiSelect-iconOutlined css-1636szt" focusable="false" aria-hidden="true" viewBox="0 0 24 24" data-testid="ArrowDropDownIcon">
                        <path d="M7 10l5 5 5-5z"></path>
                    </svg>
                    <!-- 아웃라인 스타일링 -->
                    <fieldset aria-hidden="true" class="MuiOutlinedInput-notchedOutline css-igs3ac">
                        <legend class="css-nnbavb">
                            <span class="notranslate">​</span>
                        </legend>
                    </fieldset>
                </div>
                 <!-- 드롭다운 옵션 목록 -->
                <div id="dropdownOptions" class="dropdown-options" style="display: none;">
                   <!-- 기본 선택 옵션 -->
                    <div class="option" onclick="selectOption('상품을 선택해주세요')"></div>
                    
                    <!-- pnameList와 priceList를 가져와서 각각의 상품 이름과 가격으로 옵션을 생성 -->
                     <c:forEach items="${list}" var="dto">
                     <!-- 각 상품 이름과 가격을 표시하는 옵션을 생성합니다. -->
                     <div class="option" onclick="selectOption('${dto.pname}', ${dto.price}, ${dto.dPrice})">
                         <!-- 상품 이름과 가격을 함께 표시합니다. -->
                         ${dto.pname} - ${dto.price} - ${dto.dPrice}
                     </div>                                  
                     </c:forEach>
                     
                </div> 
            </div>
            <!-- 장바구니 옵션 -->
            <div id="cartOptions" class="css-j9a02z e1aw4qzr1" style="display: none;"></div>
        </div>
    </div>
</body>
</html>