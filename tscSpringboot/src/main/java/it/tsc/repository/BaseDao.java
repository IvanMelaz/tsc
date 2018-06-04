/**
 *
 */
package it.tsc.repository;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author astraservice
 *
 */
public class BaseDao {
	@Autowired
	private EntityManager entityManager;

	/**
	 *
	 */
	public BaseDao() {

	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public EntityTransaction getEntityTransaction() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		return entityTransaction;
	}

	public Connection getConnection() {
		Connection connection = ((SessionImpl) entityManager.getDelegate())
				.connection();
		return connection;
	}

	public <T> void saveAndFlush(T entity) {
		entityManager.persist(!entityManager.contains(entity)
				? entity
				: entityManager.merge(entity));
		entityManager.flush();
	}

	public <T> void removeAndFlush(T entity) {
		entityManager.remove(entityManager.contains(entity)
				? entity
				: entityManager.merge(entity));
		entityManager.flush();
	}

}
