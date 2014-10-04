package cl.ciisa.cokedb.model;

import java.io.Serializable;

public class PalletsBeans implements Serializable{
	
	//aaa
	
	
	private static final long serialVersionUID = 5695987242651023567L;
	private int idPallets;
	private String nombre;
	private int activo;
	
	
	public int getIdPallets() {
		return idPallets;
	}
	public void setIdPallets(int idPallets) {
		this.idPallets = idPallets;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	

}
