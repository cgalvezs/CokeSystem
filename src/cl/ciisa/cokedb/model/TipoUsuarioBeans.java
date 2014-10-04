package cl.ciisa.cokedb.model;

import java.io.Serializable;

public class TipoUsuarioBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6745099743208918435L;
	
	
	private int id_tipo;
	private String nombre;
	private String desc;
	private boolean activo;
	
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}

