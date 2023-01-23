/**
 *
 */
package it.tsc.domain;

import com.google.gson.annotations.Expose;
import it.tsc.domain.key.UserKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

/**
 * @author astraservice tb_users
 */
/*@Entity
@Table(name = "tsc_user")
@NamedQueries(value = {
		@NamedQuery(name = User.SELECT_ALL_USERS, query = "SELECT u FROM User u"),
		@NamedQuery(name = User.SELECT_BY_USERNAME, query = "SELECT u FROM User u WHERE u.key.username = :username"),
		@NamedQuery(name = User.SELECT_BY_USERNAME_ROLE, query = "SELECT u FROM User u WHERE u.key.username = :username AND u.key.role=:role"),
		@NamedQuery(name = User.SELECT_BY_USERNAME_EMAIL, query = "SELECT u FROM User u WHERE TRIM(u.key.username) = TRIM(:username) AND TRIM(u.email)=TRIM(:email)"),
		@NamedQuery(name = User.UPDATE_BY_USERNAME_ROLE, query = "UPDATE User u SET u.keyId=:keyId,u.base32Secret=:base32Secret WHERE u.key.username = :username AND u.key.role=:role"),
		@NamedQuery(name = User.UPDATE_USER, query = "UPDATE User u SET u.password=:password,u.email=:email,u.mfaEnabled=:mfaEnabled WHERE u.key.username = :username AND u.key.role = :role"),
		@NamedQuery(name = User.DELETE_BY_USERNAME_ROLE, query = "DELETE User u WHERE u.key.username = :username AND u.key.role=:role")})*/
public class User extends BaseDomain {
	/**
	 *
	 */
	private static final long serialVersionUID = -5293616948185366680L;
	public static final String SELECT_ALL_USERS = "select.users";
	public static final String SELECT_BY_USERNAME = "select.by.username";
	public static final String SELECT_BY_USERNAME_ROLE = "select.by.username.role";
	public static final String SELECT_BY_USERNAME_EMAIL = "select.by.username.email";
	public static final String UPDATE_BY_USERNAME_ROLE = "update.by.username.role";
	public static final String UPDATE_USER = "update.user";
	public static final String DELETE_BY_USERNAME_ROLE = "delete.by.username.role";

	@EmbeddedId
	@Expose
	private UserKey key = new UserKey();

	@Column(name = "password")
	private String password;

	@Column(name = "base32Secret")
	@Expose
	private String base32Secret;

	@Column(name = "mfaEnabled")
	@Expose
	private boolean mfaEnabled;

	@Column(name = "email")
	@Expose
	private String email;

	@Column(name = "keyId")
	@Expose
	private String keyId;

	/**
	 *
	 */
	public User() {
		super();
	}

	/**
	 *
	 * @param key
	 * @param mfaEnabled
	 */
	public User(UserKey key, boolean mfaEnabled) {
		super();
		this.key = key;
		this.mfaEnabled = mfaEnabled;
	}

	/**
	 *
	 * @param key
	 * @param password
	 * @param email
	 */
	public User(UserKey key, String password, String email,
			boolean mfaEnabled) {
		super();
		this.key = key;
		this.password = password;
		this.email = email;
		this.mfaEnabled = mfaEnabled;
	}

	/**
	 *
	 * @param key
	 * @param base32Secret
	 * @param mfaEnabled
	 * @param keyId
	 */
	public User(UserKey key, boolean mfaEnabled, String base32Secret,
			String keyId) {
		super();
		this.key = key;
		this.base32Secret = base32Secret;
		this.mfaEnabled = mfaEnabled;
		this.keyId = keyId;
	}

	public UserKey getKey() {
		return key;
	}

	public void setKey(UserKey key) {
		this.key = key;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [key=").append(key).append(", password=")
				.append(password).append(", base32Secret=").append(base32Secret)
				.append(", mfaEnabled=").append(mfaEnabled).append(", email=")
				.append(email).append(", keyId=").append(keyId).append("]");
		return builder.toString();
	}

}
