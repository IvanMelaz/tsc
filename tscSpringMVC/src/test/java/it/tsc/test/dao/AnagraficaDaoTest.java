/**
 *
 */
package it.tsc.test.dao;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import it.tsc.domain.Anagrafica;
import it.tsc.service.AnagraficaService;
import it.tsc.util.JsonUtil;

/**
 * @author astraservice
 *
 */
public class AnagraficaDaoTest extends BaseDaoTest {
  private static Logger logger = LoggerFactory.getLogger(AnagraficaDaoTest.class);
  @Autowired
  private AnagraficaService anagraficaService;
  @Autowired
  private EntityManager entityManager;
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

  @Test
  public void testAnagraficaStoredProcedure() {
    Anagrafica anagrafica = null;

    String ab_codi = "N000";
    StoredProcedureQuery query =
        entityManager.createNamedStoredProcedureQuery(Anagrafica.SP_V_ANAGRAFCA);
    query.setParameter("p_ab_codi", ab_codi);
    try {
      anagrafica = (Anagrafica) query.getSingleResult();
      logger.debug("result: {}", JsonUtil.getGsonConverter().toJson(anagrafica));
      assertNotNull(anagrafica);
    } catch (Exception e) {
      logger.error("getAnagrafica Exception: ", e);
    }

  }


}
