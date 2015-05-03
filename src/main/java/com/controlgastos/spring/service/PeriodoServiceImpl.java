package com.controlgastos.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlgastos.spring.dao.PeriodoDAO;
import com.controlgastos.spring.model.Periodo;

@Service
public class PeriodoServiceImpl implements PeriodoService {
	
	private PeriodoDAO periodoDAO;

	public void setPeriodoDAO(PeriodoDAO periodoDAO) {
		this.periodoDAO = periodoDAO;
	}

	@Override
	@Transactional
	public void addPeriodo(Periodo p) {
		this.periodoDAO.addPeriodo(p);
	}

	@Override
	@Transactional
	public void updatePeriodo(Periodo p) {
		this.periodoDAO.updatePeriodo(p);
	}

	@Override
	@Transactional
	public List<Periodo> listPeriodo() {
		return this.periodoDAO.listPeriodo();
	}

	@Override
	@Transactional
	public Periodo getPeriodoById(int id) {
		return this.periodoDAO.getPeriodoById(id);
	}

	@Override
	@Transactional
	public void removePeriodo(int id) {
		this.periodoDAO.removePeriodo(id);
	}

}
