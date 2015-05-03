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
@Table(name="TA_INGRESO")
public class Ingreso {

	@Id
	@Column(name="id_ingreso")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="importe_ingreso")
	private float importeIngreso;
	
	@Column(name="nombre_ingreso")
	private String nombreIngreso;
	
	@Column(name="ingreso_fijo")
	private Boolean fijo;
	
	@Column(name="id_ingreso_global")
	private int idIngresoGlobal;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getImporteIngreso() {
		return importeIngreso;
	}

	public void setImporteIngreso(Float importeIngreso) {
		this.importeIngreso = importeIngreso;
	}
	
	public String getNombreIngreso() {
		return nombreIngreso;
	}

	public void setNombreIngreso(String nombreIngreso) {
		this.nombreIngreso = nombreIngreso;
	}

	public Boolean getFijo(){
		return fijo;
	}
	
	public void setFijo(Boolean fijo){
		this.fijo=fijo;
	}
	
	public int getIdIngresoGlobal(){
		return idIngresoGlobal;
	}
	
	public void setIdIngresoGlobal(int idIngresoGlobal){
		this.idIngresoGlobal=idIngresoGlobal;
	}
	
	@Override
	public String toString(){
		return "id="+id+", nombreIngreso="+nombreIngreso+", importeIngreso="+importeIngreso+", fijo="+fijo+", idIngresoGlobal="+idIngresoGlobal;
	}
}
