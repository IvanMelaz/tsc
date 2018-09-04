/**
 *
 */
package it.tsc.domain;

/**
 * @author "astraservice"
 *
 */
public class MessageSmartWatcher {
	public static String BAD_REQUEST = "Phone number not registered in the system";
	public static String UNAUTHORIZED_ACCESS = "Invalid authentication token";
	public static String ALLARM_ALREADY_ACTIVE = "Alarm already active";
	public static String BAD_INPUT_PARAMETER = "Phone number is invalid";
	private String message;
	/**
	 *
	 */
	public MessageSmartWatcher(String message) {
		this.message = message;
	}

}
