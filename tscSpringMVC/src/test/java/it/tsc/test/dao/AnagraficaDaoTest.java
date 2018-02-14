/**
 *
 */
package it.tsc.test.dao;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import it.tsc.domain.Anagrafica;
import it.tsc.service.AnagraficaService;

/**
 * @author astraservice
 *
 */
public class AnagraficaDaoTest extends BaseDaoTest {
  private static Logger logger = LoggerFactory.getLogger(AnagraficaDaoTest.class);
  @Autowired
  private AnagraficaService anagraficaService;
  private Gson gson = new Gson();

  /**
   *
   */
  public AnagraficaDaoTest() {

  }

  @Test
  public void anagraficaDao() {
    logger.info("anagraficaService user {}", gson.toJson(anagraficaService.getAnagrafica("0000")));
  }

  @Test
  public void insertAnagraficaDao() {
    Anagrafica anagrafica = new Anagrafica();
    anagrafica.setAb_codi("N0000");
    anagraficaService.insertAnagrafica(anagrafica);
  }


}
