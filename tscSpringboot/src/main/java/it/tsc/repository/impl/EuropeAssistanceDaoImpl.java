/**
 *
 */
package it.tsc.repository.impl;

import it.tsc.domain.AllarmiEuropeAssistance;
import it.tsc.repository.BaseDao;
import it.tsc.repository.EuropeAssistanceDao;
import it.tsc.repository.FunctionDao;
import it.tsc.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author "astraservice"
 *
 */
@Repository("europeAssistanceDao")
public class EuropeAssistanceDaoImpl extends BaseDao
		implements
			EuropeAssistanceDao {
	private static final Logger logger = LoggerFactory
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
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			logger.info("Calling saveAllarm allarmiEuropeAssistance: {}",allarmiEuropeAssistance);
			tx.begin();
			String id_allarme = functionDao.getNextIdAllarme(CENTRALE_EA);
			allarmiEuropeAssistance.setId_allarme(id_allarme);
			saveAndFlush(allarmiEuropeAssistance);
			logger.info("saveAllarm: {}",
					allarmiEuropeAssistance.getId_allarme());
			tx.commit();
		}
		catch (Exception e) {
			logger.error("saveAllarm: {}", e.getMessage());
			tx.rollback();
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
		return JsonUtil.getGsonConverter().toJson(list);
	}

}
