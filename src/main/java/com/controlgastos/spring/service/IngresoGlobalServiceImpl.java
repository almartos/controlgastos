package com.controlgastos.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlgastos.spring.dao.IngresoGlobalDAO;
import com.controlgastos.spring.model.IngresoGlobal;

@Service
public class IngresoGlobalServiceImpl implements IngresoGlobalService {
	
	private IngresoGlobalDAO ingresoGlobalDAO;

	public void setIngresoGlobalDAO(IngresoGlobalDAO ingresoGlobalDAO) {
		this.ingresoGlobalDAO = ingresoGlobalDAO;
	}

	@Override
	@Transactional
	public void addIngresoGlobal(IngresoGlobal ig) {
		this.ingresoGlobalDAO.addIngresoGlobal(ig);
	}

	@Override
	@Transactional
	public void updateIngresoGlobal(IngresoGlobal ig) {
		this.ingresoGlobalDAO.updateIngresoGlobal(ig);
	}

	@Override
	@Transactional
	public List<IngresoGlobal> listIngresoGlobal() {
		return this.ingresoGlobalDAO.listIngresoGlobal();
	}

	@Override
	@Transactional
	public IngresoGlobal getIngresoGlobalById(int id) {
		return this.ingresoGlobalDAO.getIngresoGlobalById(id);
	}

	@Override
	@Transactional
	public void removeIngresoGlobal(int id) {
		this.ingresoGlobalDAO.removeIngresoGlobal(id);
	}

}
