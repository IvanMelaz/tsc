/**
 *
 */
package it.tsc.service;

import it.tsc.domain.AllarmiEuropeAssistance;

/**
 * @author "astraservice" Allarms fo Europe assistance
 */
public interface EuropeAssistanceService {

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
