/**
 *
 */
package it.tsc.repository;

import org.apache.commons.lang3.Validate;
import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.sql.Connection;

/**
 * @author astraservice
 */
public class BaseDao {

    private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager = null;

    /**
     *
     */
    public BaseDao() {

    }

    public EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = entityManagerFactory.createEntityManager();
        }
        Validate.notNull(entityManager, "entityManager cannot be null");
        return this.entityManager;
    }

    public Connection getConnection() {
        return ((SessionImpl) getEntityManager().getDelegate())
                .connection();
    }

    public <T> void saveAndFlush(T entity) {
        logger.info("saveAndFlush entity: {}",entity);
        getEntityManager().persist(!getEntityManager().contains(entity)
                ? entity
                : getEntityManager().merge(entity));
        getEntityManager().flush();
    }

    public <T> void removeAndFlush(T entity) {
		logger.info("removeAndFlush entity: {}",entity);
        getEntityManager().remove(getEntityManager().contains(entity)
                ? entity
                : getEntityManager().merge(entity));
        getEntityManager().flush();
    }

}
