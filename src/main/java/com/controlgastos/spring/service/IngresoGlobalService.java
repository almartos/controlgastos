package com.controlgastos.spring.service;

import java.util.List;

import com.controlgastos.spring.model.IngresoGlobal;

public interface IngresoGlobalService {

	public void addIngresoGlobal(IngresoGlobal ig);
	public void updateIngresoGlobal(IngresoGlobal ig);
	public List<IngresoGlobal> listIngresoGlobal();
	public IngresoGlobal getIngresoGlobalById(int id);
	public void removeIngresoGlobal(int id);
	
}
