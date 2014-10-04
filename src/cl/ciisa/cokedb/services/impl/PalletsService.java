package cl.ciisa.cokedb.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.PalletsDAO;
import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.dao.impl.DataSourceFactory;
import cl.ciisa.cokedb.dao.interfaces.IPalletsDAO;
import cl.ciisa.cokedb.model.PalletsBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;
import cl.ciisa.cokedb.services.interfaces.IPalletsService;

public class PalletsService implements IPalletsService{
	
	public long insert(PalletsBeans pallet) throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			
			IPalletsDAO palletsDAO = new PalletsDAO(con);
			
			
			long pkUsuario = palletsDAO.insert(pallet);
			
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
	
	public ArrayList<PalletsBeans> getAll() throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			IPalletsDAO palletsDAO = new PalletsDAO(con);
			
			return palletsDAO.getAll();
			
		} catch (DAOException e) {
			throw new LogicaException(e);
		} finally {
			DataSourceFactory.desconectar(con);
		}
	}
	
	public boolean update(PalletsBeans pallet) throws LogicaException {
		Connection con = null;
		try {
			con = DataSourceFactory.getConnection();
			
			IPalletsDAO palletsDAO = new PalletsDAO(con);
			
			boolean sw = palletsDAO.update(pallet);
			
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
			IPalletsDAO palletsDAO = new PalletsDAO(con);
			palletsDAO.delete(id);
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
