/**
 *
 */
package it.tsc.service.impl;

import it.tsc.repository.AllarmDao;
import it.tsc.service.AllarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

/**
 * @author astraservice
 *
 */
@Service("allarmService")
public class AllarmServiceImpl implements AllarmService {

	@Autowired
	private AllarmDao allarmDao;

	/**
	 *
	 */
	public AllarmServiceImpl() {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.service.AllamService#insertAllarme(java.lang.String,
	 * java.sql.Timestamp, java.lang.String, java.lang.String)
	 */
	@Override
	public void insertAllarme(String ab_codi, Instant data_arrivo,
			String evento, String id_allarme, String user) {
		allarmDao.insertAllarme(ab_codi, evento, id_allarme, user);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.service.AllamService#insertAllarmeTel(java.lang.String,
	 * java.lang.String, java.util.Date,java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void insertAllarmeTel(String tel, String ab_codi, Date data_arrivo,
			String evento, String id_allarme, String user) {

	}

	@Override
	public void removeAllarme(String id_allarme) {
		allarmDao.removeAllarme(id_allarme);
	}

	@Transactional
	@Override
	public void updateAllarme(String id_allarme, String user) {
		allarmDao.updateAllarme(id_allarme, user);
	}

}
