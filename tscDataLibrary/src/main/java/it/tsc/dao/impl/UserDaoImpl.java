/**
 *
 */
package it.tsc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Row;

import it.tsc.dao.BaseDao;
import it.tsc.dao.UserDao;
import it.tsc.domain.PortalUser;
import it.tsc.domain.Role;
import it.tsc.domain.User;
import it.tsc.domain.key.UserKey;
import it.tsc.util.JsonUtil;
import it.tsc.util.UserTransform;

/**
 * @author astraservice
 *
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {
	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	/**
	 * to convert v
	 *
	 */
	public UserDaoImpl() {

	}

	@Override
	public String jsonGetUser(String username) {
		EntityManager entityManager = getEntityManager();
		TypedQuery<User> query = entityManager
				.createNamedQuery(User.SELECT_BY_USERNAME, User.class);
		query.setParameter("username", username);
		List<User> list = query.getResultList();
		// entityManager.close();

		String result = JsonUtil.getGsonConverter().toJson(list);
		logger.debug("jsonGetUser {}", result);
		return result;
	}

	/*
	 * extends CommonDao (non-Javadoc)
	 *
	 * @see it.tsc.dao.UserDao#getUserRole(java.lang.String)
	 */
	@Override
	public PortalUser getPortalUser(String username) {
		PortalUser PortalUser = null;

		EntityManager entityManager = getEntityManager();
		TypedQuery<User> query = entityManager
				.createNamedQuery(User.SELECT_BY_USERNAME, User.class);
		query.setParameter("username", username);
		List<User> list = query.getResultList();
		// entityManager.close();

		List<String> roles = new ArrayList<String>();

		String email = "";
		String password = "";
		String base32Secret = "";
		boolean mfaEnabled = true;
		for (User user : list) {
			email = user.getEmail();
			password = user.getPassword().trim();
			base32Secret = user.getBase32Secret();
			mfaEnabled = user.isMfaEnabled();
			roles.add(user.getKey().getRole());
		}
		if (roles != null && roles.size() > 0) {
			PortalUser = new PortalUser(username, password, roles, email,
					base32Secret, mfaEnabled);
		}
		return PortalUser;
	}

	@Override
	public PortalUser getUser(String username, String email) {
		PortalUser PortalUser = null;

		EntityManager entityManager = getEntityManager();
		TypedQuery<User> query = entityManager
				.createNamedQuery(User.SELECT_BY_USERNAME_EMAIL, User.class);
		query.setParameter("username", username);
		query.setParameter("email", email);
		List<User> list = query.getResultList();
		// entityManager.close();

		List<String> roles = new ArrayList<String>();
		for (User user : list) {
			roles.add(user.getKey().getRole());
		}
		if (roles != null && roles.size() > 0) {
			PortalUser = new PortalUser(username, roles, email);
		}
		return PortalUser;
	}

	@Override
	public List<PortalUser> getAllUsers() {
		// MappingManager manager = baseDao.getMappingManager();
		// PortalUserAccessor userAccessor =
		// manager.createAccessor(PortalUserAccessor.class);
		EntityManager entityManager = getEntityManager();
		TypedQuery<User> query = entityManager
				.createNamedQuery(User.SELECT_ALL_USERS, User.class);
		List<User> list = query.getResultList();
		// entityManager.close();

		UserTransform t = new UserTransform();
		for (User user : list) {
			t.addUser(user.getKey().getUsername(), user.getKey().getRole(),
					user.getEmail());
		}
		return t.getUsers();
	}

	@Override
	public String jsonGetAllUsers() {
		EntityManager entityManager = getEntityManager();
		TypedQuery<User> query = entityManager
				.createNamedQuery(User.SELECT_ALL_USERS, User.class);
		List<User> list = query.getResultList();
		// entityManager.close();

		String result = JsonUtil.getGsonConverter().toJson(list);
		logger.debug("jsonGetAllUsers {}", result);
		return result;
	}

	/*
	 * (non-Javadoc) extends CommonDao
	 *
	 * @see it.tsc.dao.UserDao#getUserRoles(java.lang.String,java.lang.String)
	 */
	@Override
	public List<GrantedAuthority> getUserRoles(String username) {
		List<GrantedAuthority> roles = null;
		EntityManager entityManager = getEntityManager();
		TypedQuery<User> query = entityManager
				.createNamedQuery(User.SELECT_BY_USERNAME, User.class);
		query.setParameter("username", username);
		List<User> list = query.getResultList();
		// entityManager.close();

		for (User user : list) {
			if (roles == null) {
				roles = new ArrayList<GrantedAuthority>();
			}
			roles.add(new SimpleGrantedAuthority(user.getKey().getRole()));
		}
		return roles;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.UserDao#isAdmin(it.tsc.model.Role)
	 */
	@Override
	public boolean isAdmin(Role role) {
		if (role != null) {
			return role.equals(Role.ROLE_ADMIN)
					|| role.equals(Role.ROLE_SADMIN);
		} else {
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.dao.UserDao#addUser(java.lang.String, java.lang.String,,
	 * java.lang.String it.tsc.model.Role)
	 */
	@Override
	public boolean addUser(String username, String password, String email,
			Role role, boolean mfaEnabled) {
		Validate.notEmpty(password, "Password cannot be empty");
		Validate.notEmpty(username, "username cannot be empty");
		Validate.notEmpty(email, "email cannot be empty");
		User user = new User(new UserKey(username, role),
				bcryptEncoder.encode(password).trim(), email, mfaEnabled);
		EntityManager entityManager = getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			entityManager.persist(user);
			entityManager.flush();
			logger.debug("result: {}", user);
			tx.commit();
			return true;
		} catch (Exception e) {
			logger.error("addUser: {}", e);
			tx.rollback();
			return false;
		}
	}

	/*
	 * (non-Javadoc) public List<GrantedAuthority> getUserRoles(String username,
	 * String password) { //
	 *
	 * @see it.tsc.dao.UserDao#removeUser(java.lang.String)
	 */
	@Override
	public boolean removeUser(String username, Role role) {
		boolean result = false;
		EntityManager entityManager = getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			Query query = entityManager
					.createNamedQuery(User.DELETE_BY_USERNAME_ROLE);
			query.setParameter("username", username);
			query.setParameter("role", role.name());
			result = query.executeUpdate() != 0 ? true : false;
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			logger.error("removeUser: {}", e);
		}
		return result;
	}

	@Override
	public void updateMfaUserKey(String username, String keyId,
			String base32Secret, String role) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			Query query = entityManager
					.createNamedQuery(User.UPDATE_BY_USERNAME_ROLE);
			query.setParameter("username", username);
			query.setParameter("role", role);
			query.setParameter("keyId", keyId.trim());
			query.setParameter("base32Secret", base32Secret.trim());
			query.executeUpdate();
			if (query.executeUpdate() == 0) {
				logger.error("Impossible to update user: ", username, keyId);
				throw new IllegalArgumentException("Impossible to update user");
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			logger.error("updateMfaUserKey: {}", e);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @Override public PortalUser getUser(String username, String email) { //
	 * TODO Auto-generated method stub return null; }*
	 *
	 * @see
	 * it.tsc.dao.UserDao#updateUser(java.lang.String,java.lang.String,java.
	 * lang. String,it.tsc.model. Role)
	 */
	@Override
	public void updateUser(String username, String password, String email,
			Role role, boolean mfaEnabled) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			Query query = entityManager.createNamedQuery(User.UPDATE_USER,
					User.class);
			query.setParameter("username", username);
			query.setParameter("password", bcryptEncoder.encode(password));
			query.setParameter("email", email);
			query.setParameter("role", role.toString());
			query.setParameter("mfaEnabled", mfaEnabled);
			int result = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			logger.error("updateUser: {}", e);
		}
	}

	/**
	 * map return result to JSON
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private String returnJson(Row row) {
		return row.getString("[json]");
	}

	@Override
	public List<User> getUser(String username) {
		EntityManager entityManager = getEntityManager();
		TypedQuery<User> query = entityManager
				.createNamedQuery(User.SELECT_BY_USERNAME, User.class);
		query.setParameter("username", username);
		return query.getResultList();
	}

}
