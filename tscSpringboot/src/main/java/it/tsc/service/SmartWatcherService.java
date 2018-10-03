/**
 *
 */
package it.tsc.service;

/**
 * @author "astraservice"
 *
 */
public interface SmartWatcherService {
	/**
	 * register SmartWatcher Device
	 *
	 * @param phoneNumber
	 */
	public boolean checkRegisteredDevice(String phoneNumber);
	/**
	 * register SmartWatcher Device
	 *
	 * @param phoneNumber
	 * @return
	 */
	public boolean registerDevice(String phoneNumber);
	/**
	 * unregister SmartWatcher Device
	 *
	 * @param phoneNumber
	 * @return
	 */
	public boolean unregisterDevice(String phoneNumber);
	/**
	 * register allarm in SmartWatcher System
	 *
	 * @param phoneNumber
	 * @return
	 */
	public boolean registerAllarm(String phoneNumber);

}
