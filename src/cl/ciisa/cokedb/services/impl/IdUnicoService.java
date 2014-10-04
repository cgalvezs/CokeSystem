package cl.ciisa.cokedb.services.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.IdUnicoDAO;
import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.dao.impl.DataSourceFactory;
import cl.ciisa.cokedb.dao.interfaces.IIdUnicoDAO;
import cl.ciisa.cokedb.model.IdUnicoBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;
import cl.ciisa.cokedb.services.interfaces.IIdUnicoService;

public class IdUnicoService implements IIdUnicoService{
	
	public long insert(IdUnicoBeans iduser) throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			
			IIdUnicoDAO idUnicoDAO = new IdUnicoDAO(con);
			
			
			long pkUsuario = idUnicoDAO.insert(iduser);
			
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
	
	public ArrayList<IdUnicoBeans> getAll() throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			IIdUnicoDAO idUnicoDAO = new IdUnicoDAO(con);
			
			return idUnicoDAO.getAll();
			
		} catch (DAOException e) {
			throw new LogicaException(e);
		} finally {
			DataSourceFactory.desconectar(con);
		}
	}
	
	public boolean update(IdUnicoBeans iduser) throws LogicaException {
		Connection con = null;
		try {
			con = DataSourceFactory.getConnection();
			
			IIdUnicoDAO idUnicoDAO = new IdUnicoDAO(con);
			
			boolean sw = idUnicoDAO.update(iduser);
			
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
	
}
