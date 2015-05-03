package com.controlgastos.spring.service;

import java.util.List;

import com.controlgastos.spring.model.PlantillaIngreso;

public interface PlantillaIngresoService {

	public void addPlantillaIngreso(PlantillaIngreso p);
	public void updatePlantillaIngreso(PlantillaIngreso p);
	public List<PlantillaIngreso> listPlantillaIngreso();
	public List<PlantillaIngreso> listDistinctPlantillaIngreso();
	public List<PlantillaIngreso> listPlantillaIngresoByName(String name);
	public PlantillaIngreso getPlantillaIngresoById(int id);
	public void removePlantillaIngreso(int id);
	
}
