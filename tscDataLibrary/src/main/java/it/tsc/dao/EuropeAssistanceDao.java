/**
 *
 */
package it.tsc.dao;

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

}
