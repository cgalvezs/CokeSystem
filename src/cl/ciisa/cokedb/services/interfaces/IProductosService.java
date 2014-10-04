package cl.ciisa.cokedb.services.interfaces;

import java.util.ArrayList;

import cl.ciisa.cokedb.model.ProductosBeans;
import cl.ciisa.cokedb.services.impl.LogicaException;

public interface IProductosService {
	
	public long insert(ProductosBeans prod) throws LogicaException;
	public ArrayList<ProductosBeans> getAll() throws LogicaException;
	public boolean update(ProductosBeans prod) throws LogicaException;

}
