package cl.ciisa.cokedb.dao.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.model.MermaBeans;

public interface IMermaDAO {

	public ArrayList<MermaBeans> getAll() throws DAOException;
	public Integer insert(MermaBeans merma) throws DAOException;
	public boolean update(MermaBeans merma) throws DAOException;
	
}
