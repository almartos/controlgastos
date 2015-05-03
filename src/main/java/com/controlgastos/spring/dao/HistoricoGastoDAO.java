package com.controlgastos.spring.dao;

import java.util.List;

import com.controlgastos.spring.model.HistoricoGasto;

public interface HistoricoGastoDAO {

	public void addHistoricoGasto(HistoricoGasto hg);
	public void updateHistoricoGasto(HistoricoGasto hg);
	public List<HistoricoGasto> listHistoricoGasto();
	public HistoricoGasto getHistoricoGastoById(int id);
	public void removeHistoricoGasto(int id);
	public List<HistoricoGasto> listHistoricoGastoPorIdGasto(int id);
}
