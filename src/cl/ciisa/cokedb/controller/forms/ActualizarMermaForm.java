package cl.ciisa.cokedb.controller.forms;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class ActualizarMermaForm implements Serializable {



	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6596685408196618305L;
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
