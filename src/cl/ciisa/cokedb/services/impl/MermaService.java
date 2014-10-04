package cl.ciisa.cokedb.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.MermaDAO;
import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.dao.impl.DataSourceFactory;
import cl.ciisa.cokedb.dao.interfaces.IMermaDAO;
import cl.ciisa.cokedb.model.MermaBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;
import cl.ciisa.cokedb.services.interfaces.IMermasService;

public class MermaService implements IMermasService{
	
	public long insert(MermaBeans merma) throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			
			IMermaDAO mermaDAO = new MermaDAO(con);
			
			
			long pkUsuario = mermaDAO.insert(merma);
			
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
	
	public ArrayList<MermaBeans> getAll() throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			IMermaDAO mermaDAO = new MermaDAO(con);
			
			return mermaDAO.getAll();
			
		} catch (DAOException e) {
			throw new LogicaException(e);
		} finally {
			DataSourceFactory.desconectar(con);
		}
	}
	
	public boolean update(MermaBeans merma) throws LogicaException {
		Connection con = null;
		try {
			con = DataSourceFactory.getConnection();
			
			IMermaDAO mermaDAO = new MermaDAO(con);
			
			boolean sw = mermaDAO.update(merma);
			
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
