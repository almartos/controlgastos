package com.controlgastos.spring.service;

import java.util.List;

import com.controlgastos.spring.model.Ingreso;

public interface IngresoService {

	public void addIngreso(Ingreso i);
	public void updateIngreso(Ingreso i);
	public List<Ingreso> listIngreso();
	public List<Ingreso> listIngresoByIdIngGlobal(int id);
	public Ingreso getIngresoById(int id);
	public void removeIngreso(int id);
	
}
