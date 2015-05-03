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
@Table(name="TA_HISTORICO_INGRESO")
public class HistoricoIngreso {

	@Id
	@Column(name="id_historico_ingreso")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="importe_ingreso")
	private float importeIngreso;
	
	@Column(name="concepto_ingreso")
	private String conceptoIngreso;
	
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name="id_ingreso")
	private int idIngreso;
	

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
	
	public String getConceptoIngreso() {
		return conceptoIngreso;
	}

	public void setConceptoIngreso(String conceptoIngreso) {
		this.conceptoIngreso = conceptoIngreso;
	}

	public Date getFechaIngreso(){
		return fechaIngreso;
	}
	
	public void setFechaIngreso(Date fechaIngreso){
		this.fechaIngreso=fechaIngreso;
	}
	
	public int getIdIngreso(){
		return idIngreso;
	}
	
	public void setIdIngreso(int idIngreso){
		this.idIngreso=idIngreso;
	}
	
	@Override
	public String toString(){
		return "id="+id+", conceptoIngreso="+conceptoIngreso+", importeIngreso="+importeIngreso+", fechaIngreso="+fechaIngreso+", idIngreso="+idIngreso;
	}
}
