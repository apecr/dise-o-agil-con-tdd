package com.martinf.fowler.mocks.are.not.stubs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PedidoStateTester {
	
	private static String TALISKER = "Talisker";
	@Mock
	private Almacen almacen;

	@Test
	public void testPedidoEnviaEmailSiNoSeRellena() {
		//Arrange
		Pedido pedido = new Pedido(TALISKER, 51);
		MailService mailer = new MailServiceStub();
		pedido.setMailer(mailer);
		//Act
		pedido.rellenar(almacen);
		//Assert
		assertEquals(1, mailer.numberSent());
	}

}
