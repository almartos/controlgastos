package com.controlgastos.spring.service;

import java.util.List;

import com.controlgastos.spring.model.TipoIngreso;

public interface TipoIngresoService {

	public void addTipoIngreso(TipoIngreso p);
	public void updateTipoIngreso(TipoIngreso p);
	public List<TipoIngreso> listTipoIngreso();
	public TipoIngreso getTipoIngresoById(int id);
	public void removeTipoIngreso(int id);
	
}
