package com.centro.controlador.managers;

import java.util.ArrayList;

import javax.servlet.http.Cookie;

import com.centro.modelo.Carrito;
import com.centro.modelo.Producto;

/**
 * Clase con metodos para controlar el carrito 
 * @author Ane
 *
 */
public class CarritoManager {
	
	private InicioManager im = new InicioManager();
	private Carrito pedido;
	ArrayList<Producto> productos = im.obtenerProductos();
	
	public CarritoManager(){}
	
	/**
	 * Metodo que obtiene los pedidos en un ArrayList que están en la cookie de pedidos
	 * @param cookies
	 * @return
	 */
	public ArrayList<Carrito> obtenerPedidosCarrito ( Cookie cookies[]){
		ArrayList<Carrito> pedidos = new ArrayList<Carrito> ();
		
		//Si la cookie no está vacía recorre sus cookies y las almacena en un ArrayList de pedidos
		
		if ( cookies != null && cookies.length != 0 ){ 
			for ( int i = 0; i < cookies.length; i++ ){
				String idproducto = cookies[i].getName();
				String cantidad = cookies[i].getValue();
				
				for (int j = 0; j < productos.size(); j++) {
					
					if(productos.get(j).getIdProducto().equals(idproducto)){
						pedido = new Carrito();
						int cant = Integer.parseInt(cantidad);
						
						pedido.setCantidad(cant + pedido.getCantidad());
						pedido.setProd(productos.get(j));
						
						pedidos.add(pedido);
					}
					
				}
				
			}
			
		}else{
			pedidos = null;
		}
		
		return pedidos;
	}
	
	
}
