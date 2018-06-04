/**
 *
 */
package it.tsc.repository.impl;

import javax.persistence.EntityTransaction;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.tsc.domain.CodaEve;
import it.tsc.repository.BaseDao;
import it.tsc.repository.CodaEveDao;
import it.tsc.util.JsonUtil;

/**
 * @author "astraservice"
 *
 */
@Repository("codaEveDao")
public class CodaEveDaoImpl extends BaseDao implements CodaEveDao {
  private static Logger logger = LoggerFactory.getLogger(CodaEveDaoImpl.class);

  /**
   *
   */
  public CodaEveDaoImpl() {
    // TODO Auto-generated constructor stub
  }

  /*
   * (non-Javadoc)
   *
   * @see it.tsc.dao.QueueDao#jsonGetAllarms()
   */
  @Override
  public String jsonGetAllarms(String user) {
    StoredProcedureQuery query =
        getEntityManager().createNamedStoredProcedureQuery(CodaEve.SP_V_CODA_EVE);
    query.setParameter("p_user", user);

    String result = JsonUtil.getGsonConverter().toJson(query.getResultList());
    return result;
  }

  @Override
  public void removeAllarme(String id_allarme) {
    EntityTransaction tx = getEntityTransaction();
    try {
      tx.begin();
      StoredProcedureQuery query =
          getEntityManager().createNamedStoredProcedureQuery(CodaEve.SP_D_CODA_EVE);
      query.setParameter("p_ID_allermer", id_allarme);
      query.executeUpdate();
      tx.commit();
    } catch (Exception e) {
      logger.error("removeAllarme :{}", e);
      tx.rollback();
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public void updateAllarme(String id_allarme, String user) {
    EntityTransaction tx = getEntityTransaction();
    try {
      tx.begin();
      StoredProcedureQuery query =
          getEntityManager().createNamedStoredProcedureQuery(CodaEve.SP_U_SET_USER_IN_CODAEVE);
      query.setParameter("p_ID_allarme", id_allarme);
      query.setParameter("p_user", user);
      query.executeUpdate();
      tx.commit();
    } catch (Exception e) {
      logger.error("updateAllarme :{}", e);
      tx.rollback();
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public void insertAllarmiInCodaEve(String matricola, String evento, String centrale, String mux,
      String ritardo) {
    EntityTransaction tx = getEntityTransaction();
    try {
      tx.begin();
      StoredProcedureQuery query =
          getEntityManager().createNamedStoredProcedureQuery(CodaEve.SP_I_INSERTALLARM_IN_CODA_EVE);
      query.setParameter("matricola", matricola);
      query.setParameter("evento", evento);
      query.setParameter("centrale", centrale);
      query.setParameter("mux", mux);
      query.setParameter("ritardo", ritardo);

      query.executeUpdate();
      tx.commit();
    } catch (Exception e) {
      logger.error("insertAllarmiInCodaEve :{}", e);
      tx.rollback();
      throw new IllegalArgumentException(e);
    }
  }

}
