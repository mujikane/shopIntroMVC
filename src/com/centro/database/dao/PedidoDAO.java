package com.centro.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.centro.modelo.Pedido;

/**
 * Clase de tipo Pedido que se conecta a la base datos, hereda de AccesoDAO
 * 
 * @author Ane
 *
 */
public class PedidoDAO extends AccesoDAO {

	public PedidoDAO() {
	}

	/**
	 * Se añade un pedido a la base de datos obteniendo la id que se genera
	 * 
	 * @param pedido
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int addPedido(Pedido pedido) throws SQLException,
			ClassNotFoundException {
		Connection con;

		con = crearConexion();
		PreparedStatement st = null;
		ResultSet idGenerado = null;
		Double precio = pedido.getCantidad() * pedido.getProducto().getPrecio();

		String SQL = "INSERT INTO `tienda`.`pedido` (`cantidad`, `cliente`, `producto`, `precio`) VALUES  (?, ?, ?, ?)";

		st = con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
		st.setInt(1, pedido.getCantidad());
		st.setString(2, pedido.getUser().getNombreUsu());
		st.setString(3, pedido.getProducto().getIdProducto());
		st.setDouble(4, precio);

		st.executeUpdate();

		// Se obtiene el id del pedido
		idGenerado = st.getGeneratedKeys();
		idGenerado.next();
		int idPedido = idGenerado.getInt(1);

		super.cerrarConexion(con, st, idGenerado);

		return idPedido;

	}
}
