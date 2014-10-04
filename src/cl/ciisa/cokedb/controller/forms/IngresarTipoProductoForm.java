package cl.ciisa.cokedb.controller.forms;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class IngresarTipoProductoForm implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5410209084465968615L;
	
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
		// TODO Ap?ndice de m?todo generado autom?ticamente
		return 0;
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
