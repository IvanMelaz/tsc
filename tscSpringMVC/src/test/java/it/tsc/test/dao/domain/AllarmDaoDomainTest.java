/**
 *
 */
package it.tsc.test.dao.domain;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.tsc.domain.Allarmi;
import it.tsc.test.dao.BaseDaoTest;

/**
 * @author astraservice
 *
 */
public class AllarmDaoDomainTest extends BaseDaoTest {
  @Autowired
  private EntityManagerFactory entityManagerFactory;

  @Test
  public void allarmsTest() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    TypedQuery<Allarmi> findQuery =
        entityManager.createQuery("Select a from Allarmi a", Allarmi.class);
    List<Allarmi> allAllarms = findQuery.getResultList();
    assertNotNull(entityManager);
  }

}
