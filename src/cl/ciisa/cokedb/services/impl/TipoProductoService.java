package cl.ciisa.cokedb.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import cl.ciisa.cokedb.dao.impl.TipoProductoDAO;
import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.dao.impl.DataSourceFactory;
import cl.ciisa.cokedb.dao.interfaces.ITipoProductoDAO;
import cl.ciisa.cokedb.model.TipoProductoBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;
import cl.ciisa.cokedb.services.interfaces.ITipoProductoService;


public class TipoProductoService implements ITipoProductoService{

	public long insert(TipoProductoBeans tprod) throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			
			ITipoProductoDAO tipoProDAO = new TipoProductoDAO(con);
			
			
			long pkUsuario = tipoProDAO.insert(tprod);
			
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
	
	public ArrayList<TipoProductoBeans> getAll() throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			ITipoProductoDAO tipoProDAO = new TipoProductoDAO(con);
			
			return tipoProDAO.getAll();
			
		} catch (DAOException e) {
			throw new LogicaException(e);
		} finally {
			DataSourceFactory.desconectar(con);
		}
	}
	
	public boolean update(TipoProductoBeans tprod) throws LogicaException {
		Connection con = null;
		try {
			con = DataSourceFactory.getConnection();
			
			ITipoProductoDAO tipoProDAO = new TipoProductoDAO(con);
			
			boolean sw = tipoProDAO.update(tprod);
			
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
			ITipoProductoDAO tipoProDAO = new TipoProductoDAO(con);
			tipoProDAO.delete(id);
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
