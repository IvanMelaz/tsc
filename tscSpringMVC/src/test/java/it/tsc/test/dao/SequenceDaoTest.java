/**
 *
 */
package it.tsc.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.tsc.domain.Group;
import it.tsc.service.SequenceService;

/**
 * @author astraservice
 *
 */
public class SequenceDaoTest extends BaseDaoTest {
  private static Logger logger = LoggerFactory.getLogger(SequenceDaoTest.class);
  @Autowired
  private SequenceService sequenceService;

  /**
   *
   */
  public SequenceDaoTest() {
    // TODO Auto-generated constructor stub
  }

  @Test
  public void testSequenceNotNull() throws ParseException {
    assertNotNull(sequenceService);
  }

  @Test
  public void testSequenceNextValue() throws Exception {
    assertNotNull(sequenceService);
    Long result = sequenceService.getNextVal(Group.TABLE_NAME);
    assertTrue(result != 0);
    logger.debug("next value: {}", result);
  }

  @Test
  public void testSequenceCurrentValue() throws Exception {
    assertNotNull(sequenceService);
    Long result = sequenceService.getCurrentVal(Group.TABLE_NAME);
    logger.debug("current value: {}", result);
  }

  @Test
  public void testSequenceSetValue() throws Exception {
    Long result = sequenceService.setValue(Group.TABLE_NAME, 0L);
    assertTrue(result == 0);
    logger.debug("set value: {}", result);
  }

}
