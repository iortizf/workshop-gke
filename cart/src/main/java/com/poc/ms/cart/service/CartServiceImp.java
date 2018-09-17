package com.poc.ms.cart.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.ms.cart.exception.CartNotFoundException;
import com.poc.ms.cart.model.Cart;
import com.poc.ms.cart.model.CartItem;
import com.poc.ms.cart.repository.CartRepository;
import com.poc.ms.cart.vo.AddItemRequestVo;
import com.poc.ms.cart.vo.CartVo;
import com.poc.ms.cart.vo.Item;

@Service
public class CartServiceImp implements CartService {
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public void addItem(AddItemRequestVo addItemReq) {
		
		Optional<Cart> cart = cartRepository.findById(addItemReq.getCustomerId());
		
		CartItem newCarItem = new CartItem();
		newCarItem.setProductId(addItemReq.getProductId());
		newCarItem.setQuantity(addItemReq.getQuantity());		
		
		if(cart.isPresent()) {//Create a new cart for this customerId
			CartItem carItem = cart.get().getItems()
				.stream()
				.filter(item ->{
					if(item.getProductId() == addItemReq.getProductId()) {
						item.setQuantity(item.getQuantity() + addItemReq.getQuantity());
						return true;
					}
					return false;						
				}).findFirst().orElse(null);
			if(carItem ==null){
				cart.get().getItems().add(newCarItem);
			}		
			cartRepository.save(cart.get());
		}else {
			Cart newCart = new Cart();
			newCart.setCustomerId(addItemReq.getCustomerId());
			newCart.getItems().add(newCarItem);		
			cartRepository.save(newCart);
		}		
		
	}

	@Override
	public void emptyCart(Integer customerId) {
		Cart newCart = new Cart();
		newCart.setCustomerId(customerId);
		cartRepository.save(newCart);
	}

	@Override
	public CartVo getCartByCustomerId(Integer customerId) throws CartNotFoundException{
		Optional<Cart> cart = cartRepository.findById(customerId);
		
		if (!cart.isPresent()) {
			throw new CartNotFoundException("El cliente con id "+customerId+" no tiene un carrito");
		}		
		
		return cart.map(carrt-> {
			CartVo carResponse = new CartVo();
			carResponse.setCustomerId(carrt.getCustomerId());
			carrt.getItems().forEach(item->{
				carResponse.getItems().add(new Item(item.getProductId(),item.getDiscount(),item.getQuantity()));
			});			
			return carResponse;
		}).get();
	}

}
