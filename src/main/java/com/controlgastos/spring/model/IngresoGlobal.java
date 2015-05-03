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
@Table(name="TA_INGRESO_GLOBAL")
public class IngresoGlobal {

	@Id
	@Column(name="id_ingreso_global")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="total_ingreso")
	private float totalIngreso;
	
	@Column(name="id_periodo")
	private int idPeriodo;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getTotalIngreso() {
		return totalIngreso;
	}

	public void setTotalIngreso(Float totalIngreso) {
		this.totalIngreso = totalIngreso;
	}
	
	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}


}
