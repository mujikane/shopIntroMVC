package com.centro.controlador;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.centro.controlador.managers.ProfileManager;
import com.centro.modelo.Cliente;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet(name = "profileController", urlPatterns = { "/profile" })
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession sesion;
	private Cliente cli;
	private ProfileManager pm = new ProfileManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileController() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//Se  dirige al Perfil del usuario
		request.getRequestDispatcher("jsp/profile.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		cli = (Cliente) request.getSession().getAttribute("usuario");
		//Si se pulsa al boton de guardar cambios, se actualiza la base de datos
		if (request.getParameter("submit").equals("Save changes")) {
			String nombreUsu = cli.getNombreUsu();
			String dni = request.getParameter("dni");
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String direccion = request.getParameter("direccion");
			int telefono = 0;
			
			//Se hacen validaciones de los datos, aunque se podría hacer muchas más
			if (request.getParameter("telefono") == null
					|| request.getParameter("telefono") == "") {
				telefono = 0;
			} else {
				telefono = Integer.parseInt(request.getParameter("telefono"));
			}

			if (sonDistintos(cli.getDni(), dni)) {
				cli.setDni(dni);
			}

			if (sonDistintos(cli.getNombre(), nombre)) {
				cli.setNombre(nombre);
			}

			if (sonDistintos(cli.getApellidos(), apellidos)) {
				cli.setApellidos(apellidos);
			}

			if (sonDistintos(cli.getEmail(), email)) {
				cli.setEmail(email);
			}

			if (sonDistintos(cli.getDireccion(), direccion)) {
				cli.setDireccion(direccion);
			}
			
			if(!pass.equalsIgnoreCase("")){
				try {
				
					String newPass = Cliente.encriptarPassword(pass);
				
					if (sonDistintos(cli.getPass(), newPass)) {
						cli.setPass(newPass);
					}
				
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}	
			}
			
			if (telefono != 0) {
				if (telefono != cli.getTelefono()) {
					cli.setTelefono(telefono);
				}
			}

			//Se actualiza al usuario en la base de datos
			try {
				pm.actualizarUsuario(cli);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			//Se vuelve al perfil conlos cambios realizados
			request.setAttribute("usuario", cli);
			request.getRequestDispatcher("jsp/profile.jsp").forward(request,
					response);
			//Si se pulsa al boton de eliminar usuario se dirige a una confirmación
		} else if (request.getParameter("submit").equals("Unsubscribe")) {
			
			request.getRequestDispatcher("jsp/confirmarEliminacion.jsp")
					.forward(request, response);
		}
	}

	/**
	 * Metodo que compara si son iguales dos valores
	 * @param valorAnterior
	 * @param valorNuevo
	 * @return
	 */
	public boolean sonDistintos(String valorAnterior, String valorNuevo) {
		boolean ok = true;
		if (valorNuevo == null || valorNuevo == "" || valorNuevo == " ") {
			ok = false;
		} else if ((valorNuevo.equals(valorAnterior))) {
			ok = false;

		} else {
			ok = true;
		}
		return ok;

	}

}
