package com.controlgastos.spring.dao;

import java.util.List;

import com.controlgastos.spring.model.TipoIngreso;

public interface TipoIngresoDAO {

	public void addTipoIngreso(TipoIngreso t);
	public void updateTipoIngreso(TipoIngreso t);
	public List<TipoIngreso> listTipoIngreso();
	public TipoIngreso getTipoIngresoById(int id);
	public void removeTipoIngreso(int id);
}
