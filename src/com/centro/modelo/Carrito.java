package com.centro.modelo;

/**
 * Bean Carrito
 * @author Ane
 *
 */
public class Carrito {

	//Atributos
	private Producto prod;
	private int cantidad;
	
	public Carrito(){}


	public Producto getProd() {
		return prod;
	}

	public void setProd(Producto prod) {
		this.prod = prod;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
		
	
}
