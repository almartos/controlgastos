package com.controlgastos.spring.dao;

import java.util.List;

import com.controlgastos.spring.model.TipoGasto;

public interface TipoGastoDAO {

	public void addTipoGasto(TipoGasto t);
	public void updateTipoGasto(TipoGasto t);
	public List<TipoGasto> listTipoGasto();
	public TipoGasto getTipoGastoById(int id);
	public void removeTipoGasto(int id);
}
