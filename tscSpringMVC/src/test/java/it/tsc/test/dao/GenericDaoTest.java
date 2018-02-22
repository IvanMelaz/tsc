/**
 *
 */
package it.tsc.test.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author astraservice
 *
 */
public class GenericDaoTest extends BaseDaoTest {
  // @PersistenceContext(name = "sharedEntityManager")
  // private EntityManager entityManager;
  @Autowired
  private EntityManagerFactory entityManagerFactory;
  private EntityManager entityManager;

  public EntityManager getEntityManager() {
    if (entityManagerFactory != null) {
      if (entityManager == null) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
      } else if (!entityManager.isOpen()) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
      } else {
        return entityManager;
      }
    } else {
      throw new RuntimeException("entityManagerFactory cannotbe null");
    }
  }



}
