package com.springlec.sellre.cart.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CartRegistryRequestDto(
		@NotNull(message = "상품 아이디가 필요합니다.")
		Long productId,
		
		@NotNull(message = "상품 개수가 필요합니다.")
		@Min(value = 1, message = "상품 개수는 적어도 1 이상이어야 합니다.")
		Integer amount
) {
}
