/*
 * Java와 연결되는 공간
 */

package com.springlec.sellre.cart.service;

import com.springlec.sellre.auth.domain.User;
import com.springlec.sellre.cart.controller.dto.CartQueryResponseDto.CartListAndPriceQueryResponseDto;

public interface CartService {
	boolean save(
			String userId,
			Long productId,
			Integer amount
	);
	
	CartListAndPriceQueryResponseDto findCartsByUserId(
			String userId
	);
	
	boolean updateAmountByCartId(
			Long cartId,
			Integer amount
	);
	
	boolean existsByUserIdAndCartId(
			String userId,
			Long cartId
	);
	
	boolean deleteByCartId(Long cartId);

	boolean hasAuthorityOnCart(User user, Long cartId);
}
