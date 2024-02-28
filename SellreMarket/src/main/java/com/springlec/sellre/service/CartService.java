/*
 * Java와 연결되는 공간
 */

package com.springlec.sellre.service;

import java.util.List;

import com.springlec.sellre.model.CartListViewProjection;

public interface CartService {
	public int save(
			String userId,
			Long productId,
			Integer amount
			) throws Exception;
	
	public List<CartListViewProjection> findCartsByUserId(
			String userId
			) throws Exception;
	
	public int updateAmountByCartId(
			Long cartId,
			Integer amount
			) throws Exception;
	
	public boolean existsByUserIdAndCartId(
			String userId,
			Long cartId
			) throws Exception;
	
	public int deleteByCartId(
			Long cartId
			) throws Exception;
}
