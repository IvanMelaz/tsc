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

}
