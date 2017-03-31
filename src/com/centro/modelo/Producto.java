package com.centro.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.centro.database.dao.ProductoDAO;
/**
 * BeanProducto
 * @author Ane
 *
 */
public class Producto {
	
	//Atributos
	private String idProducto, nombre, descripcion, imagen;
	
	private double precio, precioAnterior;
	
	//Constructor
	public Producto(){}
	
	public Producto(String idProducto, String nombre, String descripcion, String imagen,
			double precio, double precioAnterior) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.precioAnterior = precioAnterior;
	}
	
	//Getters y setters
	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public double getPrecioAnterior() {
		return precioAnterior;
	}

	public void setPrecioAnterior(double precioAnterior) {
		this.precioAnterior = precioAnterior;
	}
	
	
}
