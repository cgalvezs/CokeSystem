package cl.ciisa.cokedb.services.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.model.MermaBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;

public interface IMermasService {
	
	public long insert(MermaBeans merma) throws LogicaException;
	public ArrayList<MermaBeans> getAll() throws LogicaException;
	public boolean update(MermaBeans merma) throws LogicaException;

}
