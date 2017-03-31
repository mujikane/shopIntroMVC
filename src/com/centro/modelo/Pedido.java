package com.centro.modelo;

import java.sql.Date;
/**
 * Bean Pedido
 * @author Ane
 *
 */
public class Pedido {
	
	//Atributos
	private int idpedido, cantidad;
	private String fecha;
	private String estado;
	private Producto producto;
	private Cliente user;
	
	public Pedido(){}

	//Getters y setters
	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cliente getUser() {
		return user;
	}

	public void setUser(Cliente user) {
		this.user = user;
	}
		

}
