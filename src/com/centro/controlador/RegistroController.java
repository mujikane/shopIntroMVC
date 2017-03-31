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

import com.centro.controlador.managers.RegisterManager;
import com.centro.modelo.Cliente;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "registroController", urlPatterns = { "/registro" })
public class RegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegisterManager rm = new RegisterManager();
    boolean nomOk = true;
	boolean passOk = true;
	private String nombreExistente = null;
	private String passMal = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroController() { }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Se dirige al registro
		request.getRequestDispatcher("jsp/registro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("nombreUsu");
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		String pass1 = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");
		String direccion = request.getParameter("direccion");
		String tel = request.getParameter("telefono");
		int telefono = 0;
		
		if(tel == "" || tel == null){
			telefono = 0;
		}else{
			Integer.parseInt(tel);
		}
			
		Cliente cli = (Cliente) request.getSession().getAttribute("usuario");
		
		//Se comprueba primero que no ha llegado ningun valor requerido vacio
			if(apellidos != null || dni != null || user != null || email != null || nombre != null){
				if(apellidos != "" || dni != "" || user != "" || email != "" || nombre != ""){
					
					try {
						//Se coomprueba que el nombre del usuario no existe y si existe se envia un mensaje de error
						if(rm.nombreValido(user)){
							nomOk = false;
							nombreExistente = "The user " + user + " is already exist"; 
							request.getSession().setAttribute("nombreExistente", nombreExistente);
						}else{
							nomOk = true;
							nombreExistente = null;
							request.getSession().setAttribute("nombreExistente", nombreExistente);
						}
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//Se comprueba que las dos contraseñas que se piden coinciden
					if(rm.passwordOk(pass1, pass2)){
						passOk = true;
						passMal = null;
						request.getSession().setAttribute("passMal", passMal);
					}else{
						passOk = false;
						passMal = "Passwords do not match";
						request.getSession().setAttribute("passMal", passMal);
					}
					
					//Se guardan en un oobjeto Cliente sus valores para despues guardarlos en sesión y poder usar sus valores en adelante
					cli.setApellidos(apellidos);
					cli.setDireccion(direccion);
					cli.setDni(dni);
					cli.setEmail(email);
					cli.setNombre(nombre);
					cli.setNombreUsu(user);
					cli.setPass(pass1);
					cli.setTelefono(telefono);
					
					request.getSession().setAttribute("usuario", cli);
					
					//Si el nombre de usuario y la contraseña son válidos se envía a la página de inicio con sus datos y se guardan en la bbdd
					//sino se vuelve a enviar a la pagina de registro con los valores que había metido guardados para que no tenga que volver a ponerlos
					//y sólo tenga que cambiar lo que no es correcto
					if(passOk && nomOk ){
						try {
							rm.nuevoCliente(cli);
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						request.getRequestDispatcher("/inicio").forward(request, response);
					}else{
						request.getRequestDispatcher("jsp/registro.jsp").forward(request, response);
					}
				}
			}
			
		
	
	}
	
		
	}


