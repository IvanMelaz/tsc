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
	public Long getNextVal(String sequenceName) throws Exception;

}
