package com.controlgastos.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlgastos.spring.dao.GastoDAO;
import com.controlgastos.spring.model.Gasto;

@Service
public class GastoServiceImpl implements GastoService {
	
	private GastoDAO gastoDAO;

	public void setGastoDAO(GastoDAO gastoDAO) {
		this.gastoDAO = gastoDAO;
	}

	@Override
	@Transactional
	public void addGasto(Gasto g) {
		this.gastoDAO.addGasto(g);
	}

	@Override
	@Transactional
	public void updateGasto(Gasto g) {
		this.gastoDAO.updateGasto(g);
	}

	@Override
	@Transactional
	public List<Gasto> listGasto() {
		return this.gastoDAO.listGasto();
	}
	
	@Override
	@Transactional
	public List<Gasto> listGastoByIdGasGlobal(int id) {
		return this.gastoDAO.listGastoByIdGasGlobal(id);
	}

	@Override
	@Transactional
	public Gasto getGastoById(int id) {
		return this.gastoDAO.getGastoById(id);
	}

	@Override
	@Transactional
	public void removeGasto(int id) {
		this.gastoDAO.removeGasto(id);
	}

}
