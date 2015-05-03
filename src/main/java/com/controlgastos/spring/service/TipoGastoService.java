package com.controlgastos.spring.service;

import java.util.List;

import com.controlgastos.spring.model.TipoGasto;

public interface TipoGastoService {

	public void addTipoGasto(TipoGasto p);
	public void updateTipoGasto(TipoGasto p);
	public List<TipoGasto> listTipoGasto();
	public TipoGasto getTipoGastoById(int id);
	public void removeTipoGasto(int id);
	
}
