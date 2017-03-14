package com.martinf.fowler.mocks.are.not.stubs;

public class Pedido {

	private MailService mailer;
	private String talisker;
	private int numberOfElements;
	private boolean relleno = false;
	
	
	public Pedido(String talisker, int i) {
		this.talisker = talisker;
		this.numberOfElements = i;
		if (this.mailer == null) {
			this.mailer = new MailService() {

				@Override
				public void send(Message message) {
				}

				@Override
				public int numberSent() {
					return 0;
				}
			};
		}
	}

	public void fill(Almacen almacen) {
		this.rellenar(almacen);
	}

	public boolean estaRelleno() {
		return this.relleno;
	}

	public void rellenar(Almacen almacen) {
		if (almacen.tieneIventario(talisker, numberOfElements)){
			almacen.quitar(talisker, numberOfElements);
			this.relleno = true;
		} else {
			this.relleno = false;
			mailer.send(null);
		}		
	}

	public void setMailer(MailService mailer) {
		this.mailer = mailer;
	}

}
