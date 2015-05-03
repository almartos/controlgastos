package com.controlgastos.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author amartos
 *
 */
@Entity
@Table(name="TA_PLANTILLA_GASTO")
public class PlantillaGasto {

	@Id
	@Column(name="id_plantilla_gasto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre_plantilla_gasto")
	private String name;
	
	@Column(name="nombre_gasto")
	private String nombreGasto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNombreGasto() {
		return nombreGasto;
	}

	public void setNombreGasto(String nombreGasto) {
		this.nombreGasto = nombreGasto;
	}

	
	@Override
	public String toString(){
		return "id="+id+", name="+name+", nombreGasto="+nombreGasto;
	}
}
