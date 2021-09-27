package com.detektorcompany.detektorcompany.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "propietario")
public class Propietario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "propietario_dbid_")
	private int dbid_;
	
	@Column(name = "nombres", nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_nacimiento", nullable = false, updatable = false)
	private Date fecha_nacimiento;
	
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@Column(name = "telefono", nullable = false)
	private String telefono;

	@Column(name = "email", nullable = false)
	private String email;
	
	public Propietario() {}
	
	
	public Propietario(int dbid_) {
		super();
		this.dbid_ = dbid_;
	}
	
	
	
	@JsonCreator
	public Propietario(@JsonProperty("dbid_") int dbid_, @JsonProperty("nombres") String nombres,
			@JsonProperty("apellidos") String apellidos,@JsonProperty("fecha_nacimiento") Date fecha_nacimiento, 
			@JsonProperty("direccion") String direccion,@JsonProperty("telefono") String telefono,
			@JsonProperty("email") String email) {
		this.dbid_ = dbid_;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	
    
	public int getDbid_() {
		return dbid_;
	}
	public void setDbid_(int dbid_) {
		this.dbid_ = dbid_;
	}
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
