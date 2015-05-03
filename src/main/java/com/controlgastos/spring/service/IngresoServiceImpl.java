package com.controlgastos.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlgastos.spring.dao.IngresoDAO;
import com.controlgastos.spring.model.Ingreso;

@Service
public class IngresoServiceImpl implements IngresoService {
	
	private IngresoDAO ingresoDAO;

	public void setIngresoDAO(IngresoDAO ingresoDAO) {
		this.ingresoDAO = ingresoDAO;
	}

	@Override
	@Transactional
	public void addIngreso(Ingreso i) {
		this.ingresoDAO.addIngreso(i);
	}

	@Override
	@Transactional
	public void updateIngreso(Ingreso i) {
		this.ingresoDAO.updateIngreso(i);
	}

	@Override
	@Transactional
	public List<Ingreso> listIngreso() {
		return this.ingresoDAO.listIngreso();
	}
	
	@Override
	@Transactional
	public List<Ingreso> listIngresoByIdIngGlobal(int id){
		return this.ingresoDAO.listIngresoByIdIngGlobal(id);
	}

	@Override
	@Transactional
	public Ingreso getIngresoById(int id) {
		return this.ingresoDAO.getIngresoById(id);
	}

	@Override
	@Transactional
	public void removeIngreso(int id) {
		this.ingresoDAO.removeIngreso(id);
	}

}
