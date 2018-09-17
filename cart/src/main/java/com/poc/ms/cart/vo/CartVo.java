package com.poc.ms.cart.vo;

import java.util.ArrayList;
import java.util.List;

public class CartVo {
	
	private Integer customerId;
	private List<Item> items;
	
	public CartVo(){
		items = new ArrayList<>();
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	

}
