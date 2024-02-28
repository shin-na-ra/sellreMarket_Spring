package com.springlec.sellre.model;

import java.util.Objects;

public record CartRegistryResponseDto(
		Boolean success
) {
	public CartRegistryResponseDto {
		Objects.requireNonNull(success);
	}
}
