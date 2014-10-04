package cl.ciisa.cokedb.dao.impl;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Clase que inicializa el resource usado para obtener los SQL.
 */
public class InitResource {
	public static ResourceBundle getSQLResource(ResourceBundle rb) {
		ResourceBundle sqlResource = ResourceBundle.getBundle(rb
				.getString("DB_SQL_PROPERTIES"), Locale.ENGLISH);
		return sqlResource;
	}
}
