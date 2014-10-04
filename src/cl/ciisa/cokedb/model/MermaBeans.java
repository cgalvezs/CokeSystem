package cl.ciisa.cokedb.model;

import java.io.Serializable;


public class MermaBeans implements Serializable {

	/**n
	 * 
	 */
	private static final long serialVersionUID = -2604713627632858801L;
	
	private int idMerma;
	private String cantidad;
	public int getIdMerma() {
		return idMerma;
	}
	public void setIdMerma(int idMerma) {
		this.idMerma = idMerma;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	

	
	
	
	
}
