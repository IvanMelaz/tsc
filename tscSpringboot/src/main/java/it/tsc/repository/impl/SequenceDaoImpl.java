/**
 *
 */
package it.tsc.repository.impl;

import java.sql.CallableStatement;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.tsc.repository.BaseDao;
import it.tsc.repository.SequenceDao;


/**
 * @author "astraservice"
 *
 */
@Repository("sequenceDao")
public class SequenceDaoImpl extends BaseDao implements SequenceDao {
  private static final Logger logger = LoggerFactory.getLogger(SequenceDaoImpl.class);

  /**
   *
   */
  public SequenceDaoImpl() {

  }

  /*
   * (non-Javadoc)
   *
   * @see it.tsc.dao.SequenceDao#getNextVal(java.lang.String)
   */
  @Override
  public Long getNextVal(String sequenceName) throws Exception {
    CallableStatement function = getConnection().prepareCall("{? = call nextval(?)}");
    function.registerOutParameter(1, Types.INTEGER);
    function.setString(2, sequenceName);
    try {
      function.execute();
      return function.getLong(1);
    } catch (Exception e) {
      logger.error("getCurrentVal: {}", e);
      return null;
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see it.tsc.dao.SequenceDao#getCurrentVal(java.lang.String)
   */
  @Override
  public Long getCurrentVal(String sequenceName) throws Exception {
    CallableStatement function = getConnection().prepareCall("{? = call currval(?)}");
    function.registerOutParameter(1, Types.INTEGER);
    function.setString(2, sequenceName);
    try {
      function.execute();
      return function.getLong(1);
    } catch (Exception e) {
      logger.error("getCurrentVal: {}", e);
      return null;
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see it.tsc.dao.SequenceDao#setValue(java.lang.String, java.lang.Long)
   */
  @Override
  public Long setValue(String sequenceName, Long newValue) throws Exception {
    CallableStatement function = getConnection().prepareCall("{? = call setval(?,?)}");
    function.registerOutParameter(1, Types.INTEGER);
    function.setString(2, sequenceName);
    function.setLong(3, newValue);
    try {
      function.execute();
      return function.getLong(1);
    } catch (Exception e) {
      logger.error("getCurrentVal: {}", e);
      return null;
    }
  }

}
