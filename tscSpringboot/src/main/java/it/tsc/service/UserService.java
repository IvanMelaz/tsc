/**
 *
 */
package it.tsc.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import it.tsc.domain.PortalUser;
import it.tsc.domain.Role;
import it.tsc.domain.User;

/**
 * @author astraservice
 *
 */
public interface UserService {

	/**
	 * get User object
	 *
	 * @param username
	 * @return
	 */
    PortalUser getPortalUser(String username);

	/**
	 * get User Entity Object
	 *
	 * @param username
	 * @return
	 */
    List<User> getUser(String username);

	/**
	 * get User object (renew pwd service)
	 *
	 * @param username
	 * @param email
	 * @return
	 */
    PortalUser getUser(String username, String email);

	/**
	 * get User in JSON format
	 *
	 * @param username
	 * @return
	 */
    String jsonGetUser(String username);

	/**
	 * get All Users
	 *
	 * @return (Only for admin role is permitted)
	 */
    List<PortalUser> getAllUsers();

	/**
	 * get All Users in JSON format
	 *
	 * @return (Only for admin role is permitted)
	 */
    String jsonGetAllUsers();

	/**
	 * Return Roles for user
	 *
	 * @param username
	 * @return
	 */
    List<GrantedAuthority> getUserRoles(String username);

	/**
	 * Determines if User have Admin role
	 *
	 * @param role
	 * @return
	 */
    boolean isAdmin(Role role);

	/**
	 * Determines if User have Admin role
	 *
	 * @param user
	 * @return
	 */
    boolean isAdmin(PortalUser user);

	/**
	 * Determines if User have Super Admin role
	 *
	 * @param user
	 * @return
	 */
    boolean isSuperAdmin(PortalUser user);

	/**
	 * Add user
	 *
	 * @param username
	 *            (Only admin role is permitted)
	 * @param password
	 * @param email
	 * @param role
	 * @param mfaEnabled
	 * @return
	 */
    boolean addUser(String username, String password, String email,
                    Role role, boolean mfaEnabled);

	/**
	 * Remove user
	 *
	 * @param username
	 * @param role
	 * @return
	 */
    boolean removeUser(String username, Role role);

	/**
	 * update user
	 *
	 * @param username
	 *            (Only admin role is permitted)
	 * @param password
	 * @param email
	 * @param role
	 * @param mfaEnabled
	 */
    void updateUser(String username, String password, String email,
                    Role role, boolean mfaEnabled);

	/**
	 * insert MFA key updating user
	 *
	 * @param username
	 * @param keyId
	 * @param base32Secret
	 */
    void updateMfaUserKey(String username, String keyId,
                          String base32Secret);

}
