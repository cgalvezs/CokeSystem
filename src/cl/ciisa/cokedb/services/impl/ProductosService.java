package cl.ciisa.cokedb.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import cl.ciisa.cokedb.dao.impl.ProductosDAO;
import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.dao.impl.DataSourceFactory;
import cl.ciisa.cokedb.dao.interfaces.IProductosDAO;
import cl.ciisa.cokedb.model.ProductosBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;
import cl.ciisa.cokedb.services.interfaces.IProductosService;

public class ProductosService implements IProductosService{
	
	public long insert(ProductosBeans prod) throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			
			IProductosDAO producDAO = new ProductosDAO(con);
			
			
			long pkUsuario = producDAO.insert(prod);
			
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
	
	public ArrayList<ProductosBeans> getAll() throws LogicaException{
		Connection con = null;
		try {
			
			con = DataSourceFactory.getConnection();
			IProductosDAO producDAO = new ProductosDAO(con);
			
			return producDAO.getAll();
			
		} catch (DAOException e) {
			throw new LogicaException(e);
		} finally {
			DataSourceFactory.desconectar(con);
		}
	}
	
	public boolean update(ProductosBeans prod) throws LogicaException {
		Connection con = null;
		try {
			con = DataSourceFactory.getConnection();
			
			IProductosDAO producDAO = new ProductosDAO(con);
			
			boolean sw = producDAO.update(prod);
			
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
			IProductosDAO producDAO = new ProductosDAO(con);
			producDAO.delete(id);
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
