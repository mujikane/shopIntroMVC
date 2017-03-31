package com.centro.modelo;

import java.sql.Date;
/**
 * Bean Venta
 * @author Ane
 *
 */
public class Venta {

	//Atributos
	private int idVenta, estado;
	private String fecha;
	private Cliente cli;
	

	//Getters y setters
	public int getIdCarrito() {
		return idVenta;
	}

	public void setIdCarrito(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}
		
}
