/**
 *
 */
package it.tsc.dao;

/**
 * @author "astraservice"
 *
 */
public interface QueueDao {

	/**
	 * get allarms in json format
	 * 
	 * @param user
	 * @return
	 */
	public String jsonGetAllarms(String user);

}
