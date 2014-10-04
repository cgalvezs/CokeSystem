package cl.ciisa.cokedb.controller.forms;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DeleteProductosForm implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6869065176097937017L;
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
