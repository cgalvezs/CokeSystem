package cl.ciisa.cokedb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import cl.ciisa.cokedb.dao.interfaces.IMermaDAO;
import cl.ciisa.cokedb.model.MermaBeans;
import cl.ciisa.cokedb.resources.Resources;



	public class MermaDAO implements IMermaDAO {

		private Connection con = null;
		private ResourceBundle sql = null;

		public MermaDAO(Connection conn) {
			this.con = conn;
			this.sql = InitResource.getSQLResource(Resources.getApplication());
		}

		public ArrayList<MermaBeans> getAll() throws DAOException {
			PreparedStatement stmt = null;
			try {
				stmt = this.con.prepareStatement(this.sql
						.getString("SELECT_MERMA_ALL"));

				ResultSet rs = stmt.executeQuery();
				ArrayList<MermaBeans> lstMerma = new ArrayList<MermaBeans>();
				while (rs.next()) {

					MermaBeans mermaBean = new MermaBeans();

					// SELECT IDMERMA, CANTIDAD FROM MERMA
					mermaBean.setIdMerma(rs.getInt(1));
					mermaBean.setCantidad(rs.getString(2));
					

					lstMerma.add(mermaBean);

				}

				return lstMerma;
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
		
		public Integer insert(MermaBeans merma) throws DAOException {
			PreparedStatement pst = null;
			ResultSet generatedKeys = null;
			try {
				pst = con.prepareStatement(sql.getString("INSERT_MERMA"),
						Statement.RETURN_GENERATED_KEYS);
				
	//INSERT INTO MERMA (IDMERMA, CANTIDAD) VALUES (?,?)	
				
				pst.setInt(1, merma.getIdMerma());
				pst.setString(2, merma.getCantidad());
				
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
		
		public boolean update(MermaBeans merma) throws DAOException {
			PreparedStatement pst = null;

			try {
				pst = con.prepareStatement(sql.getString("UPDATE_MERMA"));

	//UPDATE MERMA IDMERMA = ?, CANTIDAD = ? WHERE IDMERMA = ?
				pst.setInt(1, merma.getIdMerma());
				pst.setString(2, merma.getCantidad());
				
				
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