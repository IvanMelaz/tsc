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
        logger.info("Calling getNextIdAllarme centrale: {} ", centrale);

        try (CallableStatement function = getConnection().prepareCall("{? = call fn_RetIDCode(?)}")) {
            function.registerOutParameter(1, Types.VARCHAR);
            function.setString(2, centrale);
            function.execute();
            logger.info("getNextIdAllarme return value: {}", function.getString(1));
            return function.getString(1);
        } catch (Exception e) {
            logger.error("getNextIdAllarme: {}", e.getMessage());
            return null;
        }
    }

}
