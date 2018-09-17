package com.poc.ms.cart.vo;

public class Item {

	private String productId;
	private Double discount;
	private Double quantity;

	public Item() {

	}

	public Item(String productId, Double discount, Double quantity) {
		this.productId = productId;
		this.discount = discount;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
}
