package com.springlec.sellre.model;

import java.text.NumberFormat;

import lombok.Builder;

/**
 * 롬복(Lombok) 라이브러리
 * 	- VO(Value Object), DTO(Data Transfer Object)에 작성되는 공통 코드
 * 	- getter/setter/생성자를 자동 추가해주는 라이브러리
 */

/**
 * 장바구니 목록 조회용 모델 (DB 연결 쪽 DTO 역할)
 */
@Builder
public record CartListViewProjection(
		Long cartId,
		Long productId,
		Long recipeId,
		Integer amount,
		
		String productName,
		Long priceId,
		Integer price,
		Long eventId,
		Integer saleRate,
		String imagePath
		
		// TODO append recipe info
) {
	public String priceLocale() {
		NumberFormat format = NumberFormat.getNumberInstance();
		return format.format(price);
	}
}
