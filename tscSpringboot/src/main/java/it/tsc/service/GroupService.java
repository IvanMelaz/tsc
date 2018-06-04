/**
 *
 */
package it.tsc.service;

import java.util.List;

import it.tsc.domain.Group;

/**
 * @author astraservice
 *
 */
public interface GroupService {
	/**
	 * get All Group
	 *
	 * @return
	 */
	public List<Group> getAllGroups();

	/**
	 * add Group
	 *
	 * @param groupname
	 */
	public void addGroup(String groupname);

	/**
	 * remove Group
	 *
	 * @param groupname
	 */
	public void removeGroup(String groupname);

	/**
	 * find group by name
	 *
	 * @param groupname
	 * @return
	 */
	public Group findByName(String groupname);

	/**
	 * add PortalUser to Group
	 *
	 * @param username
	 * @param groupname
	 */
	public void addUserToGroup(String username, String groupname);

	/**
	 * remove PortalUser from Group
	 *
	 * @param username
	 * @param groupname
	 */
	public void removeUserFromGroup(String username, String groupname);
}
