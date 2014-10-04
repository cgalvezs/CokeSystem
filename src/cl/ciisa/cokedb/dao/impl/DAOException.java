package cl.ciisa.cokedb.dao.impl;

public class DAOException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3853289723938123660L;

	private int codigo;

	/**
	 * 
	 */
	public DAOException() {
		super();
	}

	/**
	 * @param message
	 */
	public DAOException(String message) {
		super(message);
	}

	/**
	 * @param message
	 */
	public DAOException(int codigo, String message) {		
		super(message);
		System.out.print(codigo);
	}


	/**
	 * @return Returns the codigo.
	 */
	public int getCodigo() {
		return this.codigo;
	}

}
