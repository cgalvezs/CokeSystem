package cl.ciisa.cokedb.dao.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.model.TipoUsuarioBeans;

public interface ITipoUsuarioDAO {

	public abstract ArrayList<TipoUsuarioBeans> getAll() throws DAOException;

	public abstract Integer insert(TipoUsuarioBeans tipouser)
			throws DAOException;

	public abstract boolean update(TipoUsuarioBeans tipouser)
			throws DAOException;

	public boolean delete(long idtipouser) throws DAOException;

}