/**
 *
 */
package it.tsc.service;

/**
 * @author "astraservice" Service for allarm on coda_eve
 */
public interface QueueService {

	/**
	 * get allarms in json format
	 * 
	 * @param user
	 * @return
	 */
	public String jsonQueueGetAllarms(String user);

}
