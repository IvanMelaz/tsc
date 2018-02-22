/**
 *
 */
package it.tsc.test.dao;

import java.text.ParseException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.tsc.service.CodaEveService;

/**
 * @author astraservice
 *
 */
public class CodaEveDaoTest extends BaseDaoTest {
  private static Logger logger = LoggerFactory.getLogger(CodaEveDaoTest.class);
  @Autowired
  private CodaEveService codaEveService;

  /**
   *
   */
  public CodaEveDaoTest() {
    // TODO Auto-generated constructor stub
  }

  @Test
  public void queueServiceTest() throws ParseException {
    logger.debug(codaEveService.jsonQueueGetAllarms("matteo"));
  }

}
