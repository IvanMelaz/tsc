/**
 *
 */
package it.tsc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.tsc.dao.BaseDao;
import it.tsc.dao.EuropeAssistanceDao;
import it.tsc.dao.FunctionDao;
import it.tsc.domain.AllarmiEuropeAssistance;
import it.tsc.util.JsonUtil;

/**
 * @author "astraservice"
 *
 */
@Repository("europeAssistanceDao")
public class EuropeAssistanceDaoImpl extends BaseDao
		implements
			EuropeAssistanceDao {
	private static Logger logger = LoggerFactory
			.getLogger(EuropeAssistanceDaoImpl.class);
	private static final String CENTRALE_EA = "MILANO";
	private static final int RESULT_LIMIT = 20;
	@Autowired
	private FunctionDao functionDao;

	/**
	 *
	 */
	public EuropeAssistanceDaoImpl() {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.EuropeAssistanceDao#saveAllarm(it.tsc.domain.
	 * AllarmiEuropeAssistance)
	 */
	@Override
	public void saveAllarm(AllarmiEuropeAssistance allarmiEuropeAssistance) {
		EntityTransaction tx = getEntityTransaction();
		try {
			tx.begin();
			String id_allarme = functionDao.getNextIdAllarme(CENTRALE_EA);
			allarmiEuropeAssistance.setId_allarme(id_allarme);
			saveAndFlush(allarmiEuropeAssistance);
			logger.debug("saveAllarm: {}",
					allarmiEuropeAssistance.getId_allarme());
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			logger.error("saveAllarm: {}", e);
		}
	}

	@Override
	public String listJsonAllarmiOpen() {
		EntityManager entityManager = getEntityManager();
		TypedQuery<AllarmiEuropeAssistance> query = entityManager
				.createNamedQuery(AllarmiEuropeAssistance.SELECT_ALLARM_EA,
						AllarmiEuropeAssistance.class);
		List<AllarmiEuropeAssistance> list = query.getResultList();
		query.setMaxResults(RESULT_LIMIT);
		String result = JsonUtil.getGsonConverter().toJson(list);
		return result;
	}

}
