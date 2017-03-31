package com.centro.controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centro.database.dao.ClienteDAO;
import com.centro.modelo.Cliente;

/**
 * Servlet implementation class UnsuscribeController
 */
@WebServlet(name = "unsuscribeController", urlPatterns = { "/unsuscribe" })
public class UnsuscribeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnsuscribeController() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cli = (Cliente) request.getSession().getAttribute("usuario");
		//Si se da al botón de borrar usuario que lo borre y sino que vaya a inicio
		if(request.getParameter("submit").equalsIgnoreCase("Yes")){
			ClienteDAO cliente = new ClienteDAO();
			try {
				//Se borra al cliente de la base de datos pero no los datos de pedidos por si se quierellevar uncontrol de ventas
				cliente.borrarUsuario(cli);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			//Se elimina también la sesión para que vaya al login
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/inicio");
			
		}else if(request.getParameter("submit").equalsIgnoreCase("No")){
			//Si no se quiere borrar vuelve a inicio
			response.sendRedirect(request.getContextPath() + "/inicio");
		}
	}

}
