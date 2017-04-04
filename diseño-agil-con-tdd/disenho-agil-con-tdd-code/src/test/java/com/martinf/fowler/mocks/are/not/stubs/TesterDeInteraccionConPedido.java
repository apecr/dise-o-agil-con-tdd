package com.martinf.fowler.mocks.are.not.stubs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TesterDeInteraccionConPedido {

	private static String TALISKER = "Talisker";
	@Mock
	private Almacen almacenMock;

	@Test
	public void testHacerPedidoQuitaDelInventarioSiEstaEnStock() {
		// setup - data
		Pedido pedido = new Pedido(TALISKER, 50);
		// setup - expectations
		when(this.almacenMock.tieneIventario(TALISKER, 50)).thenReturn(true);
		// exercise
		pedido.rellenar(this.almacenMock);
		// verify
		verify(this.almacenMock).tieneIventario(TALISKER, 50);
		verify(this.almacenMock).quitar(TALISKER, 50);
		assertTrue(pedido.estaRelleno());
	}
	
	@Test
	public void testHacerPedidoNoQuitaSiNoHaySuficienteEnStock() {
		//Arrange
		Pedido pedido = new Pedido(TALISKER, 51);
		//Act
		when(this.almacenMock.tieneIventario(TALISKER, 51)).thenReturn(false);
		pedido.rellenar(this.almacenMock);
		//Assert
		verify(this.almacenMock).tieneIventario(TALISKER, 51);
		assertFalse(pedido.estaRelleno());
	}

}
