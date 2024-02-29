package com.springlec.sellre.cart.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CartUpdateAmountRequestDto(
		@NotNull
		@Min(0)
		Integer amount
) {
}
