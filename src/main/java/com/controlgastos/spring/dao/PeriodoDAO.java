package com.controlgastos.spring.dao;

import java.util.List;

import com.controlgastos.spring.model.Periodo;

public interface PeriodoDAO {

	public void addPeriodo(Periodo p);
	public void updatePeriodo(Periodo p);
	public List<Periodo> listPeriodo();
	public Periodo getPeriodoById(int id);
	public void removePeriodo(int id);
}
