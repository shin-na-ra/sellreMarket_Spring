package com.springlec.sellre.cart.controller.dto;

import java.util.Objects;

import lombok.Builder;

@Builder
public record CartRegistryResponseDto(
		Boolean success
) {
	public CartRegistryResponseDto {
		Objects.requireNonNull(success);
	}
}
