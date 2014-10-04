package cl.ciisa.cokedb.dao.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.model.UsuarioBeans;

public interface IUsuariosDAO {
	
	public ArrayList<UsuarioBeans> getAll()throws DAOException;
	public Integer insert(UsuarioBeans auser) throws DAOException;
	public boolean update(UsuarioBeans auser) throws DAOException;
	public boolean delete(long idauser) throws DAOException;

}
