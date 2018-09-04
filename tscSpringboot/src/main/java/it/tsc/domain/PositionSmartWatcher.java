/**
 *
 */
package it.tsc.domain;

import java.awt.geom.Arc2D.Double;
import java.util.Date;

import com.google.gson.annotations.Expose;

/**
 * @author "astraservice"
 *
 */
public class PositionSmartWatcher extends BaseSmartWatcher {
	@Expose
	private Double latitude;
	@Expose
	private Double longitude;
	@Expose
	private Double accuracy;
	@Expose
	private Date timestamp;
	/**
	 *
	 */
	public PositionSmartWatcher() {
		// TODO Auto-generated constructor stub
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
