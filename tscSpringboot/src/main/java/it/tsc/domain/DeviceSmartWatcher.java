/**
 *
 */
package it.tsc.domain;

import com.google.gson.annotations.Expose;

/**
 * @author "astraservice"
 *
 */
public class DeviceSmartWatcher extends BaseSmartWatcher {
	@Expose
	private String displayName;
	/**
	 *
	 */
	public DeviceSmartWatcher() {
		// TODO Auto-generated constructor stub
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
