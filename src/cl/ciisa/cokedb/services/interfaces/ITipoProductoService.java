package cl.ciisa.cokedb.services.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.model.TipoProductoBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;

public interface ITipoProductoService {
	
	public long insert(TipoProductoBeans tprod) throws LogicaException;
	public ArrayList<TipoProductoBeans> getAll() throws LogicaException;
	public boolean update(TipoProductoBeans tprod) throws LogicaException;
	public void delete(long id) throws LogicaException;

}
