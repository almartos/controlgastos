package com.controlgastos.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlgastos.spring.dao.PlantillaGastoDAO;
import com.controlgastos.spring.model.PlantillaGasto;
import com.controlgastos.spring.model.PlantillaIngreso;

@Service
public class PlantillaGastoServiceImpl implements PlantillaGastoService {
	
	private PlantillaGastoDAO plantillaGastoDAO;

	public void setPlantillaGastoDAO(PlantillaGastoDAO plantillaGastoDAO) {
		this.plantillaGastoDAO = plantillaGastoDAO;
	}

	@Override
	@Transactional
	public void addPlantillaGasto(PlantillaGasto pl) {
		this.plantillaGastoDAO.addPlantillaGasto(pl);
	}

	@Override
	@Transactional
	public void updatePlantillaGasto(PlantillaGasto pl) {
		this.plantillaGastoDAO.updatePlantillaGasto(pl);
	}

	@Override
	@Transactional
	public List<PlantillaGasto> listPlantillaGasto() {
		return this.plantillaGastoDAO.listPlantillaGasto();
	}
	
	@Override
	@Transactional
	public List<PlantillaGasto> listDistinctPlantillaGasto() {
		return this.plantillaGastoDAO.listDistinctPlantillaGasto();
	}
	
	@Override
	@Transactional
	public List<PlantillaGasto> listPlantillaGastoByName(String name) {
		return this.plantillaGastoDAO.listPlantillaGastoByName(name);
	}

	@Override
	@Transactional
	public PlantillaGasto getPlantillaGastoById(int id) {
		return this.plantillaGastoDAO.getPlantillaGastoById(id);
	}

	@Override
	@Transactional
	public void removePlantillaGasto(int id) {
		this.plantillaGastoDAO.removePlantillaGasto(id);
	}

}
