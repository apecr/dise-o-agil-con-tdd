package com.martinf.fowler.mocks.are.not.stubs;

public interface Almacen {

	void anade(String tALISKER, int i);

	int getInventory(String tALISKER);

	boolean tieneIventario(String tALISKER, int i);

	void quitar(String tALISKER, int i);

}
