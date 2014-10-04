package cl.ciisa.cokedb.services.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.model.TipoMovimientoBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;

public interface ITipoMovimientoService {
	
	public long insert(TipoMovimientoBeans tmov) throws LogicaException;
	public ArrayList<TipoMovimientoBeans> getAll() throws LogicaException;
	public boolean update(TipoMovimientoBeans tmov) throws LogicaException;

}
