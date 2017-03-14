package com.martinf.fowler.mocks.are.not.stubs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PedidoStateTest {

	private static String TALISKER = "Talisker";
	private static String HIGHLAND_PARK = "Highland Park";
	private Almacen almacen = new AlmacenImpl();

	@Before
	public void setUp() throws Exception {
		almacen.anade(TALISKER, 50);
		almacen.anade(HIGHLAND_PARK, 25);
	}

	@Test
	public void pedidoSeRellenaSiHaySuficienteEnElAlmacen() {
		//Arrange
		Pedido pedido = new Pedido(TALISKER, 50);
		//Act
		pedido.fill(almacen);
		//Assert
		assertTrue(pedido.estaRelleno());
		assertEquals(0, almacen.getInventory(TALISKER));
	}

	@Test
	public void testPedidoNoQuitaCantidadSiNoHaySuficienteEnAlmacen() {
		//Arrange
		Pedido pedido = new Pedido(TALISKER, 51);
		//Act
		pedido.rellenar(almacen);
		//Assert
		assertFalse(pedido.estaRelleno());
		assertEquals(50, almacen.getInventory(TALISKER));
	}

}
