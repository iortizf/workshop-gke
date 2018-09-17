package com.poc.ms.cart.service;

import com.poc.ms.cart.exception.CartNotFoundException;
import com.poc.ms.cart.vo.AddItemRequestVo;
import com.poc.ms.cart.vo.CartVo;

public interface CartService {
	
	void addItem(AddItemRequestVo addItemReq);
	void emptyCart(Integer customerId);
	CartVo getCartByCustomerId(Integer customerId) throws CartNotFoundException;	

}
