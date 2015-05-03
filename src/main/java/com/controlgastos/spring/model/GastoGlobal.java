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
@Table(name="TA_GASTO_GLOBAL")
public class GastoGlobal {

	@Id
	@Column(name="id_gasto_global")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="total_gasto")
	private float totalGasto;
	
	@Column(name="id_periodo")
	private int idPeriodo;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getTotalGasto() {
		return totalGasto;
	}

	public void setTotalGasto(Float totalGasto) {
		this.totalGasto = totalGasto;
	}
	
	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}


}
