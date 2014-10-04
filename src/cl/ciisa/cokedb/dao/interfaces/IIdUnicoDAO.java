package cl.ciisa.cokedb.dao.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.model.IdUnicoBeans;

public interface IIdUnicoDAO {

	public ArrayList<IdUnicoBeans> getAll()throws DAOException;
	public Integer insert(IdUnicoBeans producto) throws DAOException;
	public boolean update(IdUnicoBeans producto) throws DAOException;
}
