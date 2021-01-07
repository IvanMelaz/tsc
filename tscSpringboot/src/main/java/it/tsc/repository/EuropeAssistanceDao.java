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
    void saveAllarm(AllarmiEuropeAssistance allarmiEuropeAssistance);

	/**
	 * retrieve List (size == 20) od persisted Allarms
	 *
	 * @return
	 */
    String listJsonAllarmiOpen();

}
