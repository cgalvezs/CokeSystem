package cl.ciisa.cokedb.controller.forms;

import java.io.Serializable;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DeleteMovimientosForm implements Serializable{



	
	/**
	 * 
	 */
	private static final long serialVersionUID = 805587351931835417L;
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
	
	//YESENIA AQUI TIENES QUE GENERAR LA LOGICA DE LOS INGRESOS EN LOS FORMULARIOS.
	//LO DE ABAJO ES UN EJEMPLO
	/*
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
		
		if(this.centNombre == null || this.centNombre.trim().length() <= 1 || this.centNombre.trim().length() >= 12){
			errors.add("nombre", new ActionMessage("errors.detail",
			"El nombre debe ser mayor de 1 caracteres y menor a 12 caracteres"));
		}
		
		
		
		return errors;
	}*/
	
	

}
