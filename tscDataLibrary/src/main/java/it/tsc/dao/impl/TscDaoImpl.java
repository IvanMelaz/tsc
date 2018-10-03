/**
 *
 */
package it.tsc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.tsc.dao.BaseDao;
import it.tsc.dao.TscDao;
import it.tsc.domain.Allarmi;
import it.tsc.domain.Anagrafica;
import it.tsc.util.JsonUtil;

/**
 * @author astraservice
 *
 */
@Repository("tscDao")
public class TscDaoImpl extends BaseDao implements TscDao {
	private static Logger logger = LoggerFactory.getLogger(TscDaoImpl.class);

	/**
	 *
	 */
	public TscDaoImpl() {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.TscDao#getAnagrafica(it.tsc.model.Allarmi)
	 */
	@Override
	public String getAnagrafica(Allarmi allarm) {
		Validate.notBlank(allarm.getAb_codi(), "ab_codi cannot be blank");
		String result = null;
		EntityManager entityManager = getEntityManager();
		try {
			TypedQuery<Anagrafica> query = entityManager.createNamedQuery(
					Anagrafica.SELECT_ANAGRAFICA_BY_ABCODI, Anagrafica.class);
			query.setParameter("ab_codi", allarm.getAb_codi());
			Anagrafica anagrafica = query.getSingleResult();
			result = JsonUtil.getGsonConverter().toJson(anagrafica);
			logger.debug("getAnagrafica result: {}", result);
		} catch (Exception e) {
			logger.error("getAnagrafica: {}", e);
		}
		// entityManager.close();

		return result;
	}

}
