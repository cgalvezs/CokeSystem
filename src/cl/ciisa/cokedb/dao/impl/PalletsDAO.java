package cl.ciisa.cokedb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import cl.ciisa.cokedb.dao.interfaces.IPalletsDAO;
import cl.ciisa.cokedb.model.PalletsBeans;
import cl.ciisa.cokedb.resources.Resources;

public class PalletsDAO implements IPalletsDAO{

	private Connection con = null;
	private ResourceBundle sql = null;
	
	public PalletsDAO(Connection con) {
		super();
		this.con = con;
		this.sql =  InitResource.getSQLResource(Resources.getApplication());
	}
	
	public ArrayList<PalletsBeans> getAll()throws DAOException{
		PreparedStatement stmt = null;
		try {
			stmt = this.con.prepareStatement(this.sql
					.getString("SELECT_PALLETS_ALL"));
			
			ResultSet rs = stmt.executeQuery();
			ArrayList<PalletsBeans> lstpallets = new ArrayList<PalletsBeans>();
			while (rs.next()) {
				
				PalletsBeans palletsBeans = new PalletsBeans();
				
				palletsBeans.setIdPallets(rs.getInt(1));
				palletsBeans.setNombre(rs.getString(2));
				palletsBeans.setActivo(rs.getInt(3));

				lstpallets.add(palletsBeans);
				
			}

			return lstpallets;
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
	
	public Integer insert(PalletsBeans pallets) throws DAOException {
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
		try {
			pst = con.prepareStatement(sql.getString("INSERT_PALLETS"),
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, pallets.getNombre());
			pst.setInt(2, pallets.getActivo());		
			
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
	
	public boolean update(PalletsBeans pallets) throws DAOException {
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(sql.getString("UPDATE_PALLETS"));
			//UPDATE PALLETS SET NOMBRE = ?, ACTIVO = ? WHERE IDPALLETS = ?
			
			pst.setString(1, pallets.getNombre());
			pst.setInt(2, pallets.getActivo());			
			
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
	
	public boolean delete(long idpallet) throws DAOException {
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(sql.getString("DELETE_PALLETS"));
			

			pst.setLong(1, idpallet);
			
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
