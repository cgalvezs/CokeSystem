package cl.ciisa.cokedb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cl.ciisa.cokedb.resources.Resources;

public class DataSourceFactory {
	
	private static final String BD_DRIVER = "com.mysql.jdbc.Driver";
	private static final String BD = "prueba";
	private static final String BD_URL = "jdbc:mysql://localhost/" + BD;
	private static final String BD_USER = "root";
	private static final String BD_PASSWD = "root";
	

	/**
	 * esta clase es la que decide a donde se conecta Si esta corriendo tomcat obtiene la conexion desde el contexto si no, 
	 * obtiene la conexion directamente
	 * 
	 * @return
	 * @throws DAOException
	 */
	public static Connection getConnection() throws DAOException {

		Connection con = null;

		try {
			con = getConnectionFromContext();
		} catch (DAOException e) {
			con = getConnectionDirectly();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

		return con;
	}

	private static Connection getConnectionFromContext() throws DAOException, SQLException {

		InitialContext cxt = null;
		DataSource ds = null;

		try {

			cxt = new InitialContext();
			if (cxt == null)
				throw new DAOException("No hay contexto...!");

			ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/DB_mySQL_Inventory");

			if (ds == null)
				throw new DAOException("No se ha encontrado conexion en el contexto!");

			Connection con = ds.getConnection();
			con.setAutoCommit(false);

			return con;

		} catch (NamingException e) {
			throw new DAOException(e.getMessage());
		}
	}

	private static Connection getConnectionDirectly() throws DAOException {

		Connection con = null;
		try {
			Class.forName(BD_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Error : " + e.getMessage());
		}
		try {
			con = DriverManager.getConnection(BD_URL, BD_USER, BD_PASSWD);

			con.setAutoCommit(false);
			try {
				PreparedStatement pst = con.prepareStatement("SELECT 1 FROM DUAL");
				pst.executeQuery();
				pst.close();
			} catch (Exception e) {
				con.close();
			}
		} catch (SQLException sqle) {
			throw new DAOException("DataSourceFactory.getConnectionDirectly() failed!");
		}
		return con;
	}


	/**
	 * Cierra la conecccion a la base de datos recibida como argumento solo si es distinta de la conexion estatica.
	 * 
	 * @param con
	 *            Coneccion a cerrar
	 * 
	 */
	public static void desconectar(Connection con) {

		if (con != null)
			try {
				if (!con.isClosed())
					con.close();
			} catch (SQLException sqle) {
				throw new RuntimeException("DataSourceFactory.desconetar() failed!");
			}
	}

}