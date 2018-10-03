/**
 *
 */
package it.tsc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tsc.dao.SequenceDao;
import it.tsc.service.SequenceService;

/**
 * @author "astraservice"
 *
 */
@Service("sequenceService")
public class SequenceServiceImpl implements SequenceService {
	@Autowired
	private SequenceDao sequenceDao;
	private static final Long START_VALUE = 0L;
	/**
	 *
	 */
	public SequenceServiceImpl() {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.service.SequenceService#getNextVal(java.lang.String)
	 */
	@Override
	public Long getNextVal(String sequenceName) throws Exception {
		synchronized (sequenceName) {
			if (this.getCurrentVal(sequenceName) == 0) {
				this.sequenceDao.setValue(sequenceName, START_VALUE);
			}
			return sequenceDao.getNextVal(sequenceName);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.service.SequenceService#getCurrentVal(java.lang.String)
	 */
	@Override
	public Long getCurrentVal(String sequenceName) throws Exception {
		return sequenceDao.getCurrentVal(sequenceName);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.service.SequenceService#setValue(java.lang.String,
	 * java.lang.Long)
	 */
	@Override
	public Long setValue(String sequenceName, Long newValue) throws Exception {
		return sequenceDao.setValue(sequenceName, newValue);
	}

}
