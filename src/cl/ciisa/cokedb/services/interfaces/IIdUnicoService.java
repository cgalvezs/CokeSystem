package cl.ciisa.cokedb.services.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.model.IdUnicoBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;

public interface IIdUnicoService {
	
	public long insert(IdUnicoBeans iduser) throws LogicaException;
	public ArrayList<IdUnicoBeans> getAll() throws LogicaException;
	public boolean update(IdUnicoBeans iduser) throws LogicaException;

}
