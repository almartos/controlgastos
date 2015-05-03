package com.controlgastos.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlgastos.spring.dao.HistoricoGastoDAO;
import com.controlgastos.spring.model.HistoricoGasto;

@Service
public class HistoricoGastoServiceImpl implements HistoricoGastoService {
	
	private HistoricoGastoDAO historicoGastoDAO;

	public void setHistoricoGastoDAO(HistoricoGastoDAO historicoGastoDAO) {
		this.historicoGastoDAO = historicoGastoDAO;
	}

	@Override
	@Transactional
	public void addHistoricoGasto(HistoricoGasto hg) {
		this.historicoGastoDAO.addHistoricoGasto(hg);
	}

	@Override
	@Transactional
	public void updateHistoricoGasto(HistoricoGasto hg) {
		this.historicoGastoDAO.updateHistoricoGasto(hg);
	}

	@Override
	@Transactional
	public List<HistoricoGasto> listHistoricoGasto() {
		return this.historicoGastoDAO.listHistoricoGasto();
	}

	@Override
	@Transactional
	public HistoricoGasto getHistoricoGastoById(int id) {
		return this.historicoGastoDAO.getHistoricoGastoById(id);
	}

	@Override
	@Transactional
	public void removeHistoricoGasto(int id) {
		this.historicoGastoDAO.removeHistoricoGasto(id);
	}
	
	@Override
	@Transactional
	public List<HistoricoGasto>listHistoricoGastoPorIdGasto(int id){
		return this.historicoGastoDAO.listHistoricoGastoPorIdGasto(id);
	}

}
