package cl.ciisa.cokedb.services.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.model.PalletsBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;

public interface IPalletsService {
	
	public long insert(PalletsBeans pallet) throws LogicaException;
	public ArrayList<PalletsBeans> getAll() throws LogicaException;
	public boolean update(PalletsBeans pallet) throws LogicaException;

}
