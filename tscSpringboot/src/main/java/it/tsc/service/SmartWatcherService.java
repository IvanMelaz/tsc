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
    boolean checkRegisteredDevice(String phoneNumber);
	/**
	 * register SmartWatcher Device
	 *
	 * @param phoneNumber
	 * @return
	 */
    boolean registerDevice(String phoneNumber);
	/**
	 * unregister SmartWatcher Device
	 *
	 * @param phoneNumber
	 * @return
	 */
    boolean unregisterDevice(String phoneNumber);
	/**
	 * register allarm in SmartWatcher System
	 *
	 * @param phoneNumber
	 * @return
	 */
    boolean registerAllarm(String phoneNumber);

}
