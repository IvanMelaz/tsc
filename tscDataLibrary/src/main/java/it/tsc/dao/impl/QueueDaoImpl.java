/**
 *
 */
package it.tsc.dao.impl;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import it.tsc.dao.BaseDao;
import it.tsc.dao.QueueDao;
import it.tsc.domain.QueueAllarm;
import it.tsc.util.JsonUtil;

/**
 * @author "astraservice"
 *
 */
@Repository("queueDao")
public class QueueDaoImpl extends BaseDao implements QueueDao {

	/**
	 *
	 */
	public QueueDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.QueueDao#jsonGetAllarms()
	 */
	@Override
	public String jsonGetAllarms(String user) {
		StoredProcedureQuery query = getEntityManager()
				.createNamedStoredProcedureQuery(QueueAllarm.SP_V_CODA_EVE);
		query.setParameter("p_user", user);

		String result = JsonUtil.getGsonConverter()
				.toJson(query.getResultList());
		return result;
	}

}
