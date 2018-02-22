/**
 *
 */
package it.tsc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tsc.dao.CodaEveDao;
import it.tsc.service.CodaEveService;

/**
 * @author "astraservice"
 *
 */
@Service("codaEveService")
public class CodaEveServiceImpl implements CodaEveService {
	@Autowired
	private CodaEveDao codaEveDao;
	/**
	 *
	 */
	public CodaEveServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.service.QueueService#jsonQueueGetAllarms()
	 */
	@Override
	public String jsonQueueGetAllarms(String user) {
		return codaEveDao.jsonGetAllarms(user);
	}

}
