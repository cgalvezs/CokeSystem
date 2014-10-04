package cl.ciisa.cokedb.services.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.model.UsuarioBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;

public interface IUsuarioService {
	
	public long insert(UsuarioBeans user) throws LogicaException;
	public ArrayList<UsuarioBeans> getAll() throws LogicaException;
	public boolean update(UsuarioBeans user) throws LogicaException;

}
