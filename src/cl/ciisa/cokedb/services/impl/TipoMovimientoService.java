package cl.ciisa.cokedb.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import cl.ciisa.cokedb.dao.impl.TipoMovimientoDAO;
import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.dao.impl.DataSourceFactory;
import cl.ciisa.cokedb.dao.interfaces.ITipoMovimientoDAO;
import cl.ciisa.cokedb.model.TipoMovimientoBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;
import cl.ciisa.cokedb.services.interfaces.ITipoMovimientoService;

public class TipoMovimientoService implements ITipoMovimientoService{
	
	public long insert(TipoMovimientoBeans tmov) throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			
			ITipoMovimientoDAO tmovi = new TipoMovimientoDAO(con);
			
			
			long pkUsuario = tmovi.insert(tmov);
			
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
	
	public ArrayList<TipoMovimientoBeans> getAll() throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			ITipoMovimientoDAO tmovi = new TipoMovimientoDAO(con);
			
			return tmovi.getAll();
			
		} catch (DAOException e) {
			throw new LogicaException(e);
		} finally {
			DataSourceFactory.desconectar(con);
		}
	}
	
	public boolean update(TipoMovimientoBeans tmov) throws LogicaException {
		Connection con = null;
		try {
			con = DataSourceFactory.getConnection();
			
			ITipoMovimientoDAO tmovi = new TipoMovimientoDAO(con);
			
			boolean sw = tmovi.update(tmov);
			
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
			ITipoMovimientoDAO tmovi = new TipoMovimientoDAO(con);
			tmovi.delete(id);
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
