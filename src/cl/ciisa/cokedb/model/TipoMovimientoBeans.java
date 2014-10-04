package cl.ciisa.cokedb.model;

import java.io.Serializable;

public class TipoMovimientoBeans implements Serializable{


	private static final long serialVersionUID = 4414180137788457174L;

	private int idTipoMovimiento;
	private String nombre;
	private String descripcion;
	private int activo;
	
	public int getIdTipoMovimiento() {
		return idTipoMovimiento;
	}
	public void setIdTipoMovimiento(int idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
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
	
	
	
	
	
}
