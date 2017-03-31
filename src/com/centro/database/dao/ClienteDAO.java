package com.centro.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.centro.modelo.Cliente;

/**
 * Clase de tipo Cliente que se conecta a la base datos, hereda de AccesoDAO
 * 
 * @author Ane
 *
 */
public class ClienteDAO extends AccesoDAO {

	private Cliente cli = new Cliente();

	public ClienteDAO() {
		super();
	}

	/**
	 * Consulta que indica si existe el usuario
	 * 
	 * @throws ClassNotFoundException
	 */
	public boolean existNombreUsu(String nombreUsuario) throws SQLException,
			ClassNotFoundException {

		Connection con = crearConexion();
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean existe = false;

		String SQL = "SELECT nombreUsu FROM cliente WHERE nombreUsu = ?";
		st = con.prepareStatement(SQL);
		st.setString(1, nombreUsuario);
		rs = st.executeQuery();

		if (rs.next()) {

			String usu = rs.getString("nombreUsu");

			if (usu != null) {
				existe = true;
			}

			super.cerrarConexion(con, st, rs);

			return existe;

		} else {
			super.cerrarConexion(con, st, rs);
			return existe;
		}
	}

	/**
	 * Consulta que recoge la contraseña del usuario
	 * 
	 * @throws ClassNotFoundException
	 */
	public String getPassword(String nombreUsuario) throws SQLException,
			ClassNotFoundException {

		String pass;
		Connection con = crearConexion();
		PreparedStatement st = null;
		ResultSet rs = null;

		String SQL = "SELECT password FROM cliente WHERE nombreUsu = ?";
		st = con.prepareStatement(SQL);
		st.setString(1, nombreUsuario);
		rs = st.executeQuery();

		if (rs.next()) {

			pass = rs.getString("password");
			super.cerrarConexion(con, st, rs);

			return pass;

		} else {
			super.cerrarConexion(con, st, rs);
			return null;
		}
	}

	/**
	 * Consulta que recoge el cliente seleccionado
	 * 
	 * @param nombreUsu
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Cliente seleccionarCliente(String nombreUsu) throws SQLException,
			ClassNotFoundException {

		cli = new Cliente();

		Connection con = crearConexion();
		PreparedStatement st = null;
		ResultSet rs = null;

		String SQL = "SELECT * FROM cliente WHERE nombreUsu = ?";
		st = con.prepareStatement(SQL);
		st.setString(1, nombreUsu);
		rs = st.executeQuery();

		if (rs.next()) {

			cli.setNombreUsu(rs.getString("nombreUsu"));
			cli.setDni(rs.getString("dni"));
			cli.setNombre(rs.getString("nombre"));
			cli.setApellidos(rs.getString("apellidos"));
			cli.setEmail(rs.getString("email"));
			cli.setDireccion(rs.getString("direccion"));
			cli.setTelefono(rs.getInt("telefono"));
			cli.setPass(rs.getString("password"));

			super.cerrarConexion(con, st, rs);

			return cli;

		} else {

			super.cerrarConexion(con, st, rs);

			return cli;
		}

	}

	/**
	 * Se añade usuario a la base de datos
	 * 
	 * @param clie
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addClient(Cliente clie) throws ClassNotFoundException,
			SQLException {

		Connection con;

		con = crearConexion();
		PreparedStatement st = null;

		String SQL = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		st = con.prepareStatement(SQL);
		st.setString(1, clie.getNombreUsu());
		st.setString(2, clie.getPass());
		st.setString(3, clie.getEmail());
		st.setString(4, clie.getNombre());
		st.setString(5, clie.getApellidos());
		st.setString(6, clie.getDni());
		st.setString(7, clie.getDireccion());
		st.setInt(8, clie.getTelefono());

		st.executeUpdate();

		super.cerrarConexion(con, st);

	}

	/**
	 * Se actualiza los datos del usuario
	 * 
	 * @param clie
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void updateClient(Cliente clie) throws ClassNotFoundException,
			SQLException {

		Connection con;

		con = crearConexion();
		PreparedStatement st = null;

		String SQL = "UPDATE cliente SET password = ?, email = ?, nombre = ?, apellidos = ?, dni = ?, direccion = ?, telefono = ? WHERE nombreUsu = ?";

		st = con.prepareStatement(SQL);

		st.setString(1, clie.getPass());
		st.setString(2, clie.getEmail());
		st.setString(3, clie.getNombre());
		st.setString(4, clie.getApellidos());
		st.setString(5, clie.getDni());
		st.setString(6, clie.getDireccion());
		st.setInt(7, clie.getTelefono());
		st.setString(8, clie.getNombreUsu());

		st.executeUpdate();

		super.cerrarConexion(con, st);

	}

	/**
	 * Se elimina a un usuario por el nombre de usuario
	 * 
	 * @param clie
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void borrarUsuario(Cliente clie) throws ClassNotFoundException,
			SQLException {
		Connection con;

		con = crearConexion();
		PreparedStatement st = null;

		String SQL = "DELETE FROM `tienda`.`cliente` WHERE `nombreUsu`=?;";

		st = con.prepareStatement(SQL);
		st.setString(1, clie.getNombreUsu());

		st.executeUpdate();

		super.cerrarConexion(con, st);
	}

}
