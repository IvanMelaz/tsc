/**
 *
 */
package it.tsc.domain;

import com.google.gson.annotations.Expose;

/**
 * @author "astraservice"
 *
 */
public class BaseSmartWatcher {
	@Expose
	private String phoneNumber;
	/**
	 *
	 */
	public BaseSmartWatcher() {

	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
