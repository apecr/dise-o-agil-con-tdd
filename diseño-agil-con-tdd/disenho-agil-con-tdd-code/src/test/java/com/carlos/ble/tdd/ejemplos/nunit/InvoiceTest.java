package com.carlos.ble.tdd.ejemplos.nunit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InvoiceTest {

	@Test
	public void calculateTaxes() {
		//Arrange
		Stock stock = new Stock();
		Product product = stock.getProductWithCode("x1abc3t3c");
		Line line = new Line();
		int quantity = 10;
		line.addProducts(product, quantity);
		Invoice invoice = new Invoice(new TaxManager());
		invoice.addLine(line);
		//Act
		float total = invoice.getTotal();
		//Assert
		assertTrue(quantity * product.getPrice() > total);

	}

}
