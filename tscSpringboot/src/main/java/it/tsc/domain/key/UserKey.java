/**
 *
 */
package it.tsc.domain.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.gson.annotations.Expose;

import it.tsc.domain.Role;

/**
 * @author astraservice
 *
 */
@Embeddable
public class UserKey implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1053059728012977397L;

	@Column(name = "username")
	@Expose
	private String username;

	@Column(name = "role")
	@Expose
	private String role;

	public UserKey() {
		super();
	}

	public UserKey(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}

	public UserKey(String username, Role role) {
		super();
		this.username = username;
		this.role = role.toString();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserKey other = (UserKey) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			return other.username == null;
		} else return username.equals(other.username);
	}

}
