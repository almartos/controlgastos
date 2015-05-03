package com.controlgastos.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlgastos.spring.dao.PlantillaIngresoDAO;
import com.controlgastos.spring.model.PlantillaIngreso;

@Service
public class PlantillaIngresoServiceImpl implements PlantillaIngresoService {
	
	private PlantillaIngresoDAO plantillaIngresoDAO;

	public void setPlantillaIngresoDAO(PlantillaIngresoDAO plantillaIngresoDAO) {
		this.plantillaIngresoDAO = plantillaIngresoDAO;
	}

	@Override
	@Transactional
	public void addPlantillaIngreso(PlantillaIngreso pl) {
		this.plantillaIngresoDAO.addPlantillaIngreso(pl);
	}

	@Override
	@Transactional
	public void updatePlantillaIngreso(PlantillaIngreso pl) {
		this.plantillaIngresoDAO.updatePlantillaIngreso(pl);
	}

	@Override
	@Transactional
	public List<PlantillaIngreso> listPlantillaIngreso() {
		return this.plantillaIngresoDAO.listPlantillaIngreso();
	}
	
	
	@Override
	@Transactional
	public List<PlantillaIngreso> listDistinctPlantillaIngreso() {
		return this.plantillaIngresoDAO.listDistinctPlantillaIngreso();
	}
	
	@Override
	@Transactional
	public List<PlantillaIngreso> listPlantillaIngresoByName(String name) {
		return this.plantillaIngresoDAO.listPlantillaIngresoByName(name);
	}
	

	@Override
	@Transactional
	public PlantillaIngreso getPlantillaIngresoById(int id) {
		return this.plantillaIngresoDAO.getPlantillaIngresoById(id);
	}

	@Override
	@Transactional
	public void removePlantillaIngreso(int id) {
		this.plantillaIngresoDAO.removePlantillaIngreso(id);
	}

}
