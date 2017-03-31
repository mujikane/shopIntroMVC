package com.centro.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centro.controlador.managers.CarritoManager;
import com.centro.database.dao.VentaDAO;
import com.centro.modelo.Carrito;
import com.centro.modelo.Cliente;
import com.centro.modelo.Pedido;
import com.centro.modelo.Venta;
import com.centro.util.DateUtil;

/**
 * Servlet implementation class ConfirmController
 */
@WebServlet(name = "confirmServlet", urlPatterns = { "/confirm" })
public class ConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CarritoManager cm = new CarritoManager();
	Cliente cli;
	ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	DateUtil du = new DateUtil();
	VentaDAO vent = new VentaDAO();
	Pedido ped = new Pedido();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmController() {    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Si se da al boton de Confirm delete
		if(request.getParameter("submit").equalsIgnoreCase("Confirm delete")){
			String codProducto = request.getParameter("radio");
			Cookie cookies[] = request.getCookies();
			ArrayList <Carrito> pedidos= cm.obtenerPedidosCarrito(cookies);
			//Se recorren las cookies de pedidos
			for (int i = 0; i < cookies.length; i++) {
				String idproducto = cookies[i].getName();
				String cantidad = cookies[i].getValue();
				
				//Si coincide con el codigo de producto
				if(codProducto.equals(idproducto)){
					
					//Se eliminan
					Cookie cookie = new Cookie(codProducto, null); // Not necessary, but saves bandwidth.
					cookie.setPath(request.getContextPath());
					cookie.setHttpOnly(true);
					cookie.setMaxAge(0); 
					response.addCookie(cookie);
				}
			}
			//Se vuelve al carrito sin las cookies eliminadas
			response.sendRedirect(request.getContextPath() + "/carrito");
		
			//Si se confirma el pedido
		}else if(request.getParameter("submit").equalsIgnoreCase("Confirm and checkout")){
			
			cli = (Cliente) request.getSession().getAttribute("usuario");	
			
			Cookie cookies[] = request.getCookies();
			ArrayList <Carrito> carrito= cm.obtenerPedidosCarrito(cookies);
			
			//Mediante el arrayList que contiene los objetos que tiene guardados de las cookies se genera el pedido
			for (int i = 0; i < carrito.size(); i++) {
				ped = new Pedido();
				ped.setCantidad(carrito.get(i).getCantidad());
				ped.setEstado("en stock");
				ped.setProducto(carrito.get(i).getProd());
				ped.setUser(cli);
				
				pedidos.add(ped);
			}
			
			//Se generan los datos necesarios para la venta
			Venta venta = new Venta();
			try {
				String fecha = du.fechaBBDD();
				venta.setFecha(fecha);
				venta.setCli(cli);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				vent.addVenta(venta, pedidos);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (int i = 0; i < carrito.size(); i++) {
				String idcarrito = carrito.get(i).getProd().getIdProducto();
				
				for (int j = 0; j < cookies.length; j++) {
					String idproducto = cookies[i].getName();
				
					//Si coincide con el codigo de producto
					if(idcarrito.equals(idproducto)){			
						//Se eliminan todas las cookies para que el carrito esté vacio
						Cookie cookie = new Cookie(idproducto, null); // Not necessary, but saves bandwidth.
						cookie.setPath(request.getContextPath());
						cookie.setHttpOnly(true);
						cookie.setMaxAge(0); 
						response.addCookie(cookie);
					}
				}
			}
			
			request.getRequestDispatcher("/jsp/confirmarPedido.jsp").forward(request, response);
		}
	}

}
