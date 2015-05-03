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
 * @author amartost
 *
 */
@Entity
@Table(name="TA_TIPO_GASTO")
public class TipoGasto {

	@Id
	@Column(name="id_tipo_gasto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre_tipo_gasto")
	private String name;
	

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


	
	@Override
	public String toString(){
		return "id="+id+", name="+name;
	}
}
