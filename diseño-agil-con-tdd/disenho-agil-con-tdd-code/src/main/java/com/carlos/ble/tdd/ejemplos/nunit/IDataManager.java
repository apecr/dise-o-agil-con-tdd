package com.carlos.ble.tdd.ejemplos.nunit;

public interface IDataManager {
	
	public IRelationalObject getByKey(String key);
	
	public void save(IRelationalObject robject);
	
	public void create(IRelationalObject robject);

}
