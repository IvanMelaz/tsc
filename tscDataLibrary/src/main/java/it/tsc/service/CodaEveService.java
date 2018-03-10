/**
 *
 */
package it.tsc.service;

/**
 * @author "astraservice" Service for allarm on coda_eve
 */
public interface CodaEveService {

	/**
	 * get allarms in json format
	 *
	 * @param user
	 * @return
	 */
	public String jsonQueueGetAllarms(String user);

	/**
	 * remove allarme from CODA_EVE
	 *
	 * @param id_allarme
	 */
	public void removeAllarme(String id_allarme);

	/**
	 * update allarme from CODA_EVE
	 *
	 * @param id_allarme
	 * @param user
	 */
	public void updateAllarme(String id_allarme, String user);

}
