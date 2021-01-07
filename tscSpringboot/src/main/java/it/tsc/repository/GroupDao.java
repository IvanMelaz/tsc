package it.tsc.repository;

import it.tsc.domain.Group;

import java.util.List;

public interface GroupDao {
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

	/**
	 * find group by name
	 * 
	 * @param groupname
	 * @return
	 */
    Group findByName(String groupname);

}
