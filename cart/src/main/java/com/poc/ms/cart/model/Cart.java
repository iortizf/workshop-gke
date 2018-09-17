package com.poc.ms.cart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("cart")
public class Cart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9114861069061933680L;
	
	@Id
	private Integer customerId;
	
	private List<CartItem> items;
	
	public Cart() {
		this.items = new ArrayList<>();
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
	
	
	

}
