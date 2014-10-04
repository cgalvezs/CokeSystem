package cl.ciisa.cokedb.model;

import java.io.Serializable;

public class ProductosBeans implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 437222896814627139L;

	private int idProductos;
	private String nombreP;
	private String descripcion;
	private int activo;
	private int idTipoProducto;
	
	
	public int getIdProductos() {
		return idProductos;
	}
	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}
	public String getNombreP() {
		return nombreP;
	}
	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
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
	public int getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	
	
	
}
