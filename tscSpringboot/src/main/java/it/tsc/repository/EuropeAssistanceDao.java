/**
 *
 */
package it.tsc.repository;

import it.tsc.domain.AllarmiEuropeAssistance;

/**
 * @author "astraservice"
 *
 */
public interface EuropeAssistanceDao {

	/**
	 * save allarm coming from WS
	 *
	 * @param allarmiEuropeAssistance
	 */
	public void saveAllarm(AllarmiEuropeAssistance allarmiEuropeAssistance);

	/**
	 * retrieve List (size == 20) od persisted Allarms
	 *
	 * @return
	 */
	public String listJsonAllarmiOpen();

}
