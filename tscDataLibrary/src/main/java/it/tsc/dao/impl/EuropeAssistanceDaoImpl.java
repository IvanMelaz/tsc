/**
 *
 */
package it.tsc.dao.impl;

import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.tsc.dao.BaseDao;
import it.tsc.dao.EuropeAssistanceDao;
import it.tsc.dao.FunctionDao;
import it.tsc.domain.AllarmiEuropeAssistance;

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
			save(allarmiEuropeAssistance);
			logger.debug("saveAllarm: {}",
					allarmiEuropeAssistance.getId_allarme());
		} catch (Exception e) {
			tx.rollback();
			logger.error("saveAllarm: {}", e);
		}
	}

}
