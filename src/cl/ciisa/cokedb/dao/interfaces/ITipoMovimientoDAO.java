package cl.ciisa.cokedb.dao.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.model.TipoMovimientoBeans;

public interface ITipoMovimientoDAO {

	public abstract ArrayList<TipoMovimientoBeans> getAll() throws DAOException;

	public abstract Integer insert(TipoMovimientoBeans tmovi)
			throws DAOException;

	public abstract boolean update(TipoMovimientoBeans tmovi)
			throws DAOException;

	public boolean delete(long idtmovi) throws DAOException;

}