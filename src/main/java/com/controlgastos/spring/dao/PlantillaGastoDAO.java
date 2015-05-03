package com.controlgastos.spring.dao;

import java.util.List;

import com.controlgastos.spring.model.PlantillaGasto;
import com.controlgastos.spring.model.PlantillaIngreso;
import com.controlgastos.spring.model.TipoGasto;

public interface PlantillaGastoDAO {

	public void addPlantillaGasto(PlantillaGasto pl);
	public void updatePlantillaGasto(PlantillaGasto pl);
	public List<PlantillaGasto> listPlantillaGasto();
	public List<PlantillaGasto> listDistinctPlantillaGasto();
	public List<PlantillaGasto> listPlantillaGastoByName(String name);
	public PlantillaGasto getPlantillaGastoById(int id);
	public void removePlantillaGasto(int id);
	
	//public void addTiposIngreso(PlantillaIngreso pl, TipoIngreso t);
	//public void removeTiposIngreso(int id1, int id2);
	//public List<PlantillaIngreso> listTiposIngreso(int id1);
	
}
