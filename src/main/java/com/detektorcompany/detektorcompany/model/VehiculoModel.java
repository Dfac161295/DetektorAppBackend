package com.detektorcompany.detektorcompany.model;

import java.io.Serializable;

public class VehiculoModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String placa;
	
	private int dbid_propietario;
	
	private int dbid_tipo_vehiculo;
	
	private String vin;
	
	private String marca;
	
	private String cilindrada;
	
	private String color;
	
	private String chasis;
	
	private String modelo;
	
	public VehiculoModel() {}

	public VehiculoModel(String placa, int dbid_propietario, int dbid_tipo_vehiculo, String vin, String marca,
			String cilindrada, String color, String chasis, String modelo) {
		super();
		this.placa = placa;
		this.dbid_propietario = dbid_propietario;
		this.dbid_tipo_vehiculo = dbid_tipo_vehiculo;
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

	public int getDbid_propietario() {
		return dbid_propietario;
	}

	public void setDbid_propietario(int dbid_propietario) {
		this.dbid_propietario = dbid_propietario;
	}

	public int getDbid_tipo_vehiculo() {
		return dbid_tipo_vehiculo;
	}

	public void setDbid_tipo_vehiculo(int dbid_tipo_vehiculo) {
		this.dbid_tipo_vehiculo = dbid_tipo_vehiculo;
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
