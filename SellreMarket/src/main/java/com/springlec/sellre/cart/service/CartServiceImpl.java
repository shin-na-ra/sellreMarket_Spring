package com.springlec.sellre.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.sellre.auth.domain.User;
import com.springlec.sellre.cart.controller.dto.CartQueryResponseDto.CartListAndPriceQueryResponseDto;
import com.springlec.sellre.cart.controller.dto.CartQueryResponseDto.CartPriceSummaryQueryResponseDto;
import com.springlec.sellre.cart.dao.CartDao;
import com.springlec.sellre.cart.exception.CartErrorCode;
import com.springlec.sellre.cart.model.CartListViewProjection;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao dao;
	
	@Override
	public boolean save(
			String userId,
			Long productId,
			Integer amount
	) {
		try {
			return dao.save(userId, productId, amount, 1) > 0;
		} catch (Exception e) { // Checked Exception은 제공 안 함.
			e.printStackTrace();
			throw CartErrorCode.CART_ID_DUPLICATED.defaultException();
		}
	}
	
	@Override
	public CartListAndPriceQueryResponseDto findCartsByUserId(
			String userId
	) {
		try {
			List<CartListViewProjection> list = dao.findCartsByUserId(userId);
			CartPriceSummaryQueryResponseDto priceSummary;
			
			int totalPrice = list.stream()
					.map((item) -> item.price() * item.amount())
					.reduce(0, (acc, cur) -> acc + cur);
			int discountPrice = list.stream()
					.map((item) -> Math.floor(item.price() * item.saleRate() / 100.0) * item.amount())
					.reduce(0.0, (acc, cur) -> acc + cur)
					.intValue();
			int paymentPrice = totalPrice - discountPrice;
			
			priceSummary = CartPriceSummaryQueryResponseDto.builder()
					.totalPrice(totalPrice)
					.discountPrice(discountPrice)
					.paymentPrice(paymentPrice)
					.build();
			
			return CartListAndPriceQueryResponseDto.builder()
					.carts(list)
					.priceSummary(priceSummary)
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			throw CartErrorCode.DEFAULT.defaultException();
		}
	}
	
	@Override
	public boolean updateAmountByCartId(
			Long cartId,
			Integer amount
	) {
		try {
			return dao.updateAmountByCartId(cartId, amount) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw CartErrorCode.DEFAULT.defaultException();
		}
	}
	
	@Override
	public boolean existsByUserIdAndCartId(
			String userId,
			Long cartId
	) {
		try {
			return dao.existsByUserIdAndCartId(userId, cartId);
		} catch (Exception e) {
			e.printStackTrace();
			throw CartErrorCode.DEFAULT.defaultException();
		}
	}
	
	@Override
	public boolean deleteByCartId(
			Long cartId
	) {
		try {
			return dao.deleteByCartId(cartId) > 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw CartErrorCode.DEFAULT.defaultException();
		}
	}

	@Override
	public boolean hasAuthorityOnCart(User user, Long cartId) {
		try {
			return dao.existsByUserIdAndCartId(user.getId(), cartId);
		} catch (Exception e) {
			e.printStackTrace();
			throw CartErrorCode.DEFAULT.defaultException();
		}
	}
}
