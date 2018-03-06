/**
 *
 */
package it.tsc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tsc.dao.EuropeAssistanceDao;
import it.tsc.domain.AllarmiEuropeAssistance;
import it.tsc.service.EuropeAssistanceService;

/**
 * @author "astraservice"
 *
 */
@Service("europeAssistanceService")
public class EuropeAssistanceServiceImpl implements EuropeAssistanceService {
	@Autowired
	private EuropeAssistanceDao europeAssistanceDao;
	/**
	 *
	 */
	public EuropeAssistanceServiceImpl() {

	}

	@Override
	public void saveAllarm(AllarmiEuropeAssistance allarmiEuropeAssistance) {
		europeAssistanceDao.saveAllarm(allarmiEuropeAssistance);
	}

}
