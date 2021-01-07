/**
 *
 */
package it.tsc.service;

/**
 * @author "astraservice"
 *
 */
public interface SequenceService {

	/**
	 * get NextVal from sequence
	 *
	 * @param sequenceName
	 * @return
	 * @throws Exception
	 */
    Long getNextVal(String sequenceName) throws Exception;

	/**
	 * get Current Value from sequence
	 *
	 * @param sequenceName
	 * @return
	 * @throws Exception
	 */
    Long getCurrentVal(String sequenceName) throws Exception;

	/**
	 * set Current Value from sequence </br>
	 * If not exist insert value
	 *
	 * @param sequenceName
	 * @param newValue
	 * @return
	 * @throws Exception
	 */
    Long setValue(String sequenceName, Long newValue) throws Exception;

}
