package it.tsc.repository.impl;

import it.tsc.domain.AllarmiTelemedicare;
import it.tsc.repository.BaseDao;
import it.tsc.repository.FunctionDao;
import it.tsc.repository.TelemedicareDao;
import it.tsc.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("telemedicareDao")
public class TelemedicareDaoImpl extends BaseDao implements TelemedicareDao {
	private static final String CENTRALE_EA = "MILANO";

	private static final int RESULT_LIMIT = 20;

	private static Logger logger = LoggerFactory
			.getLogger(EuropeAssistanceDaoImpl.class);

	@Autowired
	private FunctionDao functionDao;

	@Override
	public void saveAllarm(AllarmiTelemedicare allarmiTelemedicare) {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			String id_allarme = functionDao.getNextIdAllarme(CENTRALE_EA);
			allarmiTelemedicare.setId_allarme(id_allarme);
			saveAndFlush(allarmiTelemedicare);
			logger.debug("saveAllarm: {}",
					allarmiTelemedicare.getId_allarme());
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			logger.error("saveAllarm: {}", e);
		}
	}

	@Override
	public String listJsonAllarmiOpen() {
		EntityManager entityManager = getEntityManager();
		TypedQuery<AllarmiTelemedicare> query = entityManager
				.createNamedQuery(AllarmiTelemedicare.SELECT_ALLARM_TMC,
						AllarmiTelemedicare.class);
		List<AllarmiTelemedicare> list = query.getResultList();
		query.setMaxResults(RESULT_LIMIT);
		return JsonUtil.getGsonConverter().toJson(list);
	}

	@Override
	public void dropAllarm(String progressivoAllarme) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager
				.createNamedQuery(AllarmiTelemedicare.DROP_ALLARM_TMC);
		query.setParameter("progressivoAllarme", progressivoAllarme);
		query.executeUpdate();
	}
}
