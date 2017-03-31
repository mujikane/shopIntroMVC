package com.centro.database;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que contiene datos y metodos para la gestión de bases de datos
 * @author Ane
 *
 */
public class AccesoBD {
	//DRIVERS
		public static final String DRIVER_GEN = "sun.jdbc.odbc.JdbcOdbcDriver";
		
		public static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
		public static final String DRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";
		public static final String DRIVER_DB2 = "COM.ibm.db2.jdbc.net.DB2Driver";
		public static final String DRIVER_SYBASE = "com.sybase.jdbc.SybDriver";
		public static final String DRIVER_SQL_LITE = "org.sqlite.JDBC";
		
		private String dbURLtype, hostname, databaseName, user, password,driver;
		private int port;
		
		//Constructor
		
		public AccesoBD(String dbURLtype, String hostname, String databaseName, int port, String user, String password){
			this.dbURLtype = dbURLtype;
			this.hostname = hostname;
			this.databaseName = databaseName;
			this.port = port;
			this.user = user;
			this.password = password;
			
		}
		
		/**
		 * Cargar el driver a través del cargador de clases.
		 * Es privado porque quiero que se use la más generica que es la de openCon que hace todo lo de la conexión
		 * @param driver
		 */
		private void selectDriver(String driver){
			//DRIVERS
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Error al cargar el driver");
			}
		}
		
		/**
		 * Con los datos del constructor, dependiendo de la base de datos recibiremos la url del servidor
		 * @return
		 */
		private String getDB_URL(){
			//DB_URLS
			if(dbURLtype.equalsIgnoreCase("MySQL")){
				return "jdbc:mysql://"+hostname+"/"+databaseName;
			}else if(dbURLtype.equalsIgnoreCase("Oracle")){
				return "jdbc:oracle:thin:@"+hostname+":" + port + ":" + databaseName;
			}else if(dbURLtype.equalsIgnoreCase("IBM")){
				return "jdbc:db2:" + hostname + ":" + port + "/" + databaseName;
			}else if(dbURLtype.equalsIgnoreCase("Sqlite")){
				return databaseName;
			}else{
				return null;
			}
		}
		
		/**
		 * Utilizar DriverManager para la conexión
		 * @return
		 */
		public Connection openCon(String driver) throws SQLException, ClassNotFoundException{
			//Llamamos al metodo que nos devuelve La URL de la Base de datos
			selectDriver(driver);
			String dbURL = getDB_URL();
			
			Connection conexion = null;
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				conexion = DriverManager.getConnection(dbURL, user, password);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error en la conexión");
			}
			return conexion;
		}
		/**
		 * Utilizar DriverManager para la conexión de sqlite, no tiene user ni password
		 * @return
		 * @throws SQLException 
		 */
		public Connection openCon() throws SQLException, ClassNotFoundException{
			//Llamamos al metodo que nos devuelve La URL de la Base de datos
			selectDriver(driver);
			String dbURL = getDB_URL();
			
			Connection conexion = null;
			
			System.out.println(getDB_URL());
			
				conexion = DriverManager.getConnection(dbURL);
			
			return conexion;
		}
		/**
		 * Crear flujo
		 * @param con Enviamos la conexion realizada previamente 
		 * @return
		 */
		public PreparedStatement getStatement(Connection con, String sql){
			PreparedStatement st = null;
			try {
				st = con.prepareStatement(sql);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al realizar la comunicación (Statement)");
			}
			return st;
		}
		
		
		
		/**
		 * Cerramos la conexión, primero cerramos ResultSet,luego la comunicación y luego la Conexión. Lo usaremos siempre que se muestre algo
		 * @param con Le enviamos la conexión
		 * @param st Le enviamos la comunicación
		 * @param rs Le enciamos el ResultSet
		 */
		public void closeConnection(Connection con, PreparedStatement st, ResultSet rs){
			try {
				if (rs != null){
					rs.close();
					rs = null;
				}
				if(st !=null){
					st.close();
					st = null;
				}
				if ( con != null && !con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al cerrar la conexión");
			}
		}
		/**
		 * Cerramos la comunicación y luego la Conexión, Lo usamos para actualizaciones: Insertar, modificar o borrar
		 * @param con Le enviamos la conexión
		 * @param st Le enviamos la comunicacion
		 */
		public void closeConnection(Connection con, PreparedStatement st){
			
			try {
				
				if(st !=null){
					st.close();
					st = null;
				}
				if ( con != null && !con.isClosed()){
					con.close();
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al cerrar la conexión");
			}
		}
}
