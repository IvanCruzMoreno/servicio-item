package com.badbadcode.application.models;

public class Item {

	private Producto producto;
	private Integer cantidad;
	
	public Item() {
		
	}
	public Item(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getTotal() {
		return producto.getPrecio() * cantidad;
	}
	
}
