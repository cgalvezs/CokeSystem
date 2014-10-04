package cl.ciisa.cokedb.dao.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.dao.impl.DAOException;
import cl.ciisa.cokedb.model.PalletsBeans;

public interface IPalletsDAO {
	
	public ArrayList<PalletsBeans> getAll()throws DAOException;
	public Integer insert(PalletsBeans pallets) throws DAOException;
	public boolean update(PalletsBeans pallets) throws DAOException;
	public boolean delete(long idpallet) throws DAOException;

}
