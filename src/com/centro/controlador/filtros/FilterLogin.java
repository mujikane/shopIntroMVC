package com.centro.controlador.filtros;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.centro.controlador.managers.LoginManager;
import com.centro.modelo.Cliente;

/**
 * El filtro FilterLogin controla el acceso a la aplicacion, para ello se controla que el usuario cuando quiera acceder al contenido 
 * de la web (por medio del servlet InicioController, /inicio) a trav�s de un formulario de inicio de sesi�n, no puede si no est� registrado
 * 
 * - Si introduce bien los datos, se crear� una sesion con sus datos, y le dirigir� a la p�gina de bienvenida donde podr� hacer 
 * uso de la aplicaci�n.
 * - Si introduce alguno de los campos requeridos mal le dirigir� a una p�gina de error donde podr� reintentarlo
 * 
 * �sto ocurrir� cada vez que quiera acceder a inicio
 * 
 * En la primera l�nea de c�digo se define la activaci�n del filtro mediante la directiva:
 * @WebFilter(filterName = "filterLogin", urlPatterns = { "/inicio/*" })
 * 
 * Esto equivale a lo que se pondr�a en web/WEB-INF/lib/web.xml:
 * <filter>
 * 		<filter-name>filterLogin</filter-name>
 * 		<filter-class>controlador/filtros/FilterLogin</filter-class>
 * </filter>
 * 
 * <filter-mapping>
 * 		<filter-name>filterLogin</filter-name>
 * 		<url-pattern>/inicio/*</url-pattern> -->Cada vez que se quiera acceder a inicio, saltar� el filtro definido
 * </filter-mapping>
 * 
 */

@WebFilter(filterName = "filterLogin", urlPatterns = { "/inicio/*" })
public class FilterLogin implements Filter {
	
	//Se crea un atributo global de tipo Cliente
	private Cliente cli = null;
	private LoginManager loginManager;
	private HttpSession sesion;
	int i = 0;

    /**
     * Default constructor. 
     */
    public FilterLogin() {    }

	/**
	 * Es un filtro que si el nombre de usuario o el password no son correctos da error y no deja entrar
	 * en la p�gina de inicio
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		sesion = ((HttpServletRequest) request).getSession();
		
		//Recoge el nombre de usuario y el password que se ha introducido en el login
		
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		
		if(username != null && password != null){
		try {
				
			loginManager = new LoginManager();
			cli = loginManager.login(username, password);
			
		} catch (ClassNotFoundException | SQLException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		if(cli != null){
			
			//Se guarda el usuario y su nombre de usuario	
			((HttpServletRequest) request).getSession().setAttribute("usuario",cli);
						
			//y dejar� pasar a servlet inicio
			chain.doFilter(request, response);
			
		}else{
					
			cli = null;
			//Si hay alg�n error, nos dirigir� a una p�gina de error
			String sc = "jsp/errorAutentificacion.jsp";
			//Se hace casting del response que llega porque no es HttpServletResponse y sino no podemos llegar a la p�gina de error
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			//Nos env�a a la pagina de error
			httpResponse.sendRedirect(sc);
		}
		
		}else{
			//y dejar� pasar a servlet inicio
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {}


	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}
	
}
