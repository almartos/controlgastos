package com.controlgastos.spring.service;

import java.util.List;

import com.controlgastos.spring.model.Gasto;

public interface GastoService {

	public void addGasto(Gasto g);
	public void updateGasto(Gasto g);
	public List<Gasto> listGasto();
	public List<Gasto> listGastoByIdGasGlobal(int id);
	public Gasto getGastoById(int id);
	public void removeGasto(int id);
	
}
