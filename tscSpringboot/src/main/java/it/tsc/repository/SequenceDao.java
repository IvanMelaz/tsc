/**
 *
 */
package it.tsc.repository;

/**
 * @author "astraservice"
 *
 */
public interface SequenceDao {

	/**
	 * get NextVal from sequence
	 *
	 * @param sequenceName
	 * @return
	 * @throws Exception
	 */
	public Long getNextVal(String sequenceName) throws Exception;

	/**
	 * get Current Value from sequence
	 *
	 * @param sequenceName
	 * @return
	 * @throws Exception
	 */
	public Long getCurrentVal(String sequenceName) throws Exception;

	/**
	 * set Current Value from sequence </br>
	 * If not exist insert value
	 *
	 * @param sequenceName
	 * @param newValue
	 * @return
	 * @throws Exception
	 */
	public Long setValue(String sequenceName, Long newValue) throws Exception;

}
