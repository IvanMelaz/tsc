/**
 *
 */
package it.tsc.service.impl;

import it.tsc.domain.AllarmiEuropeAssistance;
import it.tsc.repository.EuropeAssistanceDao;
import it.tsc.service.EuropeAssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  @Override
  public String listJsonAllarmiOpen() {
    return europeAssistanceDao.listJsonAllarmiOpen();
  }

}
