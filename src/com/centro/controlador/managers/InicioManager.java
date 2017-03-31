package com.centro.controlador.managers;

import java.sql.SQLException;
import java.util.ArrayList;

import com.centro.database.dao.ProductoDAO;
import com.centro.modelo.Producto;
/**
 * Clase con métodos para controlar los productos
 * @author Ane
 *
 */
public class InicioManager {

	public InicioManager(){}
	
	/**
	 * Metodo que recoge los productos que hay en la base de datos
	 * @return
	 */
	public ArrayList<Producto> obtenerProductos(){
		ArrayList<Producto> productos = new ArrayList <Producto>();
		ProductoDAO producto = new ProductoDAO();
		try {
			productos = producto.getProductos();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productos;
	}
	
}
