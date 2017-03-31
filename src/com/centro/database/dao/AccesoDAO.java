package com.centro.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.centro.database.AccesoBD;
/**
 * Clase con las datos de acceso a la base de datos que heredarán las demás clase que se conectan a la bbdd
 * @author Ane
 *
 */
public class AccesoDAO {
	protected AccesoBD crearconexion;
	protected Connection con = null;

	public AccesoDAO(){
		this.con = null;
		crearconexion = new AccesoBD("mySQL","localhost","tienda", 3306, "root", "");
	}
	public Connection crearConexion() throws SQLException, ClassNotFoundException {
		
		return crearconexion.openCon(crearconexion.DRIVER_MYSQL);
	}

	public PreparedStatement getStatement(Connection con,String sql) {
		return crearconexion.getStatement(con,sql);
	}

	public void cerrarConexion(Connection con, PreparedStatement st, ResultSet rs) {
		crearconexion.closeConnection(con, st, rs);
	}
	
	public void cerrarConexion(Connection con, PreparedStatement st){
		crearconexion.closeConnection(con, st);
	}
}
