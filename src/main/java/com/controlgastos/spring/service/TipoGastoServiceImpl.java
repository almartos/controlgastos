package com.controlgastos.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlgastos.spring.dao.TipoGastoDAO;
import com.controlgastos.spring.model.TipoGasto;

@Service
public class TipoGastoServiceImpl implements TipoGastoService {
	
	private TipoGastoDAO tipoGastoDAO;

	public void setTipoGastoDAO(TipoGastoDAO tipoGastoDAO) {
		this.tipoGastoDAO = tipoGastoDAO;
	}

	@Override
	@Transactional
	public void addTipoGasto(TipoGasto t) {
		this.tipoGastoDAO.addTipoGasto(t);
	}

	@Override
	@Transactional
	public void updateTipoGasto(TipoGasto t) {
		this.tipoGastoDAO.updateTipoGasto(t);
	}

	@Override
	@Transactional
	public List<TipoGasto> listTipoGasto() {
		return this.tipoGastoDAO.listTipoGasto();
	}

	@Override
	@Transactional
	public TipoGasto getTipoGastoById(int id) {
		return this.tipoGastoDAO.getTipoGastoById(id);
	}

	@Override
	@Transactional
	public void removeTipoGasto(int id) {
		this.tipoGastoDAO.removeTipoGasto(id);
	}

}
