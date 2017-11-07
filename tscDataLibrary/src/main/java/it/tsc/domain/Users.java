/**
 * 
 */
package it.tsc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import it.tsc.domain.key.CompoundKey;

/**
 * @author astraservice tb_users
 */
@Entity
@Table(name = "tb_users", schema = "ks_tsc@cassandra_pu")
@NamedQueries(value = { @NamedQuery(name = Users.SELECT_ALL_USERS, query = "SELECT u FROM Users u"),
		@NamedQuery(name = Users.SELECT_BY_USERNAME, query = "SELECT u FROM Users u WHERE u.key.username = :username"),
		@NamedQuery(name = Users.SELECT_BY_USERNAME_EMAIL, query = "SELECT u FROM Users u WHERE u.key.username = :username AND u.email=:email"),
		@NamedQuery(name = Users.UPDATE_BY_USERNAME_ROLE, query = "UPDATE Users u SET u.keyId=:keyId,u.base32Secret=:base32Secret WHERE u.key.username = :username AND u.key.role=:role"),
		@NamedQuery(name = Users.UPDATE_USER, query = "UPDATE Users u SET u.password=:password,u.email=:email WHERE u.key.username = :username AND u.key.role = :role") })
public class Users extends BaseDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5293616948185366680L;
	public static final String SELECT_ALL_USERS = "select.users";
	public static final String SELECT_BY_USERNAME = "select.by.username";
	public static final String SELECT_BY_USERNAME_EMAIL = "select.by.username.email";
	public static final String UPDATE_BY_USERNAME_ROLE = "update.by.username.role";
	public static final String UPDATE_USER = "update.user";

	@EmbeddedId
	@Expose
	private CompoundKey key = new CompoundKey();
	@Column
	private String password;

	@Column(name = "base32secret")
	@Expose
	private String base32Secret;

	@Column(name = "mfaenabled")
	@Expose
	private boolean mfaEnabled;

	@Column
	@Expose
	private String email;

	@Column(name = "keyid")
	@Expose
	private String keyId;

	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private Set<Group> groups = new HashSet<Group>();

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public String getBase32Secret() {
		return base32Secret;
	}

	public void setBase32Secret(String base32Secret) {
		this.base32Secret = base32Secret;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public CompoundKey getKey() {
		return key;
	}

	public void setKey(CompoundKey key) {
		this.key = key;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isMfaEnabled() {
		return mfaEnabled;
	}

	public void setMfaEnabled(boolean mfaEnabled) {
		this.mfaEnabled = mfaEnabled;
	}

	public void addUsername(String username) {
		getNewKey();
		this.key.setUsername(username);
	}

	public void addRole(Role role) {
		getNewKey();
		this.key.setRole(role.toString());
	}

	/**
	 * create new key
	 * 
	 * @return
	 */
	private CompoundKey getNewKey() {
		if (this.key == null) {
			this.key = new CompoundKey();
		}
		return this.key;
	}

}
