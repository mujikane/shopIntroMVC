package com.centro.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.centro.modelo.Pedido;
import com.centro.modelo.Producto;
import com.centro.modelo.Venta;
import com.centro.util.DateUtil;

/**
 * Clase de tipo Venta que se conecta a la base de datos, hereda de AccesoDAO
 * 
 * @author Ane
 *
 */
public class VentaDAO extends AccesoDAO {

	private DateUtil du = new DateUtil();
	private PedidoDAO ped = new PedidoDAO();

	public VentaDAO() {
	}

	/**
	 * Metodo que añade la venta mediante transacción
	 * 
	 * @param venta
	 * @param pedidos
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addVenta(Venta venta, ArrayList<Pedido> pedidos)
			throws ClassNotFoundException, SQLException {

		Connection con;

		con = crearConexion();
		// No se hará ninguna operacióncontra la bd hasta que no se invoque el
		// 'commit'
		con.setAutoCommit(false);
		PreparedStatement st = null;
		ResultSet idGenerado = null;

		// Primero se inserta la venta
		String SQL = "INSERT INTO `tienda`.`venta` (`estado`, `nombreUsu`, `fecha`) VALUES (?, ?, ?);";

		st = con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
		st.setString(1, "en proceso");
		st.setString(2, venta.getCli().getNombreUsu());
		st.setString(3, venta.getFecha());

		st.executeUpdate();

		// Se obtiene el id de la venta
		idGenerado = st.getGeneratedKeys();
		idGenerado.next();
		int idVenta = idGenerado.getInt(1);
		System.out.println(idVenta);

		// Se añaden los pedidos
		for (int i = 0; i < pedidos.size(); i++) {
			// Se añaden los codProductos y CodVentas correspondientes
			int idPedido = ped.addPedido(pedidos.get(i));
			System.out.println(idPedido);
			addPedidoVenta(con, idPedido, idVenta);
		}

		// Valida todas las operaciones realizadas
		con.commit();

		super.cerrarConexion(con, st, idGenerado);
	}

	/**
	 * Metodo rpivado que se usa en añadir Venta que añade el PedidoVenta
	 * 
	 * @param con
	 * @param codPedido
	 * @param codVenta
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private void addPedidoVenta(Connection con, int codPedido, int codVenta)
			throws SQLException, ClassNotFoundException {
		PreparedStatement st = null;

		String SQL = "INSERT INTO `tienda`.`ventaPedido` (`idventa`, `idpedido`) VALUES (?, ?);";
		st = con.prepareStatement(SQL);
		st.setInt(1, codVenta);
		st.setInt(2, codPedido);

		st.executeUpdate();

		st.close();
	}

}
