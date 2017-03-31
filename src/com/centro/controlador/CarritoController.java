package com.centro.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centro.controlador.managers.CarritoManager;
import com.centro.modelo.Carrito;
import com.centro.modelo.Cliente;
import com.centro.modelo.Producto;

/**
 * Servlet implementation class CarritoController
 */
@WebServlet(name = "carritoController", urlPatterns = { "/carrito" })
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Producto prod = new Producto();
	private Cliente cli = new Cliente();
	private CarritoManager cm = new CarritoManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookies[] = request.getCookies();
		
		ArrayList <Carrito> pedidos= cm.obtenerPedidosCarrito(cookies);
		
		request.getSession().setAttribute("pedidos", pedidos);
		request.getRequestDispatcher("/jsp/carrito.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookies[] = request.getCookies();
		
		cli = (Cliente) request.getSession().getAttribute("usuario");
		prod = (Producto) request.getSession().getAttribute("producto");
		String cantidad = request.getParameter("cantidad");
		String idproducto = prod.getIdProducto();
		Cookie cookie = new Cookie(idproducto,cantidad);
		response.addCookie(cookie);
		
		cookies = request.getCookies();	
		

		request.getRequestDispatcher("/inicio").forward(request, response);
			
			
		}
		
		
		
	}


