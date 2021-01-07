package com.badbadcode.application.models.entity;

import java.util.Date;

public class Producto {

	private Long id;
	private String nombre;
	private Double precio;
	private Date fecha;
	
	private Integer port;
	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
	
}