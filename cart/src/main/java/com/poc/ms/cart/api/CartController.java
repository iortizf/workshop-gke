package com.poc.ms.cart.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.poc.ms.cart.exception.CartNotFoundException;
import com.poc.ms.cart.service.CartService;
import com.poc.ms.cart.vo.AddItemRequestVo;
import com.poc.ms.cart.vo.CartVo;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {
	
	@Autowired
	private CartService carService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody AddItemRequestVo addItemReq){
		carService.addItem(addItemReq);
	}
	
	@PostMapping("/{customerId}/customer")
	@ResponseStatus(HttpStatus.OK)
	public void empty(@PathVariable("customerId") Integer customerId) {
		carService.emptyCart(customerId);
	}
	
	@GetMapping("/{customerId}/customer")
	@ResponseStatus(HttpStatus.OK)
	public CartVo getCart(@PathVariable("customerId") Integer customerId) 
			throws CartNotFoundException {
		
		return carService.getCartByCustomerId(customerId);
	}

}
