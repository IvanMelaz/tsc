/**
 *
 */
package it.tsc.test.dao;

import java.text.ParseException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.tsc.service.QueueService;

/**
 * @author astraservice
 *
 */
public class QueueDaoTest extends BaseDaoTest {
  private static Logger logger = LoggerFactory.getLogger(QueueDaoTest.class);
  @Autowired
  private QueueService queueService;

  /**
   *
   */
  public QueueDaoTest() {
    // TODO Auto-generated constructor stub
  }

  @Test
  public void queueServiceTest() throws ParseException {
    logger.debug(queueService.jsonQueueGetAllarms("matteo"));
  }

}
