/**
 *
 */
package it.tsc.repository;

import java.sql.SQLException;

/**
 * @author "astraservice"
 *
 */
public interface FunctionDao {

	/**
	 * getNextIdAllarme invoking function from DB
	 *
	 * @return
	 */
	public String getNextIdAllarme(String centrale) throws SQLException;

}
