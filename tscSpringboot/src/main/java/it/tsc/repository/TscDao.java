/**
 * 
 */
package it.tsc.repository;

import it.tsc.domain.Allarmi;

/**
 * @author astraservice Dao for TSC Service
 */
public interface TscDao {

  /**
   * Obtain Anagrafica giving allarm
   * 
   * @param allarm
   * @return
   */
  public String getAnagrafica(Allarmi allarm);

}
