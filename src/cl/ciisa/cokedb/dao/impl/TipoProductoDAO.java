package cl.ciisa.cokedb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import cl.ciisa.cokedb.dao.interfaces.ITipoProductoDAO;
import cl.ciisa.cokedb.model.TipoProductoBeans;
import cl.ciisa.cokedb.resources.Resources;

public class TipoProductoDAO implements ITipoProductoDAO {

	private Connection con = null;
	private ResourceBundle sql = null;
	
	public TipoProductoDAO(Connection con) {
		super();
		this.con = con;
		this.sql =  InitResource.getSQLResource(Resources.getApplication());
	}
	
	public ArrayList<TipoProductoBeans> getAll()throws DAOException{
		PreparedStatement stmt = null;
		try {
			stmt = this.con.prepareStatement(this.sql
					.getString("SELECT_TIPO_PRODUCTOS"));
			
			ResultSet rs = stmt.executeQuery();
			ArrayList<TipoProductoBeans> lstproductos = new ArrayList<TipoProductoBeans>();
			while (rs.next()) {
				
				TipoProductoBeans tipoProductosBeans = new TipoProductoBeans();
				
				
				
				tipoProductosBeans.setIdTipoProducto(rs.getInt(1));
				tipoProductosBeans.setNombre(rs.getString(2));				
				tipoProductosBeans.setDescripcion(rs.getString(3));				
				tipoProductosBeans.setActivo(rs.getInt(4));				
				
				lstproductos.add(tipoProductosBeans);
				
			}

			return lstproductos;
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
	
	public Integer insert(TipoProductoBeans producto) throws DAOException {
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
		try {
			pst = con.prepareStatement(sql.getString("INSERT_TIPO_PRODUCTOS"),
					Statement.RETURN_GENERATED_KEYS);
			
			
			pst.setString(1, producto.getNombre());
			pst.setString(2, producto.getDescripcion());			
			pst.setInt(3, producto.getActivo());
		
			
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
	
	public boolean update(TipoProductoBeans producto) throws DAOException {
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(sql.getString("UPDATE_TIPO_PRODUCTOS"));
			

			pst.setString(1, producto.getNombre());
			pst.setString(2, producto.getDescripcion());
			
			
			
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
	
	public boolean delete(long idproducto) throws DAOException {
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(sql.getString("DELETE_TIPO_PRODUCTOS"));
			

			pst.setLong(1, idproducto);
			
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

