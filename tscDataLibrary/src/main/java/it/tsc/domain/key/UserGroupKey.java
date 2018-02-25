/**
 *
 */
package it.tsc.domain.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.gson.annotations.Expose;

/**
 * @author "astraservice"
 *
 */
@Embeddable
public class UserGroupKey implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -8286781074356065608L;

	@Column(name = "groupid")
	@Expose
	private Long groupid;

	@Column(name = "username")
	@Expose
	private String username;
	/**
	 *
	 */
	public UserGroupKey() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getGroupid() {
		return groupid;
	}
	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}

}
