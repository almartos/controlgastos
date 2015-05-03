package com.controlgastos.spring.dao;

import java.util.List;

import com.controlgastos.spring.model.GastoGlobal;

public interface GastoGlobalDAO {

	public void addGastoGlobal(GastoGlobal gg);
	public void updateGastoGlobal(GastoGlobal gg);
	public List<GastoGlobal> listGastoGlobal();
	public GastoGlobal getGastoGlobalById(int id);
	public void removeGastoGlobal(int id);
}
