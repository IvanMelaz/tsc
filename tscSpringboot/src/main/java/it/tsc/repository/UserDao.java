/**
 *
 */
package it.tsc.repository;

import it.tsc.domain.PortalUser;
import it.tsc.domain.Role;
import it.tsc.domain.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @author astraservice
 *
 */
public interface UserDao {
	/**
	 * get User in JSON format
	 *
	 * @param username
	 * @return
	 */
    String jsonGetUser(String username);

	/**
	 * get User Object
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
	 * get User Object(for pwd recovery)
	 *
	 * @param username
	 * @param email
	 * @return
	 */
    PortalUser getUser(String username, String email);

	/**
	 * get All Users in JSON format
	 *
	 * @return (Only for admin role is permitted)
	 */
    String jsonGetAllUsers();

	/**
	 * get All Users
	 *
	 * @return (Only for admin role is permitted)
	 */
    List<PortalUser> getAllUsers();

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
	 *            (Only admin role is permitted)
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
                          String base32Secret, String role);
}
