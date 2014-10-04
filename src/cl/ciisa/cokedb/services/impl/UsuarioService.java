package cl.ciisa.cokedb.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import cl.ciisa.cokedb.dao.impl.UsuariosDAO;
import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.dao.impl.DataSourceFactory;

import cl.ciisa.cokedb.dao.interfaces.IUsuariosDAO;
import cl.ciisa.cokedb.model.UsuarioBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;
import cl.ciisa.cokedb.services.interfaces.IUsuarioService;

public class UsuarioService implements IUsuarioService{
	
	
	public long insert(UsuarioBeans user) throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			
			IUsuariosDAO usuarioDAO = new UsuariosDAO(con);
			
			
			long pkUsuario = usuarioDAO.insert(user);
			
			con.commit();
			return pkUsuario;
		} catch (DAOException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new LogicaException(e);
			}
			throw new LogicaException(e);
		} catch (SQLException e1) {
			try {
				con.rollback();
			} catch (SQLException e) {
				throw new LogicaException(e1);
			}
			throw new LogicaException(e1);
		} finally {
			DataSourceFactory.desconectar(con);
		}
	}
	
	public ArrayList<UsuarioBeans> getAll() throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			IUsuariosDAO usuarioDAO = new UsuariosDAO(con);
			
			return usuarioDAO.getAll();
			
		} catch (DAOException e) {
			throw new LogicaException(e);
		} finally {
			DataSourceFactory.desconectar(con);
		}
	}
	
	public boolean update(UsuarioBeans user) throws LogicaException {
		Connection con = null;
		try {
			con = DataSourceFactory.getConnection();
			
			IUsuariosDAO usuarioDAO = new UsuariosDAO(con);
			
			boolean sw = usuarioDAO.update(user);
			
			con.commit();
			return sw;
		} catch (DAOException e) {
			throw new LogicaException(e);
		} catch (SQLException e) {
			throw new LogicaException(e);
		} finally {
			DataSourceFactory.desconectar(con);
		}
	}
	
	public void delete(long id) throws LogicaException {
		Connection con = null;
		try {
			con = DataSourceFactory.getConnection();
			IUsuariosDAO usuarioDAO = new UsuariosDAO(con);
			usuarioDAO.delete(id);
			con.commit();
		} catch (DAOException e) {
			throw new LogicaException(e);
		} catch (SQLException e) {
			throw new LogicaException(e);
		} finally {
			DataSourceFactory.desconectar(con);
		}
	}

}
