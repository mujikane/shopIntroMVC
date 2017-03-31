package com.centro.controlador.managers;

import java.util.ArrayList;

import com.centro.modelo.Producto;
/**
 * Metodos par controlar los productos
 * @author Ane
 *
 */
public class ProductoManager {
	
	public ProductoManager(){}
	
	/**
	 * Metodo que obtiene un producto de un ArrayList de productos
	 * @param productos
	 * @param prod
	 * @return
	 */
	public Producto getProducto (ArrayList<Producto> productos, String prod){
		Producto producto = new Producto();
		
		for (int i = 0; i < productos.size(); i++) {
			if(productos.get(i).getIdProducto().equals(prod)){
				producto =  productos.get(i);
				return producto;
			}
		}
		
		return producto;
	}

}
