package com.controlgastos.spring.dao;

import java.util.List;

import com.controlgastos.spring.model.HistoricoGasto;
import com.controlgastos.spring.model.HistoricoIngreso;

public interface HistoricoIngresoDAO {

	public void addHistoricoIngreso(HistoricoIngreso hi);
	public void updateHistoricoIngreso(HistoricoIngreso hi);
	public List<HistoricoIngreso> listHistoricoIngreso();
	public HistoricoIngreso getHistoricoIngresoById(int id);
	public void removeHistoricoIngreso(int id);
	public List<HistoricoIngreso> listHistoricoIngresoPorIdIngreso(int id);
}
