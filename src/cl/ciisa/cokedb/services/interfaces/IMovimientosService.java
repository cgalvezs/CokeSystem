package cl.ciisa.cokedb.services.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.model.MovimientosBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;

public interface IMovimientosService {
	
	public long insert(MovimientosBeans movi) throws LogicaException;
	public ArrayList<MovimientosBeans> getAll() throws LogicaException;
	public boolean update(MovimientosBeans movi) throws LogicaException;

}
