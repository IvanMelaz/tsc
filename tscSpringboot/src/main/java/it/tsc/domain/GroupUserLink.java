/**
 *
 */
package it.tsc.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import it.tsc.domain.key.UserGroupKey;

/**
 * @author "astraservice"
 *
 */
@Entity
@Table(name = "tsc_group_user_link", schema = "telesoccorso@mysql_pu")
public class GroupUserLink {

	@EmbeddedId
	private UserGroupKey userGroupKey = new UserGroupKey();

	/**
	 *
	 */
	public GroupUserLink() {
		super();
	}
	public GroupUserLink(UserGroupKey userGroupKey) {
		super();
		this.userGroupKey = userGroupKey;
	}
	public UserGroupKey getUserGroupKey() {
		return userGroupKey;
	}

	public void setUserGroupKey(UserGroupKey userGroupKey) {
		this.userGroupKey = userGroupKey;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GroupUserLink [userGroupKey=").append(userGroupKey)
				.append("]");
		return builder.toString();
	}

}
