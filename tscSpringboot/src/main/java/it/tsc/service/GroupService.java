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
    List<Group> getAllGroups();

	/**
	 * add Group
	 *
	 * @param groupname
	 */
    void addGroup(String groupname);

	/**
	 * remove Group
	 *
	 * @param groupname
	 */
    void removeGroup(String groupname);

	/**
	 * find group by name
	 *
	 * @param groupname
	 * @return
	 */
    Group findByName(String groupname);

	/**
	 * add PortalUser to Group
	 *
	 * @param username
	 * @param groupname
	 */
    void addUserToGroup(String username, String groupname);

	/**
	 * remove PortalUser from Group
	 *
	 * @param username
	 * @param groupname
	 */
    void removeUserFromGroup(String username, String groupname);
}
