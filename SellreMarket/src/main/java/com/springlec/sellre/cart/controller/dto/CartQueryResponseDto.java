package com.springlec.sellre.cart.controller.dto;

import java.util.List;

import com.springlec.sellre.cart.model.CartListViewProjection;

import lombok.Builder;

public final class CartQueryResponseDto {
	private CartQueryResponseDto() {}

	@Builder
	public record CartPriceSummaryQueryResponseDto(
			Integer totalPrice,
			Integer discountPrice,
			Integer paymentPrice
	) {
		public CartPriceSummaryQueryResponseDto {
			if (totalPrice == null) totalPrice = 0;
			if (discountPrice == null) discountPrice = 0;
			if (paymentPrice == null) paymentPrice = 0;
		}
	}

	@Builder
	public record CartListAndPriceQueryResponseDto(
			List<CartListViewProjection> carts,
			CartPriceSummaryQueryResponseDto priceSummary
	) {}
}
