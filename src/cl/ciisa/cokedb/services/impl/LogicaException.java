
package cl.ciisa.cokedb.services.impl;

import java.sql.SQLException;

import cl.ciisa.cokedb.dao.impl.DAOException;


/**
 * Esta clase se encarga de manejar las excepciones que se generan a nivel de
 * logica
 * 
 * 
 */
public class LogicaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2825315070807310654L;

	private int codigo;

	/**
	 * 
	 */
	public LogicaException(DAOException e) {
		super(e.getMessage());
		this.codigo = e.getCodigo();
	}

	/**
	 * 
	 */
	public LogicaException(SQLException e) {
		super(e.getMessage());
	}

		/**
		 * @param message
		 */
		public LogicaException(String message) {
			super(message);
		}

	/**
	 * @param message
	 */
	public LogicaException(int codigo, String message) {
		super(message);
		this.codigo = codigo;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public LogicaException(int codigo) {
		this.codigo = codigo;
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param cause
	 */
	public LogicaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return Returns the codigo.
	 */
	public int getCodigo() {
		return codigo;
	}

}
