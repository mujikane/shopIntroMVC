package com.centro.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centro.controlador.managers.InicioManager;
import com.centro.modelo.Cliente;
import com.centro.modelo.Producto;

/**
 * Servlet implementation class InicioController, ser� el servlet que nos dirija al contenido despu�s de haber pasado el filtro de autenti-
 * ficaci�n (que no haya espacios en los caracteres que se introducen en el formulario de inicio de sesi�n).
 * Aqu� ya tendremos los datos de sesi�n.
 * 
 * En la primera l�nea de c�digo se define el servlet mediante la directiva:
 * @WebServlet(name = "inicio", urlPatterns = { "/inicio" })
 * 
 * Esto equivale a lo que se pondr�a en web/WEB-INF/lib/web.xml:
 * <servlet>
 * 		<servlet-name>inicio</servlet-name>
 * 		<servlet-class>controlador/InicioController</servlet-class>
 * </servlet>
 * 
 * <servlet>
 * 		<servlet-name>inicio</servlet-name>
 * 		<url-pattern>/inicio</url-pattern> 
 * </servlet>
 */
@WebServlet(name = "inicioController", urlPatterns = { "/inicio" })
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Cliente cli;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioController() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Si la sesion de usuario no es nula que vaya a inicio y sino que vaya al login
		if(request.getSession().getAttribute("usuario") != null){
			
			cli = (Cliente)request.getSession().getAttribute("usuario");
			
				if( cli.getNombreUsu()!= null){
					//Que obtenga los productos y los almacene en una sesi�n
					ArrayList<Producto> productos = new ArrayList <Producto>(); 
					InicioManager im = new InicioManager();
					productos = im.obtenerProductos();
					request.setAttribute("productos", productos);
					request.getRequestDispatcher("/jsp/inicio.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
				}
		}else{
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}

	/**
	 * M�todo que nos dirige a la p�gina de inicio, inicio.jsp. Mediante la interface HttpServletRequest request se accede a los deta-
	 * lles de una peticion HTTP.
	 * Se envia informaci�n al servidor que tiene que dirigirle a la pagina de inicio.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Si la sesion no es nula que vaya a inicio sino al login
		if(request.getSession().getAttribute("usuario") != null){
			cli = (Cliente)request.getSession().getAttribute("usuario");
				if( cli.getNombreUsu()!= null){
					ArrayList<Producto> productos = new ArrayList <Producto>(); 
					InicioManager im = new InicioManager();
					productos = im.obtenerProductos();
					request.setAttribute("productos", productos);
					request.getRequestDispatcher("/jsp/inicio.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
				}
		}else{
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	
	}

}
