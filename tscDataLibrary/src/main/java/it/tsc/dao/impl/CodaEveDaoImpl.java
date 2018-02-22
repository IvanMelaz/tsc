/**
 *
 */
package it.tsc.dao.impl;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import it.tsc.dao.BaseDao;
import it.tsc.dao.CodaEveDao;
import it.tsc.domain.CodaEve;
import it.tsc.util.JsonUtil;

/**
 * @author "astraservice"
 *
 */
@Repository("codaEveDao")
public class CodaEveDaoImpl extends BaseDao implements CodaEveDao {

	/**
	 *
	 */
	public CodaEveDaoImpl() {
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
				.createNamedStoredProcedureQuery(CodaEve.SP_V_CODA_EVE);
		query.setParameter("p_user", user);

		String result = JsonUtil.getGsonConverter()
				.toJson(query.getResultList());
		return result;
	}

}
