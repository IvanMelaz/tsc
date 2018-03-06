/**
 *
 */
package it.tsc.dao.impl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.tsc.dao.BaseDao;
import it.tsc.dao.FunctionDao;

/**
 * @author "astraservice"
 *
 */
@Repository("functionDao")
public class FunctionDaoImpl extends BaseDao implements FunctionDao {
	private static Logger logger = LoggerFactory
			.getLogger(FunctionDaoImpl.class);
	/**
	 *
	 */
	public FunctionDaoImpl() {

	}

	@Override
	public String getNextIdAllarme(String centrale) throws SQLException {
		CallableStatement function = getConnection()
				.prepareCall("{? = call fn_RetIDCode(?)}");
		function.registerOutParameter(1, Types.VARCHAR);
		function.setString(2, centrale);
		try {
			function.execute();
			return function.getString(1);
		} catch (Exception e) {
			logger.error("getNextIdAllarme: {}", e);
			return null;
		}
	}

}
