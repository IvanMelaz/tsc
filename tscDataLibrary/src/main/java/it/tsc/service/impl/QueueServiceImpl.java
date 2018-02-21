/**
 *
 */
package it.tsc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tsc.dao.QueueDao;
import it.tsc.service.QueueService;

/**
 * @author "astraservice"
 *
 */
@Service("queueService")
public class QueueServiceImpl implements QueueService {
	@Autowired
	private QueueDao queueDao;
	/**
	 *
	 */
	public QueueServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.service.QueueService#jsonQueueGetAllarms()
	 */
	@Override
	public String jsonQueueGetAllarms(String user) {
		return queueDao.jsonGetAllarms(user);
	}

}
