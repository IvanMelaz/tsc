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

	@Column(name = "username")
	@Expose
	private String username;

	@Column(name = "role")
	@Expose
	private String role;

	@Column(name = "groupid")
	@Expose
	private Long groupId;

	/**
	 *
	 */
	public UserGroupKey() {
		super();
	}
	public UserGroupKey(String username, String role, Long groupId) {
		super();
		this.username = username;
		this.role = role;
		this.groupId = groupId;
	}
	public UserGroupKey(UserKey userKey, Long groupId) {
		super();
		this.username = userKey.getUsername();
		this.role = userKey.getRole();
		this.groupId = groupId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

}
