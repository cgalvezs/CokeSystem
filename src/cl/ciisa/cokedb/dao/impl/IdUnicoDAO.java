package cl.ciisa.cokedb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import cl.ciisa.cokedb.dao.interfaces.IIdUnicoDAO;
import cl.ciisa.cokedb.model.IdUnicoBeans;
import cl.ciisa.cokedb.resources.Resources;

public class IdUnicoDAO implements IIdUnicoDAO{

	private Connection con = null;
	private ResourceBundle sql = null;
	
	public IdUnicoDAO(Connection con) {
		super();
		this.con = con;
		this.sql =  InitResource.getSQLResource(Resources.getApplication());
	}
	
	public ArrayList<IdUnicoBeans> getAll()throws DAOException{
		PreparedStatement stmt = null;
		try {
			stmt = this.con.prepareStatement(this.sql
					.getString("SELECT_IDUNICA_ALL"));
			
			ResultSet rs = stmt.executeQuery();
			ArrayList<IdUnicoBeans> lstUnico = new ArrayList<IdUnicoBeans>();
			while (rs.next()) {
				
				IdUnicoBeans IdUnicoBeans = new IdUnicoBeans();
				
				IdUnicoBeans.setIdUnico(rs.getInt(1));
				IdUnicoBeans.setIdProducto(rs.getInt(2));
				
				
				
				lstUnico.add(IdUnicoBeans);
				
			}
			return lstUnico;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}
	
	
	
	public Integer insert(IdUnicoBeans producto) throws DAOException {
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
		try {
			pst = con.prepareStatement(sql.getString("INSERT_IDUNICA"),
					Statement.RETURN_GENERATED_KEYS);
			
			
			pst.setInt(1, producto.getIdUnico());
			pst.setInt(2, producto.getIdProducto());
			
			
			if (pst.executeUpdate() != 1)
				throw new DAOException("No se pudo insertar la solicitud");

			generatedKeys = pst.getGeneratedKeys();
			generatedKeys.first();
			ResultSetMetaData rsmd = generatedKeys.getMetaData();
			if (rsmd.getColumnCount() > 1) {
				throw new DAOException("Se genero mas de una llave");
			}
			
			//con.commit();
			return generatedKeys.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (generatedKeys != null)
					generatedKeys.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean update(IdUnicoBeans producto) throws DAOException {
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(sql.getString("UPDATE IDUNICO"));
			
	//UPDATE IDUNICO SET PRODUCTOS_IDPRODUCTOS = ?, MERMA_IDMERMA = ? WHERE IDIDUNICO = ?
			

			pst.setInt(1, producto.getIdUnico());
			pst.setInt(2, producto.getIdProducto());
			
			
			
			int rs = pst.executeUpdate();
			return (rs == 1);

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}

