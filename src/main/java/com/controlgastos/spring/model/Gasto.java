package com.controlgastos.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author amartos
 *
 */
@Entity
@Table(name="TA_GASTO")
public class Gasto {

	@Id
	@Column(name="id_gasto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="importe_gasto")
	private float importeGasto;
	
	@Column(name="nombre_gasto")
	private String nombreGasto;
	
	@Column(name="gasto_fijo")
	private Boolean fijo;
	
	@Column(name="id_gasto_global")
	private int idGastoGlobal;
	
	@Column(name="acumulado_historico")
	private float acumuladoHistorico;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getImporteGasto() {
		return importeGasto;
	}

	public void setImporteGasto(Float importeGasto) {
		this.importeGasto = importeGasto;
	}
	
	public String getNombreGasto() {
		return nombreGasto;
	}

	public void setNombreGasto(String nombreGasto) {
		this.nombreGasto = nombreGasto;
	}

	public Boolean getFijo(){
		return fijo;
	}
	
	public void setFijo(Boolean fijo){
		this.fijo=fijo;
	}
	
	public int getIdGastoGlobal(){
		return idGastoGlobal;
	}
	
	public void setIdGastoGlobal(int idGastoGlobal){
		this.idGastoGlobal=idGastoGlobal;
	}
	
	public float getAcumuladoHistorico(){
		return acumuladoHistorico;
	}
	
	public void setAcumuladoHistorico(float acumuladoHistorico){
		this.acumuladoHistorico=acumuladoHistorico;
	}
	
	@Override
	public String toString(){
		return "id="+id+", nombreGasto="+nombreGasto+", importeGasto="+importeGasto+", fijo="+fijo+", idGastoGlobal="+idGastoGlobal+", acumuladoHistorico="+acumuladoHistorico;
	}
}
