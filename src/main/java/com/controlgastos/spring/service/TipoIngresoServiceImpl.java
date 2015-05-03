package com.controlgastos.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlgastos.spring.dao.TipoIngresoDAO;
import com.controlgastos.spring.model.TipoIngreso;

@Service
public class TipoIngresoServiceImpl implements TipoIngresoService {
	
	private TipoIngresoDAO tipoIngresoDAO;

	public void setTipoIngresoDAO(TipoIngresoDAO tipoIngresoDAO) {
		this.tipoIngresoDAO = tipoIngresoDAO;
	}

	@Override
	@Transactional
	public void addTipoIngreso(TipoIngreso t) {
		this.tipoIngresoDAO.addTipoIngreso(t);
	}

	@Override
	@Transactional
	public void updateTipoIngreso(TipoIngreso t) {
		this.tipoIngresoDAO.updateTipoIngreso(t);
	}

	@Override
	@Transactional
	public List<TipoIngreso> listTipoIngreso() {
		return this.tipoIngresoDAO.listTipoIngreso();
	}

	@Override
	@Transactional
	public TipoIngreso getTipoIngresoById(int id) {
		return this.tipoIngresoDAO.getTipoIngresoById(id);
	}

	@Override
	@Transactional
	public void removeTipoIngreso(int id) {
		this.tipoIngresoDAO.removeTipoIngreso(id);
	}

}
