package com.springlec.sellre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.sellre.dao.CartDao;
import com.springlec.sellre.model.CartListViewProjection;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDao dao;
	
	@Override
	public int save(
			String userId,
			Long productId,
			Integer amount
			) throws Exception {
		return dao.save(userId, productId, amount);
	}
	
	@Override
	public List<CartListViewProjection> findCartsByUserId(
			String userId
			) throws Exception {
		return dao.findCartsByUserId(userId);
	}
	
	@Override
	public int updateAmountByCartId(
			Long cartId,
			Integer amount
			) throws Exception {
		return dao.updateAmountByCartId(cartId, amount);
	}
	
	@Override
	public boolean existsByUserIdAndCartId(
			String userId,
			Long cartId
			) throws Exception {
		return dao.existsByUserIdAndCartId(userId, cartId);
	}
	
	@Override
	public int deleteByCartId(
			Long cartId
			) throws Exception {
		return dao.deleteByCartId(cartId);
	}
}
