package it.tsc.repository.impl;

import it.tsc.domain.AllarmiTelemedicare;
import it.tsc.repository.BaseDao;
import it.tsc.repository.FunctionDao;
import it.tsc.repository.TelemedicareDao;
import it.tsc.service.CodaEveService;
import it.tsc.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.util.List;

@Repository("telemedicareDao")
public class TelemedicareDaoImpl extends BaseDao implements TelemedicareDao {
	private static final String CENTRALE_EA = "MILANO";

	private static final int RESULT_LIMIT = 20;

	private static final Logger logger = LoggerFactory
			.getLogger(EuropeAssistanceDaoImpl.class);

	@Autowired
	private FunctionDao functionDao;

	@Autowired
	private CodaEveService codaEveService;


	@Value("${telemedicare.phone}")
	private String phone;

	@Value("${telemedicare.centrale}")
	private String centrale;


	@Override
	public void saveAllarm(AllarmiTelemedicare allarmiTelemedicare) {
		logger.info("saveAllarm: {}",allarmiTelemedicare);
		try (Connection connection = getConnection()){
/*			String id_allarme = functionDao.getNextIdAllarme(CENTRALE_EA);
			allarmiTelemedicare.setId_allarme(id_allarme);
			logger.info("saveAndFlush allarmiTelemedicare: {}",allarmiTelemedicare);
			saveAndFlush(allarmiTelemedicare);
			logger.debug("saveAllarm: {}",
					allarmiTelemedicare.getId_allarme());*/
			codaEveService.insertAllarmiInCodaEve_Brondi(phone,"",centrale);
		}
		catch (Exception e) {
			logger.error("saveAllarm: {}", e.getMessage());
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
		EntityTransaction tx = getEntityManager().getTransaction();
		logger.info("Begin transaction tx: {}",tx);
		try (Connection connection = getConnection()){
			tx.begin();
			EntityManager entityManager = getEntityManager();
			Query query = entityManager
					.createNamedQuery(AllarmiTelemedicare.DROP_ALLARM_TMC);
			query.setParameter("progressivoAllarme", progressivoAllarme);
			logger.info("dropAllarm progressivoAllarme: {}",progressivoAllarme);
			query.executeUpdate();
			tx.commit();
		}
		catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("dropAllarm: {}", e.getMessage());
		}
	}
}
