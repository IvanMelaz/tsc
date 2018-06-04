/**
 *
 */
package it.tsc.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.tsc.domain.Anagrafica;
import it.tsc.repository.AnagraficaDao;
import it.tsc.repository.BaseDao;

/**
 * @author "astraservice"
 *
 */
@Repository("anagraficaDao")
public class AnagraficaDaoImpl extends BaseDao implements AnagraficaDao {
  private static Logger logger = LoggerFactory.getLogger(AnagraficaDaoImpl.class);

  /**
   *
   */
  public AnagraficaDaoImpl() {
    // TODO Auto-generated constructor stub
  }

  /*
   * (non-Javadoc)
   *
   * @see it.tsc.dao.AnagraficaDao#getAnagrafica(java.lang.String)
   */
  @Override
  public Anagrafica getAnagrafica(String ab_codi) {
    Anagrafica anagrafica = null;
    StoredProcedureQuery query =
        getEntityManager().createNamedStoredProcedureQuery(Anagrafica.SP_V_ANAGRAFCA);
    query.setParameter("p_ab_codi", ab_codi);
    try {
      anagrafica = (Anagrafica) query.getSingleResult();
      Validate.notNull(anagrafica, "getSingleResult callot be null ");
    } catch (Exception e) {
      logger.error("getAnagrafica Exception: ", e);
    }
    return anagrafica;
  }

  @Override
  public void insertAnagrafica(Anagrafica anagrafica) {
    EntityManager entityManager = getEntityManager();
    entityManager.persist(anagrafica);
  }

}
