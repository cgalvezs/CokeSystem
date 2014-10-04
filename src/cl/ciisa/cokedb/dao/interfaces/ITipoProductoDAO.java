package cl.ciisa.cokedb.dao.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.model.TipoProductoBeans;

public interface ITipoProductoDAO {
	
	public ArrayList<TipoProductoBeans> getAll()throws DAOException;
	public Integer insert(TipoProductoBeans producto) throws DAOException;
	public boolean update(TipoProductoBeans producto) throws DAOException;
	public boolean delete(long idproducto) throws DAOException;

}
