/**
 *
 */
package it.tsc.test.dao;

import java.util.Date;

import org.apache.commons.lang.Validate;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.tsc.domain.AllarmiEuropeAssistance;
import it.tsc.service.EuropeAssistanceService;

/**
 * @author "astraservice"
 *
 */
public class AllarmEuropeDaoTest extends BaseDaoTest {
  private static Logger logger = LoggerFactory.getLogger(AllarmEuropeDaoTest.class);
  @Autowired
  private EuropeAssistanceService europeAssistanceService;

  /**
   *
   */
  public AllarmEuropeDaoTest() {

  }

  @Test
  public void europeAssDaoTest() {
    Validate.notNull(europeAssistanceService);
    AllarmiEuropeAssistance allarmiEuropeAssistance = new AllarmiEuropeAssistance();
    allarmiEuropeAssistance.setAb_codi("EU001");
    allarmiEuropeAssistance.setDataRichiesta(new Date());
    europeAssistanceService.saveAllarm(allarmiEuropeAssistance);
  }

}
