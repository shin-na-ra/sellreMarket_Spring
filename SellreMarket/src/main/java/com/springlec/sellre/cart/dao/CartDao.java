/*
 * Data와 연결되는 공간
 */

package com.springlec.sellre.cart.dao;

import java.util.List;

import com.springlec.sellre.cart.model.CartListViewProjection;

public interface CartDao {
	/**
	 * <h1>Save user-specific cart information.</h1>
	 * @param userId (주로 로그인 된 사용자로) 사용자 아이디
	 * @param productId 제품 아이디
	 * @param amount 제품 수량
	 * @throws Exception
	 */
	int save(
		String userId,
		Long productId,
		Integer amount,
		Integer status
	) throws Exception;
	
	/**
	 * <h1>Look up shopping cart product lists by user.</h1>
	 * <ul>
	 *   <li>A</li>
	 *   <li>B</li>
	 *   <li>C</li>
	 * </ul>
	 * @param userId (주로 로그인 된 사용자로) 사용자 아이디
	 * @throws Exception
	 */
	List<CartListViewProjection> findCartsByUserId(
			String userId
	) throws Exception;
	
	/**
	 * <h1>Changing the quantity of shopping cart products.</h1>
	 * @param cartId 제품 아이디
	 * @param amount 제품 수량
	 * @throws Exception
	 */
	int updateAmountByCartId(
		Long cartId,
		Integer amount
	) throws Exception;
	
	/**
	 * <h1>Check for matching shopping cart information by user</h1>
	 * @param userId (주로 로그인 된 사용자로) 사용자 아이디
	 * @param cartId 제품 아이디
	 * @throws Exception
	 */
	boolean existsByUserIdAndCartId(
			String userId,
			Long cartId
	) throws Exception;
	
	/**
	 * <h1>Removing shopping cart products.</h1>
	 * @param cartId 제품 아이디
	 * @throws Exception
	 */
	int deleteByCartId(
		Long cartId
	) throws Exception;
}
