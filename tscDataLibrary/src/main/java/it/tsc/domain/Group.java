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
import javax.persistence.UniqueConstraint;

import com.google.gson.annotations.Expose;

/**
 * @author astraservice
 *
 */
@Entity
@Table(name = Group.TABLE_NAME, schema = "telesoccorso@mysql_pu", uniqueConstraints = @UniqueConstraint(columnNames = {
		"groupname"}))
@NamedQueries(value = {
		@NamedQuery(name = Group.SELECT_GROUPS, query = "SELECT g FROM Group g")})
public class Group extends BaseDomain {
	/**
	 *
	 */
	private static final long serialVersionUID = 1913835724827889810L;
	public static final String SELECT_GROUPS = "select.groups";
	public static final String TABLE_NAME = "tsc_group";

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
