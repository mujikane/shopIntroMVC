package com.centro.controlador.managers;

import java.sql.SQLException;

import com.centro.database.dao.ClienteDAO;
import com.centro.modelo.Cliente;

/**
 * Metodos para actualizar el perfil
 * @author Ane
 *
 */
public class ProfileManager {
	
	private ClienteDAO cli = new ClienteDAO();
	
	public ProfileManager(){}
	
	/**
	 * Metodo que actualiza al usuario
	 * @param cliente
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void actualizarUsuario(Cliente cliente) throws ClassNotFoundException, SQLException{
		cli.updateClient(cliente);
	}

}
