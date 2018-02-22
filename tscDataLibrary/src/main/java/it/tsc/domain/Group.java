/**
 *
 */
package it.tsc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * @author astraservice
 *
 */
@Entity
@Table(name = "tsc_group", schema = "telesoccorso@mysql_pu")
@NamedQueries(value = {
		@NamedQuery(name = Group.SELECT_GROUPS, query = "SELECT g FROM Group g")})
public class Group extends BaseDomain {
	public static final String SELECT_GROUPS = "select.groups";

	@Id
	@Column(name = "groupid")
	@Expose
	private int groupId;

	@Column(name = "groupname")
	@Expose
	private String groupName;

	/**
	 *
	 */
	public Group() {
		super();
	}

	public Group(int groupId, String groupName) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}

	// TODO finish implements
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Group) {
			return this.getGroupName().equals(((Group) obj).getGroupName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + "]";
	}

}
