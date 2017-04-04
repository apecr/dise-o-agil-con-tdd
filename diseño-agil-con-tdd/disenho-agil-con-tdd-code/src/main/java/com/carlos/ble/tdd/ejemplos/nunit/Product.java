package com.carlos.ble.tdd.ejemplos.nunit;

public class Product {

	private float price;

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	public Product(float price) {
		super();
		this.price = price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
}
