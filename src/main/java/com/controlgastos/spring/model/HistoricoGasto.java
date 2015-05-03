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
@Table(name="TA_HISTORICO_GASTO")
public class HistoricoGasto {

	@Id
	@Column(name="id_historico_gasto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="importe_gasto")
	private float importeGasto;
	
	@Column(name="concepto_gasto")
	private String conceptoGasto;
	
	@Column(name="fecha_gasto")
	private Date fechaGasto;
	
	@Column(name="id_gasto")
	private int idGasto;
	

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
	
	public String getConceptoGasto() {
		return conceptoGasto;
	}

	public void setConceptoGasto(String conceptoGasto) {
		this.conceptoGasto = conceptoGasto;
	}

	public Date getFechaGasto(){
		return fechaGasto;
	}
	
	public void setFechaGasto(Date fechaGasto){
		this.fechaGasto=fechaGasto;
	}
	
	public int getIdGasto(){
		return idGasto;
	}
	
	public void setIdGasto(int idGasto){
		this.idGasto=idGasto;
	}
	
	@Override
	public String toString(){
		return "id="+id+", conceptoGasto="+conceptoGasto+", importeGasto="+importeGasto+", fechaGasto="+fechaGasto+", idGasto="+idGasto;
	}
}
