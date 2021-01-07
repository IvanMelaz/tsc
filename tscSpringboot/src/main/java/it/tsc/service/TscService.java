/**
 * 
 */
package it.tsc.service;

import it.tsc.domain.Allarmi;

/**
 * @author astraservice TSC Service
 */
public interface TscService {

  /**
   * Obtain Anagrafica giving allarm (JSON)
   * 
   * @param allarm
   * @return
   */
  String getAnagrafica(Allarmi allarm);

}
