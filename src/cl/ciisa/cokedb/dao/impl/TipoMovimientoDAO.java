package cl.ciisa.cokedb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
//import java.text.DateFormat;

import cl.ciisa.cokedb.dao.interfaces.ITipoMovimientoDAO;
import cl.ciisa.cokedb.model.TipoMovimientoBeans;
import cl.ciisa.cokedb.resources.Resources;



public class TipoMovimientoDAO implements ITipoMovimientoDAO {

	private Connection con = null;
	private ResourceBundle sql = null;
	
	public TipoMovimientoDAO(Connection conn){
		this.con = conn;
		this.sql = InitResource.getSQLResource(Resources.getApplication());
				
	}
	
	//SELECT COMPLETO A LA TABLA 
	
	/* (non-Javadoc)
	 * @see cl.ciisa.cokedb.dao.impl.ITipoMovimientoDAO#getAll()
	 */
	@Override
	public ArrayList<TipoMovimientoBeans> getAll() throws DAOException{
		PreparedStatement stmt = null;
		try {
			stmt = this.con.prepareStatement(this.sql.getString("SELECT_TIPOSUSUARIOS_ALL"));
			
			ResultSet rs = stmt.executeQuery();
			ArrayList<TipoMovimientoBeans> lstTipoMovimiento = new ArrayList<TipoMovimientoBeans>();
			while (rs.next()){
				TipoMovimientoBeans tmovi = new TipoMovimientoBeans();
				
				tmovi.setIdTipoMovimiento(rs.getInt(1));
				tmovi.setNombre(rs.getString(2));
				tmovi.setDescripcion(rs.getString(3));
				tmovi.setActivo(rs.getInt(4));
				
				lstTipoMovimiento.add(tmovi);
				
			}
			return lstTipoMovimiento;
		} catch (SQLException e){
			throw new DAOException(e.getMessage());
		} finally {
			try {
				if (stmt != null){
					stmt.close();
				}
			}catch (SQLException e){
				throw new DAOException(e.getLocalizedMessage());
			}
		}
	}
	
	
	/* (non-Javadoc)
	 * @see cl.ciisa.cokedb.dao.impl.ITipoMovimientoDAO#insert(cl.ciisa.cokedb.model.TipoMovimientoBeans)
	 */
	@Override
	public Integer insert(TipoMovimientoBeans tmovi) throws DAOException {
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
		try {
			pst = con.prepareStatement(sql.getString("INSERT_USUARIO"),
					Statement.RETURN_GENERATED_KEYS);
			
	
			
			pst.setInt(1, tmovi.getIdTipoMovimiento());
			pst.setString(2, tmovi.getNombre());
			pst.setString(3, tmovi.getDescripcion());
			pst.setInt(4, tmovi.getActivo());
			
			
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
	
	
	/* (non-Javadoc)
	 * @see cl.ciisa.cokedb.dao.impl.ITipoMovimientoDAO#update(cl.ciisa.cokedb.model.TipoMovimientoBeans)
	 */
	@Override
	public boolean update(TipoMovimientoBeans tmovi) throws DAOException {
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(sql.getString("UPDATE_USUARIOS"));
			

			
			pst.setInt(1, tmovi.getIdTipoMovimiento());
			pst.setString(2, tmovi.getNombre());
			pst.setString(3, tmovi.getDescripcion());
			pst.setInt(4, tmovi.getActivo());
			
			
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
	
	/* (non-Javadoc)
	 * @see cl.ciisa.cokedb.dao.impl.ITipoMovimientoDAO#delete(cl.ciisa.cokedb.model.TipoMovimientoBeans)
	 */
	@Override
	public boolean delete(long idtmovi) throws DAOException {
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(sql.getString("DELETE_TIPO_PRODUCTOS"));
			

			pst.setLong(1, idtmovi);
			
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
