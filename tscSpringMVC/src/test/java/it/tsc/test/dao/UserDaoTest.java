/**
 *
 */
package it.tsc.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.google.gson.Gson;

import it.tsc.domain.PortalUser;
import it.tsc.domain.Role;
import it.tsc.service.UserService;

/**
 * @author astraservice
 *
 */
public class UserDaoTest extends BaseDaoTest {
  private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
  @Autowired
  private UserService userService;
  @Autowired
  private BCryptPasswordEncoder bcryptEncoder;

  private Gson gson = new Gson();

  @Autowired
  private EntityManager entityManager;

  /**
   *
   */
  public UserDaoTest() {

  }

  @Test
  public void testUserDao() {
    logger.info("userService user {}", gson.toJson(userService.getPortalUser("testUser")));
  }

  @Test
  public void testUserEmailDao() {
    assertTrue(userService.getUser("matteo", "matteo@telesoccorso-infamiglia.it") == null);
  }

  @Test
  public void testAllUsersDao() {
    logger.info("userService user {}", gson.toJson(userService.getAllUsers()));
  }

  @Test
  public void testJsonAllUsersDao() {
    logger.info("userService user {}", userService.jsonGetAllUsers());
  }

  @Test
  public void testAdmin() {
    PortalUser user = new PortalUser();
    user.setUsername("matteo");
    assertNotNull(userService.isAdmin(user));
  }

  @Test
  public void testSuperAdmin() {
    PortalUser user = new PortalUser();
    user.setUsername("admin");
    assertNotNull(userService.isSuperAdmin(user));
  }

  @Test
  public void testAdmin2() {
    PortalUser user = new PortalUser();
    user.setUsername("matteo");
    logger.info("test user {} Admin role: {}", user.getUsername(), userService.isAdmin(user));
  }

  @Test
  public void testAddUser() {
    userService.addUser("testUser", "testUser", "testUser@tsc.it", Role.ROLE_USER, false);
    // assertTrue(bcryptEncoder.matches("testUser", userService.getUser("testUser").getPassword()));
  }

  @Test
  public void testAddAdminUserWithMfa() {
    userService.addUser("admin", "adminTsc", "admin@infamiglia.it", Role.ROLE_ADMIN, true);
    // assertTrue(bcryptEncoder.matches("testUser", userService.getUser("testUser").getPassword()));
  }

  @Test
  public void testAddAdminUser() {
    userService.addUser("testUser", "testUser", "testUser@tsc.it", Role.ROLE_ADMIN, false);
    // assertTrue(bcryptEncoder.matches("testUser", userService.getUser("testUser").getPassword()));
  }



  @Test(expected = IllegalArgumentException.class)
  public void testAddUserWithoutPassword() {
    userService.addUser("testUser", "", "testUser@tsc.it", Role.ROLE_USER, false);
  }

  @Test
  public void testRemoveUser() {
    userService.removeUser("testUser", Role.ROLE_USER);
  }

  @Test
  public void testRemoveUserFail() {
    userService.removeUser("testUser", Role.ROLE_ADMIN);
  }

  @Test
  public void testUpdateUser() {
    userService.updateUser("testUser", "testUser", "testUser1@tsc.it", Role.ROLE_USER, false);
  }

  @Test
  public void testUpdateUserFailed() {
    userService.updateUser("testUser", "testUser2", "testUser@tsc.it", Role.ROLE_ADMIN, true);
  }

  @Test
  public void testUpdateMfaUserKey() {
    userService.updateMfaUserKey("admin", "testUser@tsc.it", "fwefwefwegeg");
  }

  @Test
  public void testUpdateEmptyAdminMfaUserKey() {
    userService.updateMfaUserKey("admin", "", "");
  }

  @Test
  public void testUpdateEmptyUsernMfaUserKey() {
    userService.updateMfaUserKey("testUser", "", "");
  }

  @Test
  public void jsonGestUser() {
    userService.jsonGetUser("admin");
    logger.info("user admin {}", userService.jsonGetUser("admin"));
  }

}
