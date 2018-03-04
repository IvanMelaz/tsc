/**
 *
 */
package it.tsc.dao.impl;

import java.time.Instant;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.tsc.dao.AllarmDao;
import it.tsc.dao.BaseDao;
import it.tsc.domain.Allarmi;
import it.tsc.util.JsonUtil;

/**
 * @author astraservice
 *
 */
@Repository("allarmDao")
public class AllarmDaoImpl extends BaseDao implements AllarmDao {
	private static Logger logger = LoggerFactory.getLogger(AllarmDaoImpl.class);

	/**
	 *
	 */
	public AllarmDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.AllarmDao#insertAllarme(java.lang.String,
	 * java.sql.Timestamp, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void insertAllarme(String ab_codi, Instant data_arrivo,
			String evento, String id_allarme, String user) {
		EntityTransaction tx = getEntityTransaction();
		try {
			tx.begin();
			StoredProcedureQuery query = getEntityManager()
					.createNamedStoredProcedureQuery(Allarmi.SP_INSERT_ALLARM);
			query.setParameter("p_ab_codi", ab_codi);
			query.setParameter("p_matricola", "######");
			query.setParameter("p_mux", "INFAM");
			query.setParameter("p_evento", "1");
			query.setParameter("p_centrale", "MILANO");
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			logger.error("insertAllarme :{}", e);
			tx.rollback();
			throw new IllegalArgumentException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.AllarmDao#insertAllarmeTel(java.lang.String,
	 * java.sql.Timestamp, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void insertAllarmeTel(String tel, String ab_codi,
			Instant data_arrivo, String evento, String id_allarme,
			String user) {
		Allarmi allarm = new Allarmi();
		allarm.setAb_codi(ab_codi);
		// allarm.setData_arrivo(Date.from(data_arrivo));
		allarm.setEvento(evento);
		allarm.setId_allarme(id_allarme);
		allarm.setUser(user);

		EntityManager entityManager = getEntityManager();
		entityManager.persist(allarm);
		entityManager.flush();
		// entityManager.close();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.AllarmDao#removeAllarme(java.lang.String)
	 */
	@Override
	public void removeAllarme(String id_allarme) {
		Allarmi allarm = new Allarmi();
		allarm.setId_allarme(id_allarme);

		EntityManager entityManager = getEntityManager();
		entityManager.remove(allarm);
		// entityManager.close();

		// AllarmAccessor allarmAccessor =
		// baseDao.createAccessor(AllarmAccessor.class);
		// allarmAccessor.removeAllarme(id_allarme);
	}

	@Override
	public void updateAllarme(String id_allarme, String user) {
		EntityTransaction tx = getEntityTransaction();
		try {
			EntityManager entityManager = getEntityManager();
			Query query = entityManager.createNamedQuery(Allarmi.UPDATE_ALLARM);
			query.setParameter("id_allarme", id_allarme);
			query.setParameter("user", user);
			query.executeUpdate();
			tx.commit();
			logger.debug("updateAllarme: {}", id_allarme);
		} catch (Exception e) {
			tx.rollback();
			logger.error("addGroup: {}", e);
		}
	}

	@Override
	public String jsonGetAllarms() {
		EntityManager entityManager = getEntityManager();
		TypedQuery<Allarmi> query = entityManager
				.createNamedQuery(Allarmi.SELECT_ALL_ALLARMS, Allarmi.class);
		List<Allarmi> list = query.getResultList();
		String result = JsonUtil.getGsonConverter().toJson(list);
		return result;
	}

}
