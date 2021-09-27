package com.detektorcompany.detektorcompany.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String placa;
	
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "propietario_fk", referencedColumnName = "propietario_dbid_")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Propietario propietario;
	
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_vehiculo_fk", referencedColumnName = "tipo_vehiculo_dbid_")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoVehiculo tipo_vehiculo;
	
	@Column(name = "vin", nullable = false)
	private String vin;
	
	@Column(name = "marca", nullable = false)
	private String marca;
	
	@Column(name = "cilindrada", nullable = false)
	private String cilindrada;
	
	@Column(name = "color", nullable = false)
	private String color;
	
	@Column(name = "chasis", nullable = false)
	private String chasis;
	
	@Column(name = "modelo", nullable = false)
	private String modelo;

	public Vehiculo() {
		super();
	}

	@JsonCreator
	public Vehiculo(@JsonProperty("placa") String placa,@JsonProperty("propietario") Propietario propietario,
			@JsonProperty("tipo_vehiculo") TipoVehiculo tipo_vehiculo,
			@JsonProperty("vin") String vin,
			@JsonProperty("marca") String marca,
			@JsonProperty("cilindrada") String cilindrada,
			@JsonProperty("color") String color,
			@JsonProperty("chasis") String chasis,
			@JsonProperty("modelo")String modelo) {
		this.placa = placa;
		this.propietario = propietario;
		this.tipo_vehiculo = tipo_vehiculo;
		this.vin = vin;
		this.marca = marca;
		this.cilindrada = cilindrada;
		this.color = color;
		this.chasis = chasis;
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public TipoVehiculo getTipo_vehiculo() {
		return tipo_vehiculo;
	}

	public void setTipo_vehiculo(TipoVehiculo tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
	
	
}
