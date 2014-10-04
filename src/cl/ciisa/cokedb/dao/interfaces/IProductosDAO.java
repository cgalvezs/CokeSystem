package cl.ciisa.cokedb.dao.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.model.ProductosBeans;

public interface IProductosDAO {
	
	public ArrayList<ProductosBeans> getAll()throws DAOException;
	public Integer insert(ProductosBeans producto) throws DAOException;
	public boolean update(ProductosBeans producto) throws DAOException;
	public boolean delete(long idproducto) throws DAOException;

}
