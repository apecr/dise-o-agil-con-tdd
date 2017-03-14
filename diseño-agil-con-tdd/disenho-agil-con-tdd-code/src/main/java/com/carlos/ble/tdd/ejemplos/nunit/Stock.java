package com.carlos.ble.tdd.ejemplos.nunit;

import java.util.HashMap;
import java.util.Map;

public class Stock {
	
	private Map<String, Product> products = new HashMap<>();

	public Stock() {
		super();
		this.products.put("x1abc3t3c", new Product(5f));
	}



	public Product getProductWithCode(String idProduct) {
		return products.get(idProduct);
	}

}
