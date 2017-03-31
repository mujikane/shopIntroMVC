package com.centro.controlador.managers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.centro.database.dao.ClienteDAO;
import com.centro.modelo.Cliente;
/**
 * Metodos para controlar el registro del usuario
 * @author Ane
 *
 */
public class RegisterManager {

	private String nombreUsuario;
	private ClienteDAO cliente;
	private Cliente cli;
	
	public RegisterManager(){}
	
	/**
	 * Metodo que devuelve true si el nombre de usuario es válido y false si no lo es
	 * @param nombreUsuario
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean nombreValido(String nombreUsuario) throws ClassNotFoundException, SQLException{
		cliente = new ClienteDAO();
		boolean ok = false;
		
		if(nombreUsuario !=null || nombreUsuario == ""){
		
			ok = cliente.existNombreUsu(nombreUsuario);
		}
		
		return ok;
	}
	
	/**
	 * Metodo que devuelve true si dos password coinciden
	 * @param pass1
	 * @param pass2
	 * @return
	 */
	public boolean passwordOk (String pass1, String pass2){
		boolean passOk=false;
		if(pass1 != null || pass2 != null || pass1 != "" || pass2 != ""){
			if(pass1.equals(pass2)){
				passOk = true;
			}
		}
		return passOk;
	}
	
	public String getValor (String valor){
		String valorNuevo = "";
		if(valor == null || valor ==""){
			
			return valorNuevo;
		}else{
			return valor;
		}
	}
	
	public void nuevoCliente(Cliente clie) throws ClassNotFoundException, SQLException{
		cli = new Cliente();
		String pass;
		try {
			pass = cli.encriptarPassword(clie.getPass());
			clie.setPass(pass);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		cliente.addClient(clie);
		
	}
}
