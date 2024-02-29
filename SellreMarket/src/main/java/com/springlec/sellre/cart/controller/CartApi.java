package com.springlec.sellre.cart.controller;

import static com.springlec.sellre.common.support.Constants.LOGIN_USER_SESSION_NAME;
import static com.springlec.sellre.common.util.AuthorityUtil.getUserOrThrow;
import static com.springlec.sellre.common.util.AuthorityUtil.requireSigning;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.springlec.sellre.cart.controller.dto.CartQueryResponseDto.CartListAndPriceQueryResponseDto;
import com.springlec.sellre.auth.domain.User;
import com.springlec.sellre.cart.controller.dto.CartRegistryRequestDto;
import com.springlec.sellre.cart.controller.dto.CartRegistryResponseDto;
import com.springlec.sellre.cart.controller.dto.CartUpdateAmountRequestDto;
import com.springlec.sellre.cart.exception.CartErrorCode;
import com.springlec.sellre.cart.service.CartService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController // <<< AJAX용 컨트롤러
@RequestMapping("api/carts")
public final class CartApi {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private Gson gson;
	
	// TODO HTTP Method 구분할 수 있는 구조로 리팩토링 하면 URL에서 행위 제외
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CartRegistryResponseDto cartRegistry(
			@RequestBody
			@Valid
			CartRegistryRequestDto requestBody,
			HttpServletRequest request,
			HttpServletResponse response
	) {
		requireSigning(request, response);
		
		// http://localhost:8080/api/cart?abc=123&abbcc=12233 <<< req param
		// body는 AJAX 만들 때(JS): { data: { ... }, }
		
		// DTO: 사용자랑 주고 받는 걸 (제한적 의미) 요즘 그래.
		// Entity: DB랑 주고 받기 위한 모델. 옛날엔 DTO 성격과 섞여서 VO라고 불렸음.
		// Projection: DB에서 일부 컬럼만 조회하기 위해서 사용.
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(LOGIN_USER_SESSION_NAME);
		
		Long productId = requestBody.productId();
		Integer amount = requestBody.amount();
		
		cartService.save(user.getId(), productId, amount);
		
		// JSON String(generated via JACKSON):
		//  {"success":true} <<< 객체를 반환하면 기본적으로 {중괄호로 감싼 JSON}
		return CartRegistryResponseDto.builder()
				.success(true)
				.build();
	}
	
	@GetMapping
	public CartListAndPriceQueryResponseDto getAll(
			HttpServletRequest request,
			HttpServletResponse response
	) {
		User user = getUserOrThrow(request);
		
		return cartService.findCartsByUserId(user.getId());
	}
	
	// PutMapping: 원래는 카트 전체 변경 (PATCH 쓰기 귀찮을 때도 PUT으로 통일하는 편.)
	// PatchMapping: 일부 변경. 유지보수 귀찮아서 PatchMapping 잘 안 씀.
	@PatchMapping("/item/{cartId}/amount")
	public void updateQty(
			@PathVariable
			Long cartId,
			@RequestBody
			@Valid
			CartUpdateAmountRequestDto body,
			HttpServletRequest request,
			HttpServletResponse response
	) {
		User user = getUserOrThrow(request);
		
		// 장바구니 소유자가 아닌 사람이 요청하였음.
		if (!cartService.hasAuthorityOnCart(user, cartId)) {
			throw CartErrorCode.NOT_OWN_ITEM.defaultException();
		}
		
		if (body.amount() > 0) {			
			cartService.updateAmountByCartId(cartId, body.amount());
		} else {
			cartService.deleteByCartId(cartId);
		}
	}

	// 장바구니 page에서 item 삭제하기.
	@DeleteMapping("/item/{cartId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204 NO_CONTENT
	public void cartDeleteItem(
			@PathVariable Long cartId,
			HttpServletRequest request,
			HttpServletResponse response
	) throws Exception {
		// (요청에 있는 변수 꺼내는 것뿐이니까 로직과 무관)
		User user = getUserOrThrow(request);
		
		// [1] 사용자 본인의 카트 아이템이 맞는지 확인
		if (!cartService.hasAuthorityOnCart(user, cartId)) {
			throw CartErrorCode.NOT_OWN_ITEM.defaultException();
		}
		
		// [2] 맞으면 삭제
		cartService.deleteByCartId(cartId);
	}
	
	// 장바구니 page 테스트를 위한 임시 로그인
	@PostMapping("/fake/login")
	public void fakeLogin(
			HttpServletRequest request
	) throws Exception {
		HttpSession session = request.getSession();
		User user = User.builder().
				id("admin").
				name("1234").
				build();
		session.setAttribute("loginUser", user);
	}
}
