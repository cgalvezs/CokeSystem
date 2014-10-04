package cl.ciisa.cokedb.model;

import java.io.Serializable;


public class IdUnicoBeans implements Serializable{

	/**
	 * M
	 */
	private static final long serialVersionUID = 3277671607983563614L;
	
	private int idUnico;
	private int idProducto;
	
	public int getIdUnico() {
		return idUnico;
	}
	public void setIdUnico(int idUnico) {
		this.idUnico = idUnico;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public void setIdmerma(int int1) {
		// TODO Ap���ndice de m���todo generado autom���ticamente
		
	}
}
