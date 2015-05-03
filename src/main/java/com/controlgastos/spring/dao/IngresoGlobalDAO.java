package com.controlgastos.spring.dao;

import java.util.List;

import com.controlgastos.spring.model.IngresoGlobal;

public interface IngresoGlobalDAO {

	public void addIngresoGlobal(IngresoGlobal ig);
	public void updateIngresoGlobal(IngresoGlobal ig);
	public List<IngresoGlobal> listIngresoGlobal();
	public IngresoGlobal getIngresoGlobalById(int id);
	public void removeIngresoGlobal(int id);
}
