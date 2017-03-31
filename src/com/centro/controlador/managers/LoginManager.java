package com.centro.controlador.managers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import com.centro.database.dao.ClienteDAO;
import com.centro.modelo.Cliente;
/**
 * Metodos para controlar el Login
 * @author Ane
 *
 */
public class LoginManager {

	private ClienteDAO cliente;
	
	
	public LoginManager(){	}
	
	/**
	 * Metodo que devuelve un cliente con el nombre de usuario y el password, si no es correcto devuelve nulo
	 * @param user
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public Cliente login(String user, String password) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
		cliente = new ClienteDAO();
		Cliente cli = null;
		
		//Se comprueba que existe el usuario
		boolean existeCliente = cliente.existNombreUsu(user);
		
		//Si existe usuario se comprueba la contraseña
		if(existeCliente){

			String pass = cliente.getPassword(user);
						
			if(pass.equals(cli.encriptarPassword(password))){
				//Si lacontraseña coincide se guarda los datos del cliente 
				cli = cliente.seleccionarCliente(user);
			
//			if(pass.equals(password)){
//				cli= cliente.seleccionarCliente(user);
														
			}else{
			
			return cli;
			}
		}
		
		return cli;
		
	}
}
