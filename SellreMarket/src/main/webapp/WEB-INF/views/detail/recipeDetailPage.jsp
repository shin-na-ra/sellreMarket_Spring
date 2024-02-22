<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- 뷰포트 설정: 화면 폭에 맞춰 초기 확대, 최대 확대는 1배로 설정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, viewport-fit=cover">
    
    <!-- 언어 설정 -->
    <meta charset="UTF-8">
    
    <!-- 제목 설정 -->
    <title>레시피 상세페이지</title>
    
    <!-- 파비콘 설정 -->
    <link rel="shortcut icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
    <link rel="icon" href="http://localhost:8080/SellreMarket/image/logo.png" />
    <link rel="icon" type="image/png" sizes="16x16" href="http://localhost:8080/SellreMarket/image/logo.png" />
    <link rel="icon" type="image/png" sizes="32x32" href="http://localhost:8080/SellreMarket/image/logo.png" />
    
    <!-- 외부 CSS -->
    <link rel="preload" href="https://res.kurly.com/_next/static/css/d59287ec5b86dc49.css" as="style"/>
    <link rel="stylesheet" href="https://res.kurly.com/_next/static/css/d59287ec5b86dc49.css" data-n-g=""/>
    <link rel="stylesheet" href="css/detail/detailPage.css" />

    <!-- 내부 CSS -->
    <style>
        .dropdown-container {
            border: 1px solid #ccc; /* 테두리 스타일 설정 */
            border-radius: 4px; /* 테두리 모양을 더 둥글게 만듭니다. */
            overflow: hidden; /* 내용이 테두리를 넘어가지 않도록 설정합니다. */
        }
    </style>
</head>
<body>
    <!-- 헤더 jsp 파일 include -->
    <jsp:include page="../header.jsp" />
    
    <!-- 상품 선택 영역 -->
    <div class="css-n48rgu ex9g78v0">
        <div class="css-16c0d81 e1brqtzw0">
            <main id="product-atf" class="css-1eoy87d e17iylht5">
                <div class="css-5v50l3 e17iylht4"></div>
                <section class="css-1ua1wyk e17iylht3">
                    <!-- 상품 선택을 위한 컨테이너 -->
                    <div class="css-1bp09d0 e17iylht1">
                        <!-- 상품 선택을 위한 컨테이너 -->
                        <div class="css-2lvxh7 e1qy0s5w0">
                            <!-- 상품 리스트 항목 -->
                            <li class="css-e6zlnr epzddad2">
                                <!-- 상품 선택 제목 -->
                                <dt class="css-159o541 epzddad1">상품 선택</dt>
                                <!-- 상품 선택 옵션 -->
                                <dd class="css-1k8t52o epzddad0">
                                    <!-- 드롭다운 메뉴 -->
                                    <div class="dropdown-container">
                                        <!-- 드롭다운 선택 영역 -->
                                        <div class="MuiFormControl-root css-tzsjye">
                                            <!-- 드롭다운 선택 영역 -->
                                            <div variant="outlined" class="MuiOutlinedInput-root MuiInputBase-root MuiInputBase-colorPrimary MuiInputBase-formControl jss1 css-xald09" onclick="toggleDropdown()">
                                                <!-- 선택 텍스트 -->
                                                <div id="dropdownText" tabindex="0" role="button" aria-expanded="false" aria-haspopup="listbox" aria-label="Without label" class="MuiSelect-select MuiSelect-outlined MuiOutlinedInput-input MuiInputBase-input css-qiwgdb">상품을 선택해주세요.</div>
                                                <!-- 숨겨진 네이티브 입력 -->
                                                <input aria-hidden="true" tabindex="-1" class="MuiSelect-nativeInput css-1k3x8v3" value="">
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
	                                                <div class="option" onclick="selectOption('${dto.productName}', ${dto.productPrice}, ${dto.discountedPrice})">
	                                                    <!-- 상품 이름과 가격을 함께 표시합니다. -->
	                                                    ${dto.productName} - ${dto.productPrice} - ${dto.discountedPrice}
	                                                </div>                                  
	                                                </c:forEach>
                                            </div>
                                        </div>
                                        <!-- 장바구니 옵션 -->
                                        <div id="cartOptions" class="css-j9a02z e1aw4qzr1" style="display: none;"></div>
                                    </div>
                                </dd>
                            </li>
                            <div class="css-9y0nwt e17iylht0">
								<div class="css-ixlb9s eebc7rx8">
									<div class="css-yhijln eebc7rx7">
										<span class="css-w1is7v eebc7rx6">총 상품금액 :</span>
										<span class="css-x4cdgl eebc7rx5"></span>
										<span class="css-1jb8hmu eebc7rx4">원</span>
									</div>
								</div>
							</div>
							<div class="css-gnxbjx e10vtr1i2">
								<div class="css-14jnwd7 e10vtr1i0">
									<button class="cart-button css-1qirdbn e4nu7ef3" type="button" radius="3">
										<span class="css-nytqmg e4nu7ef1">장바구니 담기</span>
									</button>
								</div>
							</div>
                        </div>
                    </div>
                </section>        
            </main>
        </div>
    </div>
    <!-- 푸터 html 파일 include -->
    <jsp:include page="../footer.jsp" flush="false" />

    <!-- 외부 JavaScript 파일 -->
    <script src="js/detail/recipeDetailPage.js"></script>    
</body>
</html>
