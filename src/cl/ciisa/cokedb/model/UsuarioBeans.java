package cl.ciisa.cokedb.model;

import java.io.Serializable;

public class UsuarioBeans implements Serializable{
	
	//PRUEBA DE MODIFICACION
	//PRUEBA
	//PRUEBA C GALVEZ
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6420651656917187486L;
	
	private int idUsuario;
	private String nombreUsuario;
	private String nombre;
	private String apellidos;
	private String password;
	private int activo;
	private int tipoUsuario;
	
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	

}
