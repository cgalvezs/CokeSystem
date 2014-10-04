package cl.ciisa.cokedb.services.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.model.TipoUsuarioBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;

public interface ITipoUsuarioService {

	public long insert(TipoUsuarioBeans tuser) throws LogicaException;
	public ArrayList<TipoUsuarioBeans> getAll() throws LogicaException;
	public boolean update(TipoUsuarioBeans tuser) throws LogicaException;
	
}
