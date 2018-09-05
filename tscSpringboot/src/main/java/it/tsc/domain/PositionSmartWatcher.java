/**
 *
 */
package it.tsc.domain;

import com.google.gson.annotations.Expose;

/**
 * @author "astraservice"
 *
 */
public class PositionSmartWatcher extends BaseSmartWatcher {
	@Expose
	private double latitude;
	@Expose
	private double longitude;
	@Expose
	private double accuracy;
	@Expose
	private String timestamp;
	/**
	 *
	 */
	public PositionSmartWatcher() {

	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
