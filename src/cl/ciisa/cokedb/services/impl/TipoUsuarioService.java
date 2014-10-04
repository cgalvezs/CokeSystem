package cl.ciisa.cokedb.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.TipoUsuarioDAO;
import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.dao.impl.DataSourceFactory;
import cl.ciisa.cokedb.dao.interfaces.ITipoUsuarioDAO;
import cl.ciisa.cokedb.model.TipoUsuarioBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;
import cl.ciisa.cokedb.services.interfaces.ITipoUsuarioService;

public class TipoUsuarioService implements ITipoUsuarioService{
	
	public long insert(TipoUsuarioBeans tuser) throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			
			ITipoUsuarioDAO tUsuarioDAO = new TipoUsuarioDAO(con);
			
			
			long pkUsuario = tUsuarioDAO.insert(tuser);
			
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
	
	public ArrayList<TipoUsuarioBeans> getAll() throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			ITipoUsuarioDAO tUsuarioDAO = new TipoUsuarioDAO(con);
			
			return tUsuarioDAO.getAll();
			
		} catch (DAOException e) {
			throw new LogicaException(e);
		} finally {
			DataSourceFactory.desconectar(con);
		}
	}
	
	public boolean update(TipoUsuarioBeans tuser) throws LogicaException {
		Connection con = null;
		try {
			con = DataSourceFactory.getConnection();
			
			ITipoUsuarioDAO tUsuarioDAO = new TipoUsuarioDAO(con);
			
			boolean sw = tUsuarioDAO.update(tuser);
			
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
			ITipoUsuarioDAO tUsuarioDAO = new TipoUsuarioDAO(con);
			tUsuarioDAO.delete(id);
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
