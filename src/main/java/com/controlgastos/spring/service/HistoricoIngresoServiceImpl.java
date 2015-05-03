package com.controlgastos.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlgastos.spring.dao.HistoricoIngresoDAO;
import com.controlgastos.spring.model.HistoricoIngreso;

@Service
public class HistoricoIngresoServiceImpl implements HistoricoIngresoService {
	
	private HistoricoIngresoDAO historicoIngresoDAO;

	public void setHistoricoIngresoDAO(HistoricoIngresoDAO historicoIngresoDAO) {
		this.historicoIngresoDAO = historicoIngresoDAO;
	}

	@Override
	@Transactional
	public void addHistoricoIngreso(HistoricoIngreso hi) {
		this.historicoIngresoDAO.addHistoricoIngreso(hi);
	}

	@Override
	@Transactional
	public void updateHistoricoIngreso(HistoricoIngreso hi) {
		this.historicoIngresoDAO.updateHistoricoIngreso(hi);
	}

	@Override
	@Transactional
	public List<HistoricoIngreso> listHistoricoIngreso() {
		return this.historicoIngresoDAO.listHistoricoIngreso();
	}

	@Override
	@Transactional
	public HistoricoIngreso getHistoricoIngresoById(int id) {
		return this.historicoIngresoDAO.getHistoricoIngresoById(id);
	}

	@Override
	@Transactional
	public void removeHistoricoIngreso(int id) {
		this.historicoIngresoDAO.removeHistoricoIngreso(id);
	}
	
	@Override
	@Transactional
	public List<HistoricoIngreso> listHistoricoIngresoPorIdIngreso(int id){
		return this.historicoIngresoDAO.listHistoricoIngresoPorIdIngreso(id);
	}

}
