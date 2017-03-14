package com.martinf.fowler.mocks.are.not.stubs;

import java.util.HashMap;
import java.util.Map;

public class AlmacenImpl implements Almacen {

	private Map<String, Integer> inventario = new HashMap<>();

	@Override
	public void anade(String talisker, int i) {
		if (this.inventario.get(talisker) == null) {
			this.inventario.put(talisker, 0);
		}
		this.inventario.put(talisker, this.inventario.get(talisker) + i);
	}

	@Override
	public int getInventory(String talisker) {
		return this.inventario.get(talisker);
	}

	@Override
	public boolean tieneIventario(String talisker, int i) {
		return this.inventario.get(talisker) >= i;
	}

	@Override
	public void quitar(String talisker, int i) {
		if (this.inventario.get(talisker) >= i) {
			this.inventario.put(talisker, this.inventario.get(talisker) - i);
		}
	}

}
