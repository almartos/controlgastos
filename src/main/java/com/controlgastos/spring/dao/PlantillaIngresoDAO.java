package com.controlgastos.spring.dao;

import java.util.List;

import com.controlgastos.spring.model.PlantillaIngreso;
import com.controlgastos.spring.model.TipoIngreso;

public interface PlantillaIngresoDAO {

	public void addPlantillaIngreso(PlantillaIngreso pl);
	public void updatePlantillaIngreso(PlantillaIngreso pl);
	public List<PlantillaIngreso> listPlantillaIngreso();
	public List<PlantillaIngreso> listDistinctPlantillaIngreso();
	public List<PlantillaIngreso> listPlantillaIngresoByName(String name);
	public PlantillaIngreso getPlantillaIngresoById(int id);
	public void removePlantillaIngreso(int id);
	
	//public void addTiposIngreso(PlantillaIngreso pl, TipoIngreso t);
	//public void removeTiposIngreso(int id1, int id2);
	//public List<PlantillaIngreso> listTiposIngreso(int id1);
	
}
