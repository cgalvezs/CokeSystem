package cl.ciisa.cokedb.model;

import java.io.Serializable;
import java.util.Date;

public class MovimientosBeans implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7687921143453170774L;

	
	private int idMovimiento;
	private int idTipoMovimiento;
	private int idUsuario;
	private int idUnicoMovimientos;
	private int idUnicoProductos;
	private Date date;
	private int palletsIdPallet;
	
	
	public int getPalletsIdPallet() {
		return palletsIdPallet;
	}
	public void setPalletsIdPallet(int palletsIdPallet) {
		this.palletsIdPallet = palletsIdPallet;
	}
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public int getIdTipoMovimiento() {
		return idTipoMovimiento;
	}
	public void setIdTipoMovimiento(int idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdUnicoMovimientos() {
		return idUnicoMovimientos;
	}
	public void setIdUnicoMovimientos(int idUnicoMovimientos) {
		this.idUnicoMovimientos = idUnicoMovimientos;
	}
	public int getIdUnicoProductos() {
		return idUnicoProductos;
	}
	public void setIdUnicoProductos(int idUnicoProductos) {
		this.idUnicoProductos = idUnicoProductos;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
