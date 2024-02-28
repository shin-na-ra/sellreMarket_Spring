package com.springlec.sellre.model;

import java.util.Objects;

public record CartRegistryRequestDto(
		Long productId,
		Integer amount
) {
	public CartRegistryRequestDto {
		Objects.requireNonNull(productId);
		Objects.requireNonNull(amount);
	}
}
