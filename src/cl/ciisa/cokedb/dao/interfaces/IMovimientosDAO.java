package cl.ciisa.cokedb.dao.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.model.MovimientosBeans;

public interface IMovimientosDAO {
	public Integer insert(MovimientosBeans movi) throws DAOException;
	public ArrayList<MovimientosBeans> getAll() throws DAOException;
	public boolean update(MovimientosBeans movi) throws DAOException;

}
