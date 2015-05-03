package com.controlgastos.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlgastos.spring.dao.GastoGlobalDAO;
import com.controlgastos.spring.model.GastoGlobal;

@Service
public class GastoGlobalServiceImpl implements GastoGlobalService {
	
	private GastoGlobalDAO gastoGlobalDAO;

	public void setGastoGlobalDAO(GastoGlobalDAO gastoGlobalDAO) {
		this.gastoGlobalDAO = gastoGlobalDAO;
	}

	@Override
	@Transactional
	public void addGastoGlobal(GastoGlobal gg) {
		this.gastoGlobalDAO.addGastoGlobal(gg);
	}

	@Override
	@Transactional
	public void updateGastoGlobal(GastoGlobal gg) {
		this.gastoGlobalDAO.updateGastoGlobal(gg);
	}

	@Override
	@Transactional
	public List<GastoGlobal> listGastoGlobal() {
		return this.gastoGlobalDAO.listGastoGlobal();
	}

	@Override
	@Transactional
	public GastoGlobal getGastoGlobalById(int id) {
		return this.gastoGlobalDAO.getGastoGlobalById(id);
	}

	@Override
	@Transactional
	public void removeGastoGlobal(int id) {
		this.gastoGlobalDAO.removeGastoGlobal(id);
	}

}
