package cl.ciisa.cokedb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.text.DateFormat;

import cl.ciisa.cokedb.dao.interfaces.ITipoUsuarioDAO;
import cl.ciisa.cokedb.model.TipoProductoBeans;
import cl.ciisa.cokedb.model.TipoUsuarioBeans;
import cl.ciisa.cokedb.model.UsuarioBeans;
import cl.ciisa.cokedb.resources.Resources;

public class TipoUsuarioDAO implements ITipoUsuarioDAO {

	private Connection con = null;
	private ResourceBundle sql = null;
	
	public TipoUsuarioDAO(Connection conn){
		this.con = conn;
		this.sql = InitResource.getSQLResource(Resources.getApplication());
				
	}
	
	//SELECT COMPLETO A LA TABLA 
	
	/* (non-Javadoc)
	 * @see cl.ciisa.cokedb.dao.impl.ITipoUsuarioDAO#getAll()
	 */
	@Override
	public ArrayList<TipoUsuarioBeans> getAll() throws DAOException{
		PreparedStatement stmt = null;
		try {
			stmt = this.con.prepareStatement(this.sql.getString("SELECT_TIPOSUSUARIOS_ALL"));
			
			ResultSet rs = stmt.executeQuery();
			ArrayList<TipoUsuarioBeans> lstTipoUsuario = new ArrayList<TipoUsuarioBeans>();
			while (rs.next()){
				TipoUsuarioBeans tipousuarioBeans = new TipoUsuarioBeans();
				
				tipousuarioBeans.setId_tipo(rs.getInt(1));
				tipousuarioBeans.setNombre(rs.getString(2));
				tipousuarioBeans.setDesc(rs.getString(3));
				tipousuarioBeans.setActivo(rs.getBoolean(4));
				
				lstTipoUsuario.add(tipousuarioBeans);
				
			}
			return lstTipoUsuario;
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
	 * @see cl.ciisa.cokedb.dao.impl.ITipoUsuarioDAO#insert(cl.ciisa.cokedb.model.TipoUsuarioBeans)
	 */
	@Override
	public Integer insert(TipoUsuarioBeans tipouser) throws DAOException {
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
		try {
			pst = con.prepareStatement(sql.getString("INSERT_USUARIO"),
					Statement.RETURN_GENERATED_KEYS);
			
	
			
			pst.setInt(1, tipouser.getId_tipo());
			pst.setString(2, tipouser.getNombre());
			pst.setString(3, tipouser.getDesc());
			pst.setBoolean(4, tipouser.isActivo());
			
			
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
	 * @see cl.ciisa.cokedb.dao.impl.ITipoUsuarioDAO#update(cl.ciisa.cokedb.model.TipoUsuarioBeans)
	 */
	@Override
	public boolean update(TipoUsuarioBeans tipouser) throws DAOException {
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(sql.getString("UPDATE_USUARIOS"));
			

			
			pst.setInt(1, tipouser.getId_tipo());
			pst.setString(2, tipouser.getNombre());
			pst.setString(3, tipouser.getDesc());
			pst.setBoolean(4, tipouser.isActivo());
			
			
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
	 * @see cl.ciisa.cokedb.dao.impl.ITipoUsuarioDAO#delete(cl.ciisa.cokedb.model.TipoUsuarioBeans)
	 */
	@Override
	public boolean delete(long idtipouser) throws DAOException {
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(sql.getString("DELETE_TIPO_PRODUCTOS"));
			

			pst.setLong(1, idtipouser);
			
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
