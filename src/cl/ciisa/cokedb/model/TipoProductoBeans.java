package cl.ciisa.cokedb.model;

import java.io.Serializable;

public class TipoProductoBeans implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1096549173365732686L;
	
	
	private int idTipoProducto;
	private String nombre;
	private String descripcion;
	private int activo;
	
	
	public int getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	public int getidUnico() {
		// TODO Apéndice de método generado automáticamente
		return 0;
	}
	
	
	
}
