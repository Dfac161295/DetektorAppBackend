package com.detektorcompany.detektorcompany.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tipo_vehiculo")
public class TipoVehiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipo_vehiculo_dbid_")
	private int dbid_;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	public TipoVehiculo() {}
	
	public TipoVehiculo(int dbid_) {
		super();
		this.dbid_ = dbid_;
	}
	
	@JsonCreator
	public TipoVehiculo(@JsonProperty("dbid_") int dbid_, @JsonProperty("descripcion") String descripcion) {
		this.dbid_ = dbid_;
		this.descripcion = descripcion;
	}

	
	public int getDbid_() {
		return dbid_;
	}

	public void setDbid_(int dbid_) {
		this.dbid_ = dbid_;
	}

	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
