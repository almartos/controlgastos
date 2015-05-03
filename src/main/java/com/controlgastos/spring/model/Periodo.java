package com.controlgastos.spring.model;

import java.util.Date;

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
@Table(name="TA_PERIODO")
public class Periodo {

	@Id
	@Column(name="id_periodo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fecha_inicio")
	private Date fechaIni;
	
	@Column(name="fecha_fin")
	private Date fechaFin;
	
	@Column(name="activo")
	private Boolean activo;
	
	@Column(name="gastos_periodo")
	private float gastosPeriodo;
	
	@Column(name="ingresos_periodo")
	private float ingresosPeriodo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin(){
		return fechaFin;
	}
	
	public void setFechaFin(Date fechaFin){
		this.fechaFin = fechaFin;
	}
	
	public Boolean getActivo(){
		return activo;
	}
	
	public void setActivo(Boolean activo){
		this.activo=activo;
	}
	
	public float getGastosPeriodo(){
		return gastosPeriodo;
	}
	
	public void setGastosPeriodo(float gastosPeriodo){
		this.gastosPeriodo=gastosPeriodo;
	}
	
	public float getIngresosPeriodo(){
		return ingresosPeriodo;
	}
	
	public void setIngresosPeriodo(float ingresosPeriodo){
		this.ingresosPeriodo=ingresosPeriodo;
	}
	
	@Override
	public String toString(){
		return "id="+id+", fechaIni="+fechaIni+", fechaFin="+fechaFin+", activo="+activo+", gastosPeriodo="+gastosPeriodo+", ingresosPeriodo="+ingresosPeriodo;
	}
}
