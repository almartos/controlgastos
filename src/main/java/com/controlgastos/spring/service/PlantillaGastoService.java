package com.controlgastos.spring.service;

import java.util.List;

import com.controlgastos.spring.model.PlantillaGasto;

public interface PlantillaGastoService {

	public void addPlantillaGasto(PlantillaGasto p);
	public void updatePlantillaGasto(PlantillaGasto p);
	public List<PlantillaGasto> listPlantillaGasto();
	public List<PlantillaGasto> listDistinctPlantillaGasto();
	public List<PlantillaGasto> listPlantillaGastoByName(String name);
	public PlantillaGasto getPlantillaGastoById(int id);
	public void removePlantillaGasto(int id);
	
}
