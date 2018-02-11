/**
 * 
 */
package it.tsc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tsc.dao.TscDao;
import it.tsc.domain.Allarmi;
import it.tsc.service.TscService;

/**
 * @author astraservice
 *
 */
@Service("tscService")
public class TscServiceImpl implements TscService {
  @Autowired
  private TscDao tscDao;

  /**
   * 
   */
  public TscServiceImpl() {
    // TODO Auto-generated constructor stub
  }

  /*
   * (non-Javadoc)
   * 
   * @see it.tsc.service.TscService#getAnagrafica(it.tsc.model.Allarm)
   */
  public String getAnagrafica(Allarmi allarm) {
    return tscDao.getAnagrafica(allarm);
  }

}
