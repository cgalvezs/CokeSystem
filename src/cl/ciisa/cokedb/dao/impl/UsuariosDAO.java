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

import cl.ciisa.cokedb.dao.interfaces.IUsuariosDAO;
import cl.ciisa.cokedb.model.TipoUsuarioBeans;
import cl.ciisa.cokedb.model.UsuarioBeans;
import cl.ciisa.cokedb.resources.Resources;

public class UsuariosDAO implements IUsuariosDAO{
	
	private Connection con = null;
	private ResourceBundle sql = null;
	
	public UsuariosDAO(Connection conn) {
		this.con = conn;
		this.sql = InitResource.getSQLResource(Resources.getApplication());
	}
	
	//SELECT COMPLETO A LA TABLA AREA_DESC
	
	public ArrayList<UsuarioBeans> getAll()throws DAOException{
		PreparedStatement stmt = null;
		try {
			stmt = this.con.prepareStatement(this.sql
					.getString("SELECT_USUARIOS_ALL"));
			
			ResultSet rs = stmt.executeQuery();
			ArrayList<UsuarioBeans> lstUsuarios = new ArrayList<UsuarioBeans>();
			while (rs.next()) {
				
				UsuarioBeans usuariosBean = new UsuarioBeans();
				
				usuariosBean.setIdUsuario(rs.getInt(1));
				usuariosBean.setNombreUsuario(rs.getString(2));
				usuariosBean.setNombre(rs.getString(3));
				usuariosBean.setApellidos(rs.getString(4));
				usuariosBean.setPassword(rs.getString(5));
				usuariosBean.setTipoUsuario(rs.getInt(6));
				usuariosBean.setActivo(rs.getInt(7));
				
				
				lstUsuarios.add(usuariosBean);
				
			}

			return lstUsuarios;
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
	
	
	
	public Integer insert(UsuarioBeans auser) throws DAOException {
		PreparedStatement pst = null;
		ResultSet generatedKeys = null;
		try {
			pst = con.prepareStatement(sql.getString("INSERT_USUARIO"),
					Statement.RETURN_GENERATED_KEYS);
			
//INSERT INTO USUARIOS (NOMBRE_USUARIO, NOMBRE, APELLIDOS, PASSWORD, ACTIVO, TIPO_USUARIOS) VALUES (?,?,?,?,?,?)	
			
			pst.setString(1, auser.getNombreUsuario());
			pst.setString(2, auser.getNombre());
			pst.setString(3, auser.getApellidos());
			pst.setString(4, auser.getPassword());
			pst.setInt(5, auser.getActivo());
			pst.setInt(6, auser.getTipoUsuario());
			
		
			
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
	
	public boolean update(UsuarioBeans auser) throws DAOException {
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(sql.getString("UPDATE_USUARIOS"));
			
//UPDATE USUARIOS SET NOMBRE_USUARIO = ?, NOMBRE = ?, APELLIDOS = ?, PASSWORD = ?, ACTIVO = ?, TIPO_USUARIOS = ? WHERE IDUSUARIOS = ?
			pst.setString(1, auser.getNombreUsuario());
			pst.setString(2, auser.getNombre());
			pst.setString(3, auser.getApellidos());
			pst.setString(4, auser.getPassword());
			pst.setInt(5, auser.getActivo());
			pst.setInt(6, auser.getTipoUsuario());
			
			
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
	
	public boolean delete(long idauser) throws DAOException {
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(sql.getString("DELETE_USUARIOS"));
			

			pst.setLong(1, idauser);
			
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

