/**
 *
 */
package it.tsc.repository.impl;

import it.tsc.repository.BaseDao;
import it.tsc.repository.FunctionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;


/**
 * @author "astraservice"
 *
 */
@Repository("functionDao")
public class FunctionDaoImpl extends BaseDao implements FunctionDao {
  private static final Logger logger = LoggerFactory.getLogger(FunctionDaoImpl.class);

  /**
   *
   */
  public FunctionDaoImpl() {

  }

  @Override
  public String getNextIdAllarme(String centrale) throws SQLException {
    CallableStatement function = getConnection().prepareCall("{? = call fn_RetIDCode(?)}");
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
