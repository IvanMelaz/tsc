/**
 *
 */
package it.tsc.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import it.tsc.domain.key.UserGroupKey;

/**
 * @author "astraservice"
 *
 */
@Entity
@Table(name = "tsc_group_user_link", schema = "telesoccorso@mysql_pu")
public class GroupUserLink {

	@EmbeddedId
	@Expose
	private UserGroupKey key = new UserGroupKey();

	/**
	 *
	 */
	public GroupUserLink() {

	}

	public UserGroupKey getKey() {
		return key;
	}

	public void setKey(UserGroupKey key) {
		this.key = key;
	}

}
