package com.centro.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.centro.modelo.Producto;

/**
 * Clase de tipo Producto que se conecta a la base datos, hereda de AccesoDAO
 * 
 * @author Ane
 *
 */
public class ProductoDAO extends AccesoDAO {

	private Producto pro;

	public ProductoDAO() {
	}

	/**
	 * Metodo que obtiene todos los productos de la base de datos
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Producto> getProductos() throws ClassNotFoundException,
			SQLException {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Connection con = crearConexion();
		PreparedStatement st = null;
		ResultSet rs = null;

		String SQL = "SELECT * FROM producto";
		st = con.prepareStatement(SQL);
		rs = st.executeQuery();

		while (rs.next()) {

			pro = new Producto();

			pro.setIdProducto(rs.getString("idproducto"));
			pro.setNombre(rs.getString("nombre"));
			pro.setDescripcion(rs.getString("descripcion"));
			pro.setPrecio(rs.getDouble("precio"));
			pro.setImagen(rs.getString("imagen"));
			pro.setPrecioAnterior(rs.getDouble("precioAnterior"));

			productos.add(pro);

		}

		super.cerrarConexion(con, st, rs);

		return productos;
	}

}
