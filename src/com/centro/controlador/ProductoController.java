package com.centro.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centro.controlador.managers.InicioManager;
import com.centro.controlador.managers.ProductoManager;
import com.centro.modelo.Cliente;
import com.centro.modelo.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet(name = "productoController", urlPatterns = { "/producto" })

public class ProductoController extends HttpServlet {
	
	Producto producto = new Producto();
	ArrayList<Producto> productos = new ArrayList<Producto>();
	ProductoManager pm = new ProductoManager();
	InicioManager im = new InicioManager();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Se dirige al detalle del producto con los datos necesario
		String prod = request.getParameter("prod");
		productos = im.obtenerProductos();
		producto = pm.getProducto(productos, prod);
		
		Cliente cli = (Cliente) request.getSession().getAttribute("usuario");
		request.getSession().setAttribute("producto", producto);
		request.getRequestDispatcher("/jsp/producto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Se dirige al detalle del producto con los datos necesarios
		Producto prod = (Producto) request.getSession().getAttribute("producto");
		Cliente cli = (Cliente) request.getSession().getAttribute("usuario");
		request.getRequestDispatcher("/jsp/producto.jsp").forward(request, response);
		
	}

}
